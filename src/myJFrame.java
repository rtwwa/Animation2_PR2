import javax.swing.*;
import java.awt.*;

public class myJFrame extends JFrame {
    private static final int MAX_WIDTH = 500;
    private static final int MAX_HEIGHT = 500;

    myPanel np = new myPanel();
    public myJFrame() {
        super("Практическая работа");
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
        setSize(MAX_WIDTH,MAX_HEIGHT);

        np.setSize(MAX_WIDTH,MAX_HEIGHT);
        add(np);

        setVisible(true);
    }
}
