import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Explorator {
    private int dx;
    private int dy;
    private Cell cells[][];
    private int x;
    private int y;
    private int w;
    private int h;
    private Image img;

    public Explorator(int x, int y, Cell[][] maze) {
        this.x = x;
        this.y = y;
        cells = maze;
        loadImg();
    }

    private void loadImg() {
        String filename = "img/minion.png";
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("NO such img");
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

}
