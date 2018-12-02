package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame implements ActionListener {
    private Toolbar toolbar;
    private PictorialPanel pictorialPanel;
    private MousePosition mousePosition;

    public PaintFrame() {
        initializeFrame();
    }

    private void initializeFrame() {
        this.mousePosition = new MousePosition();
        this.add(mousePosition, BorderLayout.SOUTH);
        this.toolbar = new Toolbar();
        this.toolbar.firstColor.addActionListener(this);
        this.toolbar.secondColor.addActionListener(this);

        this.pictorialPanel = new PictorialPanel(toolbar.firstColor.getSelectedColor(), toolbar.secondColor.getSelectedColor());
        JScrollPane jScrollPane = new JScrollPane(pictorialPanel);
        jScrollPane.setPreferredSize(new Dimension(600, 600));

        this.add(toolbar, BorderLayout.NORTH);
        this.add(jScrollPane, BorderLayout.CENTER);

        int width = 800;
        int height = 600;

        this.setSize(width, height);
        this.setVisible(true);
        this.setTitle("Paint 2.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if (object == toolbar.firstColor) {
            this.pictorialPanel.colorLMB = toolbar.firstColor.getSelectedColor();
            this.pictorialPanel.repaint();
        } else if (object == toolbar.secondColor) {
            this.pictorialPanel.colorRMB = toolbar.secondColor.getSelectedColor();
            this.pictorialPanel.repaint();
        } else if (object == toolbar.zoomIn) {
            pictorialPanel.zoomIn = true;
        } else if (object == toolbar.zoomOut) {
            pictorialPanel.zoomOut = true;
        }
    }
}
