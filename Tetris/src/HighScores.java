import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class HighScores extends JPanel {

    public HighScores(JFrame frame) {
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("High Scores", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Table for displaying scores
        String[] columnNames = {"First Name", "Score"};
        Object[][] data = {
                {"Alice", 659851},
                {"Bob", 623453},
                {"Charlie", 598654},
                {"Diana", 572246},
                {"Edward", 549885},
                {"Fiona", 518631},
                {"George", 483323},
                {"Hannah", 457947},
                {"Ian", 422232},
                {"Jane", 400230}
        };
        JTable scoreTable = new JTable(data, columnNames);
        scoreTable.setFillsViewportHeight(true);

        // Table Formatting
        scoreTable.setShowGrid(false);
        scoreTable.setIntercellSpacing(new Dimension(0, 0));
        scoreTable.setRowHeight(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        scoreTable.setDefaultRenderer(Object.class, centerRenderer);
        JScrollPane scrollPane = new JScrollPane(scoreTable);
        add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30)); // Smaller button size
        backButton.addActionListener(e -> {
            frame.setContentPane(new MenuScreen(frame)); // Go back to the main menu
            frame.validate();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
