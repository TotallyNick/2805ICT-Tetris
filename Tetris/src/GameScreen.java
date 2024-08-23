import javax.swing.*;

public class GameScreen {

    private JFrame frame;
    private Board board;

    public GameScreen() {
        frame = new JFrame("Tetris - Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Add Game Board to the Game Screen
        board = new Board();
        frame.add(board);
        frame.setVisible(true);


        frame.setVisible(true);


    }

    public static void main(String[] args){
        new GameScreen();

    }
}
