package org.jmat.GUI.Panels;

import org.jmat.Score.Utilities.ModParser;
import org.jmat.Score.V2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OutputPanel {
    private final JPanel panel;
    private final JLabel outputLabel;
    private final InputPanel inputPanel;

    public OutputPanel(InputPanel inputPanel) {
        this.inputPanel = inputPanel;
        panel = new JPanel();
        outputLabel = new JLabel();
        JButton sender = new JButton("Calculate");

        sender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input values from InputPanel
                double accuracy = Double.parseDouble(inputPanel.getAccuracyTextField().getText());
                String mods = inputPanel.getModsTextField().getText();
                ModParser modParser = new ModParser(mods);
                V2 v2;
                try{
                    int combo = Integer.parseInt(inputPanel.getComboTextField().getText());
                    int maxCombo = Integer.parseInt(inputPanel.getMaxComboTextField().getText());
                    // Calculate the score
                    v2 = new V2(accuracy, combo, maxCombo, modParser);
                }catch(Exception ex){
                    v2 = new V2(accuracy, modParser);
                }

                double score = v2.getScore();

                // Update the output label with the calculated score
                outputLabel.setText("Score: " + score);
            }
        });

        panel.add(sender);
        panel.add(outputLabel);
    }

    public JPanel getPanel() {
        return panel;
    }
}
