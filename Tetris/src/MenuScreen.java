import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Menu Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the window

        // Create a panel to hold the title, buttons, and author text
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add a title to the menu
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space above the title
        panel.add(titleLabel);

        // Add some vertical spacing between title and buttons
        panel.add(Box.createRigidArea(new Dimension(0, 50)));

        // Create buttons
        JButton playButton = new JButton("Play");
        JButton configButton = new JButton("Configuration");
        JButton highscoreButton = new JButton("Highscore");
        JButton exitButton = new JButton("Exit");

        // Set button alignment
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        configButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        highscoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listeners to the buttons
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Play");
            }
        });

        configButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Configuration");
            }
        });

        highscoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Highscore");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Exit");
            }
        });

        // Add buttons to the panel
        panel.add(playButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between buttons
        panel.add(configButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(highscoreButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(exitButton);

        // Add some vertical spacing before the author text
        panel.add(Box.createRigidArea(new Dimension(0, 50)));

        // Add author subtext
        JLabel authorLabel = new JLabel("Author: Nicholas Webster");
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        authorLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        panel.add(authorLabel);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
