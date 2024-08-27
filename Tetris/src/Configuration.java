import javax.swing.*;
import java.awt.*;

public class Configuration extends JPanel {

    public Configuration(JFrame frame) {
        setLayout(new BorderLayout());

        // Table Formatting
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints controlsGbc = new GridBagConstraints();
        controlsGbc.insets = new Insets(10, 10, 10, 10);
        controlsGbc.anchor = GridBagConstraints.WEST;
        controlsGbc.fill = GridBagConstraints.HORIZONTAL;

        // Field Width
        JLabel fieldWidthLabel = new JLabel("Field Width:");
        JSlider fieldWidthSlider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
        fieldWidthSlider.setMajorTickSpacing(5);
        fieldWidthSlider.setMinorTickSpacing(1);
        fieldWidthSlider.setPaintTicks(true);
        fieldWidthSlider.setPaintLabels(true);
        fieldWidthSlider.setPreferredSize(new Dimension(300, 50));

        controlsGbc.gridy = 0;
        controlsPanel.add(fieldWidthLabel, controlsGbc);

        controlsGbc.gridy = 1;
        controlsPanel.add(fieldWidthSlider, controlsGbc);

        // Field Height
        JLabel fieldHeightLabel = new JLabel("Field Height:");
        JSlider fieldHeightSlider = new JSlider(JSlider.HORIZONTAL, 15, 30, 20);
        fieldHeightSlider.setMajorTickSpacing(5);
        fieldHeightSlider.setMinorTickSpacing(1);
        fieldHeightSlider.setPaintTicks(true);
        fieldHeightSlider.setPaintLabels(true);
        fieldHeightSlider.setPreferredSize(new Dimension(300, 50));

        controlsGbc.gridy = 2;
        controlsPanel.add(fieldHeightLabel, controlsGbc);

        controlsGbc.gridy = 3;
        controlsPanel.add(fieldHeightSlider, controlsGbc);

        // Game Level
        JLabel gameLevelLabel = new JLabel("Game Level:");
        JSlider gameLevelSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 2);
        gameLevelSlider.setMajorTickSpacing(1);
        gameLevelSlider.setMinorTickSpacing(1);
        gameLevelSlider.setPaintTicks(true);
        gameLevelSlider.setPaintLabels(true);
        gameLevelSlider.setPreferredSize(new Dimension(300, 50));

        controlsGbc.gridy = 4;
        controlsPanel.add(gameLevelLabel, controlsGbc);

        controlsGbc.gridy = 5;
        controlsPanel.add(gameLevelSlider, controlsGbc);

        // Music Toggle
        JLabel musicLabel = new JLabel("Music:");
        JToggleButton musicToggle = new JToggleButton("On");
        musicToggle.setPreferredSize(new Dimension(100, 40));
        musicToggle.addActionListener(e -> musicToggle.setText(musicToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 6;
        controlsPanel.add(musicLabel, controlsGbc);

        controlsGbc.gridy = 7;
        controlsPanel.add(musicToggle, controlsGbc);

        // Sound Effect Toggle
        JLabel soundEffectLabel = new JLabel("Sound Effect:");
        JToggleButton soundEffectToggle = new JToggleButton("On");
        soundEffectToggle.setPreferredSize(new Dimension(100, 40));
        soundEffectToggle.addActionListener(e -> soundEffectToggle.setText(soundEffectToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 8;
        controlsPanel.add(soundEffectLabel, controlsGbc);

        controlsGbc.gridy = 9;
        controlsPanel.add(soundEffectToggle, controlsGbc);

        // AI Play Toggle
        JLabel aiPlayLabel = new JLabel("AI Play:");
        JToggleButton aiPlayToggle = new JToggleButton("On");
        aiPlayToggle.setPreferredSize(new Dimension(100, 40));
        aiPlayToggle.addActionListener(e -> aiPlayToggle.setText(aiPlayToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 10;
        controlsPanel.add(aiPlayLabel, controlsGbc);

        controlsGbc.gridy = 11;
        controlsPanel.add(aiPlayToggle, controlsGbc);

        // Extend Mode Toggle
        JLabel extendModeLabel = new JLabel("Extend Mode:");
        JToggleButton extendModeToggle = new JToggleButton("On");
        extendModeToggle.setPreferredSize(new Dimension(100, 40));
        extendModeToggle.addActionListener(e -> extendModeToggle.setText(extendModeToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 12;
        controlsPanel.add(extendModeLabel, controlsGbc);

        controlsGbc.gridy = 13;
        controlsPanel.add(extendModeToggle, controlsGbc);
        add(controlsPanel, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40));

        // Panel to center the back button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);

        // Add the button panel to the bottom of the main panel
        add(buttonPanel, BorderLayout.SOUTH);

        // Back Button action
        backButton.addActionListener(e -> {
            frame.setContentPane(new MenuScreen(frame)); // Go back to the main menu
            frame.validate();
        });
    }
}
