package org.jmat.Score.Resources;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestModParser {
    @Test
    void testMod(){
        assertEquals(16, new ModParser("HR").getModBitwise());
    }
    @Test
    void testMods(){
        assertEquals(80, new ModParser("HRDT").getModBitwise());
    }
    @Test
    void testNC(){
        assertEquals(513, new ModParser("NCNF").getModBitwise());
    }
    @Test
    void testGB(){
        assertEquals(0, new ModParser("GBTSKYSNOW").getModBitwise());
    }
    @Test
    void testEverything(){
        assertEquals(1073741823, new ModParser("NF HR DT HD TD 1K2K3K4K5K6K 7K8K9KEZTDSDRXATAPHTFLSOPFv2NCncncncncKCFIRDCntpkc").getModBitwise());
    }
    @Test
    public void testDefaultConstructor() {
        ModParser modParser = new ModParser();
        assertEquals(0, modParser.getModBitwise());
        assertEquals(1.0, modParser.getModMultiplier(), 0.0001); // Check if the default modMultiplier is 1.0
    }
    @Test
    public void testModMultiplierWithoutModifiers() {
        ModParser modParser = new ModParser("");
        assertEquals(1.0, modParser.getModMultiplier(), 0.0001); // Check if modMultiplier is 1.0 when no modifiers are present
    }

    @Test
    public void testModMultiplierWithModifiers() {
        ModParser modParser = new ModParser("EZDTFL");
        assertEquals(0.5 * 1.2 * 1.12, modParser.getModMultiplier(), 0.0001); // Check if modMultiplier is calculated correctly with modifiers
    }
    @Test
    public void testModMultiplierWithNC() {
        ModParser modParser = new ModParser("EZNCFLHR");
        assertEquals(0.5 * 1.2 * 1.12 * 1.1, modParser.getModMultiplier(), 0.0001); // Check if modMultiplier is calculated correctly with modifiers
    }

    @Test
    public void testModMultiplierWithAPRX() {
        ModParser modParser1 = new ModParser("RX");
        assertEquals(0.0, modParser1.getModMultiplier(), 0.0001); // Check if modMultiplier is 0 when RX modifier is present

        ModParser modParser2 = new ModParser("AP");
        assertEquals(0.0, modParser2.getModMultiplier(), 0.0001); // Check if modMultiplier is 0 when AP modifier is present

        ModParser modParser3 = new ModParser("RXAP");
        assertEquals(0.0, modParser3.getModMultiplier(), 0.0001); // Check if modMultiplier is 0 when both RX and AP modifiers are present
    }
}
