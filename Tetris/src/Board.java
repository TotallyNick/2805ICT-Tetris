import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {

    public static final int BOARD_WIDTH = 10, BOARD_HEIGHT = 20;
    public static final int BLOCK_SIZE = 30;
    private Timer looper;
    private Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];

    private Color[][] shape = {
            {Color.red, Color.red, Color.red},
            {null, Color.red, null}
    };

    public Board() {
        looper = new Timer(500, new ActionListener() {
            int n = 0;
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(n++);
            }
        });
        looper.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Background
        g.setColor(Color.black);
        g.fillRect(0,0, getWidth(), getHeight());

        // Draw Shape Red Rectangle
        for (int row = 0; row < shape.length; row++){
            for(int col = 0; col < shape[0].length; col++) {
                //Checks the Shapes make up
                if (shape[row][col] != null) {
                    g.setColor(shape[row][col]);
                    g.fillRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        //Board
        g.setColor(Color.white);
            // Horizontal Lines of the board
        for (int row = 0; row <= BOARD_HEIGHT; row++){
            g.drawLine(0, BLOCK_SIZE * row, BLOCK_SIZE * BOARD_WIDTH, BLOCK_SIZE * row);
        }
            // Vertical Lines of the board
        for (int col = 0; col <= BOARD_WIDTH; col++) {
            g.drawLine(col * BLOCK_SIZE, 0, col * BLOCK_SIZE, BLOCK_SIZE * BOARD_HEIGHT );
        }

    }
}
