package org.jmat.Score;

import org.jmat.Score.Utilities.ModParser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestV2 {
    @Test
    void testGetScore() {
        ModParser mods = new ModParser("DT");
        V2 v2 = new V2(0.9, 100, 200, mods);
        assertEquals(545524.24, v2.getScore(),0.01, "Score calculation is incorrect");
    }

    @Test
    void testGetModMultiplier() {
        ModParser mods = new ModParser("HR");
        V2 v2 = new V2(0.8, 50, 100, mods);
        assertEquals(1.1, v2.getModMultiplier(), "Mod multiplier is incorrect");
    }

    @Test
    void testGetModCombo() {
        ModParser mods = new ModParser("HRDT");
        V2 v2 = new V2(0.85, 70, 150, mods);
        assertEquals(80, v2.getModCombo(), "Mod combo is incorrect");
    }

    @Test
    void testGetAccScaleDown() {
        V2 v2 = new V2(0.75, 80, 200, new ModParser());
        assertEquals(10, v2.getAccScaleDown(), "Accuracy scale down factor is incorrect");
    }

    @Test
    void testGetAccuracy() {
        V2 v2 = new V2(0.85, 90, 200, new ModParser());
        assertEquals(0.85, v2.getAccuracy(), "Accuracy is incorrect");
    }

    @Test
    void testGetCombo() {
        V2 v2 = new V2(0.9, 100, 200, new ModParser());
        assertEquals(100, v2.getCombo(), "Combo is incorrect");
    }

    @Test
    void testGetMaxScore() {
        V2 v2 = new V2(0.95, 110, 200, new ModParser());
        assertEquals(1000000, v2.getMaxScore(), "Max score is incorrect");
    }

    @Test
    void testGetComboWeight() {
        V2 v2 = new V2(0.95, 110, 200, new ModParser());
        assertEquals(700000, v2.getComboWeight(), "Combo weight is incorrect");
    }

    @Test
    void testGetAccWeight() {
        V2 v2 = new V2(0.95, 110, 200, new ModParser());
        assertEquals(300000, v2.getAccWeight(), "Accuracy weight is incorrect");
    }

    @Test
    void testSetAccuracy() {
        V2 v2 = new V2(0.9, 100, 200, new ModParser());
        v2.setAccuracy(0.85);
        assertEquals(0.85, v2.getAccuracy(), "Accuracy setting is incorrect");
    }

    @Test
    void testSetCombo() {
        V2 v2 = new V2(0.9, 100, 200, new ModParser());
        v2.setCombo(120);
        assertEquals(120, v2.getCombo(), "Combo setting is incorrect");
    }

    @Test
    void testSetMaxCombo() {
        V2 v2 = new V2(0.9, 100, 200, new ModParser());
        v2.setMaxCombo(250);
        assertEquals(250, v2.getMaxCombo(), "Max combo setting is incorrect");
    }

    @Test
    void testSetMods() {
        V2 v2 = new V2(0.9, 100, 200, new ModParser());
        ModParser mods = new ModParser("HR");
        v2.setMods(mods);
        assertEquals(1.1, v2.getModMultiplier(), "Mod settings setting is incorrect");
    }
    @Test
    void testSetMods2() {
        V2 v2 = new V2(0.9, 100, 200, new ModParser("HR"));
        ModParser mods = new ModParser("HDDT");
        v2.setMods(mods);
        assertEquals(1.27, v2.getModMultiplier(),0.01, "Mod settings setting is incorrect");
    }
}
