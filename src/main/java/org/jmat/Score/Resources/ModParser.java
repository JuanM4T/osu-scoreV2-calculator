package org.jmat.Score.Resources;

import org.jetbrains.annotations.NotNull;

/**
 * The ModParser class parses a string of osu! mods and calculates bitwise representation and modifier multiplier.
 */
public class ModParser {

    private String mods;
    private int modBitwise;
    double modMultiplier = 1;

    /**
     * Constructs a ModParser object with the specified mods.
     * @param mods The string of osu! mods to parse.
     */
    public ModParser(@NotNull String mods){
        mods = mods.replace(" ", "");
        for (int i = 0; i < mods.length()/2; i++) { //always even
            String mod = mods.substring(2 * i, 2 * i + 2).toUpperCase();
            switch(mod){ //big switch
                case "NF": modBitwise |= 1; break;
                case "EZ": modBitwise |= 2; break;
                case "TD": modBitwise |= 4; break;
                case "HD": modBitwise |= 8; break;
                case "HR": modBitwise |= 16; break;
                case "SD": modBitwise |= 32; break;
                case "DT": modBitwise |= 64; break;
                case "RX": modBitwise |= 128; break;
                case "HT": modBitwise |= 256; break;
                case "NC": modBitwise |= 512; break;// Only set along with DoubleTime. i.e: NC only gives 576
                case "FL": modBitwise |= 1024; break;
                case "AT": modBitwise |= 2048; break;
                case "SO": modBitwise |= 4096; break;
                case "AP": modBitwise |= 8192; break;  // Autopilot
                case "PF": modBitwise |= 16384; break;// Only set along with SuddenDeath. i.e: PF only gives 16416
                case "4K": modBitwise |= 32768; break;
                case "5K": modBitwise |= 65536; break;
                case "6K": modBitwise |= 131072; break;
                case "7K": modBitwise |= 262144; break;
                case "8K": modBitwise |= 524288; break;
                case "FI": modBitwise |= 1048576; break;
                case "RD": modBitwise |= 2097152; break;
                case "CN": modBitwise |= 4194304; break;
                case "TP": modBitwise |= 8388608; break;
                case "9K": modBitwise |= 16777216; break;
                case "KC": modBitwise |= 33554432; break;
                case "1K": modBitwise |= 67108864; break;
                case "3K": modBitwise |= 134217728; break;
                case "2K": modBitwise |= 268435456; break;
                case "V2": modBitwise |= 536870912; break;
                default: break;
            }
        }
        calcModMultiplier();
    }

    /**
     * Constructs a ModParser object with no mods.
     */
    public ModParser() {
        modBitwise &= 0;
    }

    /**
     * Gets the bitwise representation of the parsed mods.
     * @return The bitwise representation of the parsed mods.
     */
    public int getModBitwise() {
        return modBitwise;
    }

    /**
     * Calculates the modifier multiplier based on the parsed mods.
     */
    private void calcModMultiplier(){
        if (BitwiseUtils.isBitSet(modBitwise, 13) || BitwiseUtils.isBitSet(modBitwise, 7)) modMultiplier = 0; // AP or RX
        else {
            if (BitwiseUtils.isBitSet(modBitwise, 1)) modMultiplier *= 0.5; // EZ
            if (BitwiseUtils.isBitSet(modBitwise, 2)) modMultiplier *= 1.2; // TD
            if (BitwiseUtils.isBitSet(modBitwise, 3)) modMultiplier *= 1.06; // HD
            if (BitwiseUtils.isBitSet(modBitwise, 4)) modMultiplier *= 1.1; // HR
            if (BitwiseUtils.isBitSet(modBitwise, 6) || BitwiseUtils.isBitSet(modBitwise, 9)) modMultiplier *= 1.2; // DT or NC
            if (BitwiseUtils.isBitSet(modBitwise, 8)) modMultiplier *= 0.3; // HT
            if (BitwiseUtils.isBitSet(modBitwise, 10)) modMultiplier *= 1.12; // FL
            if (BitwiseUtils.isBitSet(modBitwise, 12)) modMultiplier *= 0.9; // SO
        }
    }

    /**
     * Gets the modifier multiplier calculated based on the parsed mods.
     * @return The modifier multiplier calculated based on the parsed mods.
     */
    public double getModMultiplier() {
        return modMultiplier;
    }
}
