package org.jmat.Score.Utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing osu! mods with their bitwise values.
 */
public enum OsuMod {
    _NF(1),
    _EZ(2),
    _TD(4),
    _HD(8),
    _HR(16),
    _SD(32),
    _DT(64),
    _RX(128),
    _HT(256),
    _NC(512),
    _FL(1024),
    _AT(2048),
    _SO(4096),
    _AP(8192),
    _PF(16384),
    _4K(32768),
    _5K(65536),
    _6K(131072),
    _7K(262144),
    _8K(524288),
    _FI(1048576),
    _RD(2097152),
    _CN(4194304),
    _TP(8388608),
    _9K(16777216),
    _KC(33554432),
    _1K(67108864),
    _3K(134217728),
    _2K(268435456),
    _V2(536870912);

    private final int bitwiseValue;
    private static final Map<String, OsuMod> modMap = new HashMap<>();

    static {
        for (OsuMod mod : OsuMod.values()) {
            modMap.put(mod.name().substring(1), mod);
        }
    }

    OsuMod(int bitwiseValue) {
        this.bitwiseValue = bitwiseValue;
    }

    public int getBitwiseValue() {
        return bitwiseValue;
    }

    public static OsuMod fromString(String mod) {
        return modMap.get(mod.toUpperCase());
    }
}
