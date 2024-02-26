package org.jmat.Score;

import org.jetbrains.annotations.NotNull;
import org.jmat.Score.Utilities.ModParser;

/**
 * The V2 class represents a scoring system for osu! that calculates scores based on a formula that takes into account some factors
 * like acc, combo vs max combo and mods.
 * <p> </p>
 * It's objective it's to standardize osu! scoring system by soft-capping the scores to 1.000.000.
 * Mod multipliers can bypass this cap.
 */
public class V2 {
    private final int MAX_SCORE = 1000000, COMBO_WEIGHT = (int) (0.7*MAX_SCORE), ACC_WEIGHT = (int) (0.3*MAX_SCORE);
    private final double ACC_SCALE_DOWN = 10;
    private final double score;
    private double accuracy, modMultiplier;
    private int combo, maxCombo, modCombo;
    private ModParser mods;

    /**
     * Constructs a V2 object with the given accuracy, combo, max combo, and mod settings.
     *
     * @param accuracy The accuracy of the play.
     * @param combo The combo achieved in the play.
     * @param maxCombo The maximum combo achievable in the play.
     * @param mods The mod settings applied to the play.
     */
    public V2(double accuracy, int combo, int maxCombo, @NotNull ModParser mods){
        this.modMultiplier = mods.getModMultiplier();
        this.modCombo = mods.getModBitwise();
        this.accuracy = accuracy;
        this.combo = combo;
        this.maxCombo = maxCombo;
        score =  ((COMBO_WEIGHT * ((double) combo / maxCombo)) + ACC_WEIGHT * (Math.pow(accuracy, ACC_SCALE_DOWN))) * modMultiplier;
    }
    /**
     * Constructs a V2 object with the given accuracy and mod settings.
     * <p>
     * This constructor sets the combo and max combo to 1 by default.
     *
     * @param accuracy The accuracy of the play.
     * @param mods     The mod settings applied to the play.
     */
    public V2(double accuracy, ModParser mods){ this(accuracy, 1, 1, mods); }

    /**
     * Gets the modifier multiplier applied in the scoring calculation.
     *
     * @return The modifier multiplier.
     */
    public double getModMultiplier() {
        return modMultiplier;
    }
    /**
     * Gets the mod combination represented in bitwise.
     *
     * @return The mod combination in bitwise.
     */
    public int getModCombo() {
        return modCombo;
    }
    /**
     * Gets the accuracy scale down factor used in the scoring calculation.
     *
     * @return The accuracy scale down factor.
     */
    public double getAccScaleDown() {
        return ACC_SCALE_DOWN;
    }
    /**
     * Gets the accuracy of the play.
     *
     * @return The accuracy.
     */
    public double getAccuracy() {
        return accuracy;
    }
    /**
     * Gets the score achieved in the play.
     *
     * @return The score.
     */
    public double getScore() {
        return score;
    }
    /**
     * Gets the current combo achieved in the play.
     *
     * @return The combo.
     */
    public int getCombo() {
        return combo;
    }
    /**
     * Gets the maximum combo achievable in the play.
     *
     * @return The maximum combo achievable.
     */
    public int getMaxCombo() {
        return maxCombo;
    }
    /**
     * Gets the maximum possible score achievable.
     *
     * @return The maximum score.
     */
    public int getMaxScore() {
        return MAX_SCORE;
    }
    /**
     * Gets the weight assigned to combo in the scoring calculation.
     *
     * @return The combo weight.
     */
    public int getComboWeight() {
        return COMBO_WEIGHT;
    }
    /**
     * Gets the weight assigned to accuracy in the scoring calculation.
     *
     * @return The accuracy weight.
     */
    public int getAccWeight() {
        return ACC_WEIGHT;
    }
    /**
     * Sets the accuracy of the play.
     *
     * @param accuracy The accuracy to set.
     */
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
    /**
     * Sets the current combo achieved in the play.
     *
     * @param combo The combo to set.
     */
    public void setCombo(int combo) {
        this.combo = combo;
    }
    /**
     * Sets the maximum combo achievable in the play.
     *
     * @param maxCombo The maximum combo to set.
     */
    public void setMaxCombo(int maxCombo) {
        this.maxCombo = maxCombo;
    }
    /**
     * Sets the mod settings applied to the play.
     *
     * @param mods The mod settings to set.
     */
    public void setMods(ModParser mods) {
        this.mods = mods;
        this.modMultiplier = mods.getModMultiplier();
        this.modCombo = mods.getModBitwise();
    }
}
