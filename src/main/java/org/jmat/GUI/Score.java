package org.jmat.GUI;

import org.jmat.GUI.Panels.InputPanel;
import org.jmat.GUI.Panels.OutputPanel;

import javax.swing.*;
import java.awt.*;

public class Score extends JFrame {
    private InputPanel inputPanel;
    private OutputPanel outputPanel;
    private final ImageIcon img = new ImageIcon("src/main/java/org/jmat/GUI/v2.png");

    public Score() {
        initPanels();
        initComponents();
    }

    private void initPanels() {
        inputPanel = new InputPanel();
        outputPanel = new OutputPanel(inputPanel);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(inputPanel.getPanel());
        mainPanel.add(outputPanel.getPanel());

        this.add(mainPanel);
        this.setTitle("osu!V2 calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(img.getImage());
        this.setLocation(MouseInfo.getPointerInfo().getLocation());
        this.pack();
        this.setVisible(true);
    }
}
