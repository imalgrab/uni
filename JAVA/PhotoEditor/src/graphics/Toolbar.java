package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Toolbar extends JToolBar {
    JButton zoomIn, zoomOut;
    ColorChooserButton firstColor, secondColor;


    public Toolbar() {
        zoomIn = new JButton();
        zoomOut = new JButton();

        ImageIcon zoomInIcon = new ImageIcon();
        try {
            zoomInIcon.setImage(ImageIO.read(new File("img/zoomIn.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon zoomOutIcon = new ImageIcon();
        try {
            zoomOutIcon.setImage(ImageIO.read(new File("img/zoomOut.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        zoomIn.setIcon(zoomInIcon);
        zoomOut.setIcon(zoomOutIcon);

        firstColor = new ColorChooserButton(Color.BLACK);
        secondColor = new ColorChooserButton(Color.WHITE);

        this.setFloatable(false);
        this.add(firstColor);
        this.add(secondColor);
        this.add(zoomIn);
        this.add(zoomOut);
    }
}