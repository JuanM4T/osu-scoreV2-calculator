package org.jmat;

import org.jmat.GUI.Score;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Score gui = new Score();
        });
    }
}
