import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Field {
    private boolean kidOnField = false;
    private Field north = null;
    private Field south = null;
    private Field east = null;
    private Field west = null;
    private Image img;

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

    public void setNorth(Field f) {
        this.north = f;
    }
    public void setSouth(Field f) {
        this.south = f;
    }
    public void setEast(Field f) {
        this.east = f;
    }
    public void setWest(Field f) {
        this.west = f;
    }

    public Field getNorth() {
        return this.north;
    }
    public Field getSouth() {
        return this.south;
    }
    public Field getEast() {
        return this.east;
    }
    public Field getWest() {
        return this.west;
    }

    public boolean isKidOnField() {
        return kidOnField;
    }

    public void setKidOnField() {
        this.kidOnField = true;
    }
}
