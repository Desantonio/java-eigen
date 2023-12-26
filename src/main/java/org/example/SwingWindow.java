package org.example;

import javax.swing.*;

public class SwingWindow {

    public static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        JLabel label = new JLabel("Hello, Swing!");
        label.setHorizontalAlignment(JLabel.CENTER);

        // Add the label to the content pane
        frame.getContentPane().add(label);

        // Set the size of the window
        frame.setSize(300, 200);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Display the window
        frame.setVisible(true);
    }
}
