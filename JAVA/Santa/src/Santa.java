import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Santa {
    private int x, y;
    private Field[][] board;
    private Image img;

    public Santa(int x, int y, Field[][] board) {
        this.x = x;
        this.y = y;
        this.board = board;
        loadImg("Santa/front.png");
    }

    private void loadImg(String filename) {
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such image");
        }
    }

    public Image getImg() {
        return this.img;
    }

    public void setImg(String filename) {
        loadImg(filename);
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
}
