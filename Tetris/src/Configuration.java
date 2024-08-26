import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Configuration extends JPanel {

    private JFrame frame;

    public Configuration(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JButton backButton = new JButton("Back to Main Panel");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new MenuScreen(frame));
                frame.validate();
            }
        });

        add(backButton, BorderLayout.SOUTH);
    }
}
