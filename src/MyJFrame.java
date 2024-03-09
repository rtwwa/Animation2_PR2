import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyJFrame extends JFrame {

    MyPanel myPanel = new MyPanel();

    public MyJFrame() {
        super("Практическая работа");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Constants.MAX_WIDTH, Constants.MAX_HEIGHT));
        setSize(Constants.MAX_WIDTH, Constants.MAX_HEIGHT);


        myPanel.setSize(Constants.MAX_WIDTH, Constants.MAX_HEIGHT);
        add(myPanel);

        setResizable(false);
        setVisible(true);
        myPanel.updateSizes();
    }
}
