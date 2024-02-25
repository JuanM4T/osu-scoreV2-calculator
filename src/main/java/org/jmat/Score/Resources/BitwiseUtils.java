package org.jmat.Score.Resources;

/**
 * Utility class for bitwise operations.
 */
public class BitwiseUtils {

    /**
     * Checks if the specified bit is set in the given number.
     *
     * @param num The number to check.
     * @param bit The bit position to check (0-based).
     * @return {@code true} if the bit is set, {@code false} otherwise.
     */
    public static boolean isBitSet(int num, int bit) {
        return (num & (1 << bit)) != 0;
    }
}