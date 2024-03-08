import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MyObjectComponent extends JComponent {

    private int x = 0;
    private int y = 0;
    private int mySize = 100;

    public MyObjectComponent() {
        setPreferredSize(new Dimension(500, 500));
        setBounds(0, 0, 500, 500);
    }

    public void moveObject(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.green);
        g.fillRect(x, y, mySize, mySize);
        g.setColor(Color.yellow);
        g.fillOval(x + 10, y + 10, 35, 35);
        g.fillOval(x + 55, y + 55, 35, 35);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMySize() {
        return mySize;
    }
}
