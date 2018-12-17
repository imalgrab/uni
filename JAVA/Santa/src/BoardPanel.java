import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class BoardPanel extends JPanel implements KeyListener {
    private int numOfVisitedKids = 0;
    private int height, width;
    private int fieldSize = 40;
    private GameBoard gameBoard;
    private Santa santa;
    private Image background;
    private JLabel kidsLeft;
    private JLabel victory;

    public BoardPanel(int height, int width) {
        try {
            background = ImageIO.read(new File("Santa/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.height = height;
        this.width = width;
        this.gameBoard = new GameBoard(height, width);
        this.santa = new Santa(0, 8, gameBoard.getBoard());
        this.kidsLeft = new JLabel(numOfVisitedKids + "/" + gameBoard.getNumOfKids());
        add(kidsLeft);
        this.victory = new JLabel("Gratulacje, wygrales!");
        victory.setVisible(false);
        add(victory);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        drawAll(graphics2D);
    }

    public void drawAll(Graphics g) {
        paintBoard(g);
        g.drawImage(santa.getImg(), fieldSize * santa.getX(), fieldSize * santa.getY(), null);
        for (Kid k :
                gameBoard.getKids()) {
            g.drawImage(k.getImg(), fieldSize * k.getX(), fieldSize * k.getY(), null);
        }
    }

    public void paintBoard(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width * fieldSize, height * fieldSize);
        g.setColor(Color.BLACK);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                g.drawImage(background, fieldSize * j, fieldSize * i, null);
                g.drawLine(j * fieldSize, i * fieldSize, j * fieldSize + fieldSize, i * fieldSize);
                g.drawLine(j * fieldSize, i * fieldSize + fieldSize, j * fieldSize + fieldSize, i * fieldSize + fieldSize);
                g.drawLine(j * fieldSize + fieldSize, i * fieldSize, j * fieldSize + fieldSize, i * fieldSize + fieldSize);
                g.drawLine(j * fieldSize, i * fieldSize, j * fieldSize, i * fieldSize + fieldSize);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            if (santa.getY() == 0) santa.setY(gameBoard.getBoardHeight() - 1);
            else {
                checkIfHasKid();
                santa.setY(santa.getY() - 1);
            }
            santa.setImg("Santa/back.png");

        }
        if (key == KeyEvent.VK_DOWN) {
            if (santa.getY() == gameBoard.getBoardHeight() - 1) santa.setY(0);
            else {
                checkIfHasKid();
                santa.setY(santa.getY() + 1);
            }
            santa.setImg("Santa/front.png");
        }
        if (key == KeyEvent.VK_LEFT) {
            if (santa.getX() == 0) santa.setX(gameBoard.getBoardWidth() - 1);
            else {
                checkIfHasKid();
                santa.setX(santa.getX() - 1);
            }
            santa.setImg("Santa/left.png");
        }
        if (key == KeyEvent.VK_RIGHT) {
            if (santa.getX() == gameBoard.getBoardWidth() - 1) santa.setX(0);
            else {
                checkIfHasKid();
                santa.setX(santa.getX() + 1);
            }
            santa.setImg("Santa/right.png");
        }
        repaint();
    }

    private void checkIfHasKid() {
        if (gameBoard.getBoard()[santa.getY()][santa.getX()].isKidOnField())
            for (Kid k :
                    gameBoard.getKids()) {
                if (k.getX() == santa.getX() && k.getY() == santa.getY()) {
                    k.setImg("Santa/gift.png");
                    numOfVisitedKids++;
                    kidsLeft.setText(numOfVisitedKids + "/" + gameBoard.getNumOfKids());
                    if (numOfVisitedKids == gameBoard.getNumOfKids()) {
                        victory.setVisible(true);
                    }
                }
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
