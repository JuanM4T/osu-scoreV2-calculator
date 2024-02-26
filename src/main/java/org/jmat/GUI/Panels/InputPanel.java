package org.jmat.GUI.Panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class InputPanel {
    private final JPanel panel;

    // Declare JTextField components as instance fields
    private JTextField accuracyGet;
    private JTextField comboGet;
    private JTextField maxComboGet;
    private JTextField modsGet;

    public InputPanel() {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        accuracyGet = new JTextField(10);
        comboGet = new JTextField(10);
        maxComboGet = new JTextField(10);
        modsGet = new JTextField(10);
        JLabel accuracy = new JLabel("Accuracy: ");
        JLabel combo = new JLabel("Combo: ");
        JLabel maxCombo = new JLabel("Max combo: ");
        JLabel mods = new JLabel("Mods combination: ");
        panel.add(accuracy);
        panel.add(accuracyGet);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(combo);
        panel.add(comboGet);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(maxCombo);
        panel.add(maxComboGet);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(mods);
        panel.add(modsGet);
    }

    public JPanel getPanel() {
        return panel;
    }

    // Getter methods for JTextField components
    public JTextField getAccuracyTextField() {
        return accuracyGet;
    }

    public JTextField getComboTextField() {
        return comboGet;
    }

    public JTextField getMaxComboTextField() {
        return maxComboGet;
    }

    public JTextField getModsTextField() {
        return modsGet;
    }
}
