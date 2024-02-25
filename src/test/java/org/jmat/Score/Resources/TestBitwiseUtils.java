package org.jmat.Score.Resources;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBitwiseUtils {
    @Test
    public void testIsBitSet() {
        // Test when the bit is set
        assertTrue(BitwiseUtils.isBitSet(4, 2)); // 4 in binary: 100, bit 2 is set

        // Test when the bit is not set
        assertFalse(BitwiseUtils.isBitSet(4, 1)); // 4 in binary: 100, bit 1 is not set

        // Test with different numbers and bits
        assertTrue(BitwiseUtils.isBitSet(8, 3)); // 8 in binary: 1000, bit 3 is set
        assertFalse(BitwiseUtils.isBitSet(8, 2)); // 8 in binary: 1000, bit 2 is not set

        assertTrue(BitwiseUtils.isBitSet(5, 0)); // 5 in binary: 101, bit 0 is set
        assertFalse(BitwiseUtils.isBitSet(5, 1)); // 5 in binary: 101, bit 1 is not set

        assertTrue(BitwiseUtils.isBitSet(0b101010, 1)); // 0b101010 in binary: 101010, bit 1 is set
        assertFalse(BitwiseUtils.isBitSet(0b101010, 2)); // 0b101010 in binary: 101010, bit 2 is not set
    }
}
