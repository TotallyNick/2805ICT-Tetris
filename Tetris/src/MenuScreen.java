import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JPanel {

    public MenuScreen(JFrame frame) {
        // Set up the panel layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Title label
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titleLabel);

        // Spacing
        add(Box.createRigidArea(new Dimension(0, 50)));

        // Buttons
        JButton playButton = new JButton("Play");
        JButton configButton = new JButton("Configuration");
        JButton highScoreButton = new JButton("HighScores");
        JButton exitButton = new JButton("Exit");

        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        configButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Button actions

        // Play Game
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Play");
            }
        });

        // Configuration Menu
        configButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new Configuration(frame));
                frame.validate();
            }
        });

        // High Score Menu
        highScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new HighScores(frame));
                frame.validate();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Close the application
            }
        });

        // Add buttons to the panel
        add(playButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(configButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(highScoreButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(exitButton);

        // Author label
        add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel authorLabel = new JLabel("Author: Nicholas Webster - 5178735");
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        authorLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        add(authorLabel);
    }

    public static void main(String[] args) {
        // Show the splash screen
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the splash screen
                JWindow splash = new JWindow();
                JPanel splashContent = new JPanel(new BorderLayout());
                splashContent.setBackground(Color.WHITE);

                JLabel splashImage = new JLabel(new ImageIcon("src/cat.png"));
                splashContent.add(splashImage, BorderLayout.CENTER);
                splash.setContentPane(splashContent);
                splash.pack();

                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screen.width - splash.getSize().width) / 2;
                int y = (screen.height - splash.getSize().height) / 2;
                splash.setLocation(x, y);
                splash.setVisible(true);

                // Set a timer to close the splash screen and show the main menu
                new Timer(4000, e -> {
                    splash.dispose();
                    // After the splash screen, show the main menu
                    JFrame frame = new JFrame();
                    frame.setTitle("Tetris - Menu Screen");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(550, 800);
                    frame.setLocationRelativeTo(null);

                    MenuScreen menu = new MenuScreen(frame);
                    frame.setContentPane(menu); // Set the content pane to your MenuScreen instance
                    frame.setVisible(true);
                }).start();
            }
        });
    }
}
