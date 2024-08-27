import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

enum Shape {
    I, J, L, O, S, T, Z
}

class Tetromino {
    private int[][] coordinates;
    private final Color color;

    private static final int[][][] SHAPES = {
            {{1, 1, 1, 1}},
            {{1, 1, 1}, {0, 0, 1}},
            {{1, 1, 1}, {1, 0, 0}},
            {{1, 1}, {1, 1}},
            {{0, 1, 1}, {1, 1, 0}},
            {{0, 1, 0}, {1, 1, 1}},
            {{1, 1, 0}, {0, 1, 1}}
    };

    public Tetromino() {
        Random rand = new Random();
        Shape shape = Shape.values()[rand.nextInt(Shape.values().length)];
        this.coordinates = SHAPES[shape.ordinal()];
        this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void rotate() {
        int[][] newCoordinates = new int[coordinates[0].length][coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                newCoordinates[j][coordinates.length - 1 - i] = coordinates[i][j];
            }
        }
        coordinates = newCoordinates;
    }
}

class Board {
    private final int width = 10;
    private final int height = 20;
    private final Color[][] grid;

    public Board() {
        grid = new Color[height][width];
    }

    public boolean canPlaceTetrimino(Tetromino tetromino, int x, int y) {
        for (int i = 0; i < tetromino.getCoordinates().length; i++) {
            for (int j = 0; j < tetromino.getCoordinates()[i].length; j++) {
                if (tetromino.getCoordinates()[i][j] == 1) {
                    if (x + j < 0 || x + j >= width || y + i >= height || (y + i >= 0 && grid[y + i][x + j] != null)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void placeTetrimino(Tetromino tetromino, int x, int y) {
        for (int i = 0; i < tetromino.getCoordinates().length; i++) {
            for (int j = 0; j < tetromino.getCoordinates()[i].length; j++) {
                if (tetromino.getCoordinates()[i][j] == 1) {
                    grid[y + i][x + j] = tetromino.getColor();
                }
            }
        }
    }

    public void clearLines() {
        for (int i = 0; i < height; i++) {
            if (isLineFull(i)) {
                clearLine(i);
                i--;
            }
        }
    }

    private boolean isLineFull(int y) {
        for (int j = 0; j < width; j++) {
            if (grid[y][j] == null) {
                return false;
            }
        }
        return true;
    }

    private void clearLine(int y) {
        for (int i = y; i > 0; i--) {
            System.arraycopy(grid[i - 1], 0, grid[i], 0, width);
        }
        clearLineTop();
    }

    private void clearLineTop() {
        Arrays.fill(grid[0], null);
    }

    public Color[][] getGrid() {
        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

public class TetrisGame extends JPanel implements ActionListener {
    private final Board board;
    private Tetromino currentTetromino;
    private int currentX, currentY;
    private final Timer timer;
    private boolean isPaused = false;

    public TetrisGame(JFrame frame) {
        setLayout(new BorderLayout());
        board = new Board();
        spawnNewTetrimino();
        timer = new Timer(500, this);
        timer.start();

        JPanel gameArea = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);
                drawTetrimino(g);
                drawGrid(g);
            }
        };
        gameArea.setPreferredSize(new Dimension(300, 600));
        gameArea.setFocusable(true);

        gameArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });

        add(gameArea, BorderLayout.CENTER);
        JButton exitButton = new JButton("Back");
        exitButton.addActionListener(e -> confirmExit(frame));
        add(exitButton, BorderLayout.SOUTH);

        SwingUtilities.invokeLater(gameArea::requestFocusInWindow);
    }

    private void confirmExit(JFrame frame) {
        isPaused = true;
        timer.stop();
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            frame.setContentPane(new MenuScreen(frame));
            frame.validate();
        } else {
            isPaused = false;
            timer.start();
        }
    }

    private void spawnNewTetrimino() {
        currentTetromino = new Tetromino();
        currentX = 4;
        currentY = 0;
        if (!board.canPlaceTetrimino(currentTetromino, currentX, currentY)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over");
        }
    }

    private void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> {
                if (board.canPlaceTetrimino(currentTetromino, currentX - 1, currentY)) {
                    currentX--;
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (board.canPlaceTetrimino(currentTetromino, currentX + 1, currentY)) {
                    currentX++;
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (board.canPlaceTetrimino(currentTetromino, currentX, currentY + 1)) {
                    currentY++;
                }
            }
            case KeyEvent.VK_UP -> {
                currentTetromino.rotate();
                if (!board.canPlaceTetrimino(currentTetromino, currentX, currentY)) {
                    currentTetromino.rotate();
                    currentTetromino.rotate();
                    currentTetromino.rotate();
                }
            }
            case KeyEvent.VK_P -> togglePause();
        }
        repaint();
    }

    private void togglePause() {
        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Paused. Press 'P' to continue.");
        } else {
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isPaused) {
            if (board.canPlaceTetrimino(currentTetromino, currentX, currentY + 1)) {
                currentY++;
            } else {
                board.placeTetrimino(currentTetromino, currentX, currentY);
                board.clearLines();
                spawnNewTetrimino();
            }
            repaint();
        }
    }

    private void drawBoard(Graphics g) {
        Color[][] grid = board.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != null) {
                    g.setColor(grid[i][j]);
                    g.fillRect(j * 30, i * 30, 30, 30);
                }
            }
        }
    }

    private void drawTetrimino(Graphics g) {
        g.setColor(currentTetromino.getColor());
        for (int i = 0; i < currentTetromino.getCoordinates().length; i++) {
            for (int j = 0; j < currentTetromino.getCoordinates()[i].length; j++) {
                if (currentTetromino.getCoordinates()[i][j] == 1) {
                    g.fillRect((currentX + j) * 30, (currentY + i) * 30, 30, 30);
                }
            }
        }
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                g.drawRect(j * 30, i * 30, 30, 30);
            }
        }
    }
}
