import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {
    private static final int MAX_WIDTH = 600;
    private static final int MAX_HEIGHT = 500;

    MyPanel np = new MyPanel();
    public MyJFrame() {
        super("Практическая работа");
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        setSize(MAX_WIDTH,MAX_HEIGHT);

        np.setSize(MAX_WIDTH,MAX_HEIGHT);
        np.setBackground(Color.red);
        add(np);

        setResizable(false);
        setVisible(true);
    }
}
