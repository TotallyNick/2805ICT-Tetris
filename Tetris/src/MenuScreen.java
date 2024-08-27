import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel {
    public MenuScreen(JFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titleLabel);
        add(Box.createRigidArea(new Dimension(0, 50)));
        JButton playButton = new JButton("Play");
        JButton configButton = new JButton("Configuration");
        JButton highScoreButton = new JButton("HighScores");
        JButton exitButton = new JButton("Exit");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        configButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Play Game
        playButton.addActionListener(e -> {
            TetrisGame gamePanel = new TetrisGame(frame);
            frame.add(gamePanel);
            frame.setContentPane(gamePanel);
            frame.revalidate();
            frame.repaint();
            gamePanel.requestFocusInWindow();
        });

        // Configuration Menu
        configButton.addActionListener(e -> {
            Configuration configPanel = new Configuration(frame);
            frame.setContentPane(configPanel);
            frame.revalidate();
            frame.repaint();
            configPanel.requestFocusInWindow();
        });

        // High Score Menu
        highScoreButton.addActionListener(e -> {
            HighScores highScoresPanel = new HighScores(frame);
            frame.setContentPane(highScoresPanel);
            frame.revalidate();
            frame.repaint();
            highScoresPanel.requestFocusInWindow();
        });

        // Exit
        exitButton.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });

        add(playButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(configButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(highScoreButton);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(exitButton);
        add(Box.createRigidArea(new Dimension(0, 50)));
        JLabel authorLabel = new JLabel("Author: Nicholas Webster - 5178735");
        authorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        authorLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        add(authorLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JWindow splash = new JWindow();
            JPanel splashContent = new JPanel(new BorderLayout());
            splashContent.setBackground(Color.WHITE);
            ImageIcon splashIcon = new ImageIcon("src/tetris.png");
            JLabel splashImage = new JLabel(splashIcon);
            splashImage.setHorizontalAlignment(SwingConstants.CENTER);
            splashContent.add(splashImage, BorderLayout.CENTER);
            splash.setContentPane(splashContent);
            splash.pack();
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screen.width - splash.getSize().width) / 2;
            int y = (screen.height - splash.getSize().height) / 2;
            splash.setLocation(x, y);
            splash.setVisible(true);
            Timer timer = new Timer(4000, e -> {
                splash.dispose();
                JFrame frame = new JFrame();
                frame.setTitle("Tetris - Menu Screen");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(550, 800);
                frame.setLocationRelativeTo(null);
                MenuScreen menu = new MenuScreen(frame);
                frame.setContentPane(menu);
                frame.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        });
    }
}
