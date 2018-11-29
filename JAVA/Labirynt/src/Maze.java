import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Maze extends Canvas implements KeyListener {
    private int numOfClicks;
    private int mHeight;
    private int mWidth;
    private int cellSize = 30;
    private Cell[][] maze;
    private Cell start, finish;
    private Random rand = new Random();

    private Explorator explorator;
    private boolean gameWon = false;

    public Maze(int height, int width) {
        mHeight = height;
        mWidth = width;
        this.maze = new Cell[mHeight][mWidth];
        numOfClicks = 0;

        setSize(cellSize*mWidth, cellSize*mHeight);
        addKeyListener(this);

        initializeMaze();

        int startX = rand.nextInt(mHeight), startY = rand.nextInt(mWidth);

        start = maze[startX][startY];
        start.markAsVisited();
        finish = maze[0][mWidth - 1];

        explorator = new Explorator(startY, startX, maze);

        generateMaze(start);
    }

    private void initializeMaze() {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                maze[i][j] = new Cell();
            }
        }
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                // position of neighbours depending on current cell position
                if (i == 0 && j == 0) {
                    //top left
                    maze[i][j].setSouthernNeighbour(maze[i + 1][j]);
                    maze[i][j].setEasternNeighbour(maze[i][j + 1]);

                } else if (i == mHeight - 1 && j == 0) {
                    //bottom left
                    maze[i][j].setNorthernNeighbour(maze[i - 1][j]);
                    maze[i][j].setEasternNeighbour(maze[i][j + 1]);
                } else if (i == 0 && j == mWidth - 1) {
                    //top right
                    maze[i][j].setSouthernNeighbour(maze[i + 1][j]);
                    maze[i][j].setWesternNeighbour(maze[i][j - 1]);
                } else if (i == mHeight - 1 && j == mWidth - 1) {
                    //bottom right
                    maze[i][j].setNorthernNeighbour(maze[i - 1][j]);
                    maze[i][j].setWesternNeighbour(maze[i][j - 1]);
                } else if (i == 0 && j > 0 && j < mWidth - 1) {
                    //very top row
                    maze[i][j].setSouthernNeighbour(maze[i + 1][j]);
                    maze[i][j].setEasternNeighbour(maze[i][j + 1]);
                    maze[i][j].setWesternNeighbour(maze[i][j - 1]);
                } else if (i == mHeight - 1 && j > 0 && j < mWidth - 1) {
                    //very bottom row
                    maze[i][j].setNorthernNeighbour(maze[i - 1][j]);
                    maze[i][j].setEasternNeighbour(maze[i][j + 1]);
                    maze[i][j].setWesternNeighbour(maze[i][j - 1]);
                } else if (i > 0 && i < mHeight - 1 && j == 0) {
                    //very left col
                    maze[i][j].setNorthernNeighbour(maze[i - 1][j]);
                    maze[i][j].setSouthernNeighbour(maze[i + 1][j]);
                    maze[i][j].setEasternNeighbour(maze[i][j + 1]);
                } else if (i > 0 && i < mHeight - 1 && j == mWidth - 1) {
                    //very right col
                    maze[i][j].setNorthernNeighbour(maze[i - 1][j]);
                    maze[i][j].setSouthernNeighbour(maze[i + 1][j]);
                    maze[i][j].setWesternNeighbour(maze[i][j - 1]);
                } else {
                    maze[i][j].setNorthernNeighbour(maze[i - 1][j]);
                    maze[i][j].setSouthernNeighbour(maze[i + 1][j]);
                    maze[i][j].setEasternNeighbour(maze[i][j + 1]);
                    maze[i][j].setWesternNeighbour(maze[i][j - 1]);
                }
                maze[i][j].setDirectNeighbours();
            }
        }
    }

    private void generateMaze(Cell start) {
        for (Cell current :
                start.directNeighbours) {
            if (!current.isVisited()) {
                current.markAsVisited();
                if (current == start.getNorthernNeighbour()) {
                    start.deleteNorthernWall();
                    current.deleteSouthernWall();
                } else if (current == start.getSouthernNeighbour()) {
                    start.deleteSouthernWall();
                    current.deleteNorthernWall();
                } else if (current == start.getEasternNeighbour()) {
                    start.deleteEasternWall();
                    current.deleteWesternWall();
                } else if (current == start.getWesternNeighbour()) {
                    start.deleteWesternWall();
                    current.deleteEasternWall();
                }
                generateMaze(current);
            }
        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        drawEverything(graphics2D);
        //paintMaze(g);
        //g.drawImage(explorator.getImg(), explorator.getX() * cellSize, explorator.getY() * cellSize, this);
    }

    private void drawEverything(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        paintMaze(graphics2D);
        graphics2D.drawImage(explorator.getImg(), cellSize * explorator.getX(), cellSize * explorator.getY(), null);
    }

    private void paintMaze(Graphics g) {
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                if (maze[i][j] == start) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    g.setColor(Color.BLACK);
                }
                if (maze[i][j] == finish) {
                    g.setColor(Color.RED);
                    g.fillRect(j * 30, i * 30, 30, 30);
                    g.setColor(Color.BLACK);
                }
                if (maze[i][j].hasNorthernWall()) {
                    g.drawLine(j * 30, i * 30, j * 30 + 30, i * 30);
                }
                if (maze[i][j].hasSouthernWall()) {
                    g.drawLine(j * 30, i * 30 + 30, j * 30 + 30, i * 30 + 30);
                }
                if (maze[i][j].hasEasternWall()) {
                    g.drawLine(j * 30 + 30, i * 30, j * 30 + 30, i * 30 + 30);
                }
                if (maze[i][j].hasWesternWall()) {
                    g.drawLine(j * 30, i * 30, j * 30, i * 30 + 30);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        numOfClicks++;

        if (gameWon) return;

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP && !maze[explorator.getY()][explorator.getX()].hasNorthernWall()) {
            explorator.setY((explorator.getY() - 1));
        }
        if (key == KeyEvent.VK_DOWN && !maze[explorator.getY()][explorator.getX()].hasSouthernWall()) {
            explorator.setY((explorator.getY() + 1));
        }
        if (key == KeyEvent.VK_LEFT && !maze[explorator.getY()][explorator.getX()].hasWesternWall()) {
            explorator.setX((explorator.getX() - 1));
        }
        if (key == KeyEvent.VK_RIGHT && !maze[explorator.getY()][explorator.getX()].hasEasternWall()) {
            explorator.setX((explorator.getX() + 1));
        }

        repaint();

        if (explorator.getY() * 30 == 0 && explorator.getX() == mWidth-1) {
            gameWon = true;
            System.out.println("Congratulations, You've made it in " + numOfClicks + " clicks!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
