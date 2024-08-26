import javax.swing.*;
import java.awt.*;

public class Configuration extends JPanel {

    public Configuration(JFrame frame) {
        // Set up the panel layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create a panel for controls
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints controlsGbc = new GridBagConstraints();
        controlsGbc.insets = new Insets(5, 5, 5, 5);
        controlsGbc.anchor = GridBagConstraints.WEST;
        controlsGbc.fill = GridBagConstraints.HORIZONTAL;

        // Field Width
        JLabel fieldWidthLabel = new JLabel("Field Width:");
        JSlider fieldWidthSlider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10); // Min, Max, Default
        fieldWidthSlider.setMajorTickSpacing(5);
        fieldWidthSlider.setMinorTickSpacing(1);
        fieldWidthSlider.setPaintTicks(true);
        fieldWidthSlider.setPaintLabels(true);
        fieldWidthSlider.setPreferredSize(new Dimension(300, 50)); // Longer slider size

        controlsGbc.gridy = 0;
        controlsPanel.add(fieldWidthLabel, controlsGbc);

        controlsGbc.gridy = 1;
        controlsPanel.add(fieldWidthSlider, controlsGbc);

        // Field Height
        JLabel fieldHeightLabel = new JLabel("Field Height:");
        JSlider fieldHeightSlider = new JSlider(JSlider.HORIZONTAL, 15, 30, 20); // Min, Max, Default
        fieldHeightSlider.setMajorTickSpacing(5);
        fieldHeightSlider.setMinorTickSpacing(1);
        fieldHeightSlider.setPaintTicks(true);
        fieldHeightSlider.setPaintLabels(true);
        fieldHeightSlider.setPreferredSize(new Dimension(300, 50)); // Longer slider size

        controlsGbc.gridy = 2;
        controlsPanel.add(fieldHeightLabel, controlsGbc);

        controlsGbc.gridy = 3;
        controlsPanel.add(fieldHeightSlider, controlsGbc);

        // Game Level
        JLabel gameLevelLabel = new JLabel("Game Level:");
        JSlider gameLevelSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 2); // Min, Max, Default
        gameLevelSlider.setMajorTickSpacing(1);
        gameLevelSlider.setMinorTickSpacing(1);
        gameLevelSlider.setPaintTicks(true);
        gameLevelSlider.setPaintLabels(true);
        gameLevelSlider.setPreferredSize(new Dimension(300, 50)); // Longer slider size

        controlsGbc.gridy = 4;
        controlsPanel.add(gameLevelLabel, controlsGbc);

        controlsGbc.gridy = 5;
        controlsPanel.add(gameLevelSlider, controlsGbc);

        // Music Toggle
        JLabel musicLabel = new JLabel("Music:");
        JToggleButton musicToggle = new JToggleButton("On");
        musicToggle.setPreferredSize(new Dimension(100, 40)); // Smaller button size
        musicToggle.addActionListener(e -> musicToggle.setText(musicToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 6;
        controlsPanel.add(musicLabel, controlsGbc);

        controlsGbc.gridy = 7;
        controlsPanel.add(musicToggle, controlsGbc);

        // Sound Effect Toggle
        JLabel soundEffectLabel = new JLabel("Sound Effect:");
        JToggleButton soundEffectToggle = new JToggleButton("On");
        soundEffectToggle.setPreferredSize(new Dimension(100, 40)); // Smaller button size
        soundEffectToggle.addActionListener(e -> soundEffectToggle.setText(soundEffectToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 8;
        controlsPanel.add(soundEffectLabel, controlsGbc);

        controlsGbc.gridy = 9;
        controlsPanel.add(soundEffectToggle, controlsGbc);

        // AI Play Toggle
        JLabel aiPlayLabel = new JLabel("AI Play:");
        JToggleButton aiPlayToggle = new JToggleButton("On");
        aiPlayToggle.setPreferredSize(new Dimension(100, 40)); // Smaller button size
        aiPlayToggle.addActionListener(e -> aiPlayToggle.setText(aiPlayToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 10;
        controlsPanel.add(aiPlayLabel, controlsGbc);

        controlsGbc.gridy = 11;
        controlsPanel.add(aiPlayToggle, controlsGbc);

        // Extend Mode Toggle
        JLabel extendModeLabel = new JLabel("Extend Mode:");
        JToggleButton extendModeToggle = new JToggleButton("On");
        extendModeToggle.setPreferredSize(new Dimension(100, 40)); // Smaller button size
        extendModeToggle.addActionListener(e -> extendModeToggle.setText(extendModeToggle.isSelected() ? "On" : "Off"));

        controlsGbc.gridy = 12;
        controlsPanel.add(extendModeLabel, controlsGbc);

        controlsGbc.gridy = 13;
        controlsPanel.add(extendModeToggle, controlsGbc);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40)); // Smaller button size
        backButton.addActionListener(e -> {
            frame.setContentPane(new MenuScreen(frame)); // Go back to the main menu
            frame.validate();
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(controlsPanel, gbc);

        gbc.gridy = 14;
        gbc.gridwidth = 1;
        add(backButton, gbc);
    }
}
