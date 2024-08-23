import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tetris - Menu Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 800);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(titleLabel);


        panel.add(Box.createRigidArea(new Dimension(0, 50)));


        JButton playButton = new JButton("Play");
        JButton configButton = new JButton("Configuration");
        JButton HighScoreButton = new JButton("HighScores");
        JButton exitButton = new JButton("Exit");


        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        configButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        HighScoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


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

        HighScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "HighScore");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Exit");
            }
        });


        panel.add(playButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(configButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(HighScoreButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(exitButton);

        panel.add(Box.createRigidArea(new Dimension(0, 50)));

        JLabel authorLabel = new JLabel("Author: Nicholas Webster - 5178735");
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        authorLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        panel.add(authorLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
