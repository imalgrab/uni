import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Kid {
    private int x, y;
    private Field[][] board;
    private boolean asleep;
    private Image img;

    public Kid(int x, int y, String filename, boolean asleep) {
        this.x = x;
        this.y = y;
        this.asleep = asleep;
        loadImg(filename);
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

    public boolean isAsleep() {
        return asleep;
    }
}
