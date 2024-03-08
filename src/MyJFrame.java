import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyJFrame extends JFrame {

    public int width;
    public int height;
    MyPanel myPanel = new MyPanel(this);

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
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateSizes();
            }
        });

        setVisible(true);
        updateSizes();
    }

    private void updateSizes() {
        Dimension size = myPanel.getSize();
        width = size.width;
        height = size.height;

        System.out.println("Текущие размеры панели: " + width + " " + height);
    }
}
