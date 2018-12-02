package graphics;

import javax.swing.*;

public class MousePosition extends JLabel {
    private int x = 0, y = 0;

    public MousePosition() {
        setText(x + ", " + y + " pix");
    }
}
