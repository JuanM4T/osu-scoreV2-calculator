package org.jmat.Score.Utilities;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * The ModParser class parses a string of osu! mods and calculates bitwise representation and modifier multiplier.
 */
public class ModParser {

    private int modBitwise;
    private double modMultiplier = 1;

    /**
     * Constructs a ModParser object with the specified mods.
     *
     * @param mods The string of osu! mods to parse.
     */
    public ModParser(@NotNull String mods) {
        mods = mods.replace(" ", "");
        Set<String> modSet = new HashSet<>();
        for (int i = 0; i < mods.length() - 1; i += 2) {
            String mod = mods.substring(i, i + 2).toUpperCase();
            modSet.add("_"+mod);
        }
        for (String mod : modSet) {
            try {
                OsuMod osuMod = OsuMod.valueOf(mod);
                modBitwise |= osuMod.getBitwiseValue();
            } catch(IllegalArgumentException ignored){}
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
     * Handle mod names that start with a digit by adding an underscore.
     *
     * @param mod The mod name to handle.
     * @return The mod name with an underscore added if it starts with a digit.
     */
    private String handleModName(@NotNull String mod) {
        if (Character.isDigit(mod.charAt(0))) {
            return "_" + mod;
        }
        return mod;
    }

    /**
     * Gets the bitwise representation of the parsed mods.
     *
     * @return The bitwise representation of the parsed mods.
     */
    public int getModBitwise() {
        return modBitwise;
    }

    /**
     * Calculates the modifier multiplier based on the parsed mods.
     */
    private void calcModMultiplier() {
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
     *
     * @return The modifier multiplier calculated based on the parsed mods.
     */
    public double getModMultiplier() {
        return modMultiplier;
    }
}
