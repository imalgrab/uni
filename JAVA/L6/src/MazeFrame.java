import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MazeFrame extends Frame {

    public Maze maze;

    private WindowListener closeAndResize = new WindowAdapter() {
        public void windowClosing(WindowEvent ev) {
            MazeFrame.this.dispose();
        }
    };

    public MazeFrame() {
        super("aMAZEing");
        maze = new Maze(14, 14);
        setSize(650, 650);
        addWindowListener(closeAndResize);
        add(maze);
        setVisible(true);
    }
}
