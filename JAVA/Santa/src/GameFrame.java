import javax.swing.*;


public class GameFrame extends JFrame {

    public GameFrame() {
        BoardPanel boardPanel = new BoardPanel(15, 20);
        setSize(800, 800);
        add(boardPanel);
        setVisible(true);
        setTitle("Hoe, hoe, hoe!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
