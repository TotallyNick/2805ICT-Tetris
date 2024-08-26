import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {

    public SplashScreen() {
        // Create a panel for the splash screen content
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.WHITE);

        // Set up an image for the splash screen (optional)
        JLabel splashImage = new JLabel(new ImageIcon("src/tetris.png"));

        content.add(splashImage, BorderLayout.CENTER);

        // Add the content panel to the window
        this.setContentPane(content);
        this.pack();

        // Center the splash screen on the screen
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - this.getSize().width) / 2;
        int y = (screen.height - this.getSize().height) / 2;
        this.setLocation(x, y);

        // Make the splash screen visible
        this.setVisible(true);

        // Set a timer to close the splash screen after 4 seconds
        new Timer(4000, e -> {
            this.dispose();
            // After the splash screen, show the main menu
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame();
                frame.setTitle("Tetris - Menu Screen");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(550, 800);
                frame.setLocationRelativeTo(null);
                frame.setContentPane(new MenuScreen(frame));
                frame.setVisible(true);
            });
        }).start();
    }

    public static void main(String[] args) {
        // Show the splash screen
        SwingUtilities.invokeLater(SplashScreen::new);
    }
}
