package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PictorialPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    boolean zoomIn = false, zoomOut = false;
    private String filename = "img/";
    private BufferedImage img;
    private ArrayList<Point> pointsLMB, pointsRMB;
    private JButton chooseFile, saveFile;
    private JFileChooser jFileChooser;
    Color colorLMB, colorRMB;
    private MousePosition mp = new MousePosition();


    public PictorialPanel(Color colorLeft, Color colorRight) {
        initializePanel(colorLeft, colorRight);
    }

    public void initializePanel(Color colorLeft, Color colorRight) {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.chooseFile = new JButton();
        this.chooseFile.setText("Choose file");
        this.saveFile = new JButton();
        this.saveFile.setText("Save");
        this.jFileChooser = new JFileChooser();
        this.pointsLMB = new ArrayList<>();
        this.pointsRMB = new ArrayList<>();

        this.colorLMB = colorLeft;
        this.colorRMB = colorRight;

        this.add(chooseFile);
        this.add(saveFile);
        this.add(mp, BorderLayout.SOUTH);
        this.mp.setText(this.mp.getX() + ", " + this.mp.getY() + " pix");

        this.chooseFile.addActionListener(this);
        this.saveFile.addActionListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 50, this);

        g.setColor(colorLMB);
        for (Point p :
                pointsLMB) {
            g.fillRect(p.x, p.y, 10, 10);
        }
        g.setColor(colorRMB);
        for (Point p :
                pointsRMB) {
            g.fillRect(p.x, p.y, 10, 10);
        }
        repaint();
    }

    private void addPoints(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        if (p.x > img.getMinX() && p.x < img.getWidth() && p.y > img.getMinY() + 50 && p.y < img.getHeight()) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                pointsLMB.add(p);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                pointsRMB.add(p);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        addPoints(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /*
        Point p = new Point(e.getX(), e.getY());
        if (p.x > img.getMinX() && p.x < img.getWidth() && p.y > img.getMinY() + 50 && p.y < img.getHeight()) {
            pointsLMB.add(p);
        }
        */
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mp.setText(e.getX() + ", " + e.getY() + " pix");
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if (object == chooseFile) {
            loadImg();
        } else if (object == saveFile) {
            saveImg();
        }
    }

    private void loadImg() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".png, .jpg", "png", "jpg");
        jFileChooser.setFileFilter(filter);
        int returnVal = jFileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filename += jFileChooser.getSelectedFile().getName();
            try {
                img = ImageIO.read(new File(filename));
                filename = "img/";
                pointsLMB = new ArrayList<>();
                pointsRMB = new ArrayList<>();
                repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveImg() {
        /*
        filename = "img/poprawione.png";
        String format = "png";
        try {
            ImageIO.write(img, format, new File(filename));
            filename = "img/";
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        BufferedImage imagebuf=null;;
        try {
            imagebuf = new Robot().createScreenCapture(this.getBounds());
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        Graphics2D graphics2D = imagebuf.createGraphics();
        this.paint(graphics2D);
        try {
            ImageIO.write(imagebuf,"png", new File("img/save.png"));
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
