import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myPanel extends JPanel {

    private int x = 0;
    private int y = 0;

    private int previousX;
    private int previousY;
    private int mySize = 100;

    public myPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 500));
        setBounds(0, 0, 500, 500);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                keyPressedMovement(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        setFocusable(true);
        requestFocus();
    }

    private void keyPressedMovement(KeyEvent event) {
        int key = event.getKeyCode();
        int step = 20;

        previousX = this.x;
        previousY = this.y;

        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                this.x += step;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                this.x -= step;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                this.y += step;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                this.y -= step;
                break;
        }

        System.out.println("Current x: " + getX() + " Current y: " + getY());

        repaint();
    }

    private void clearPrevious(Graphics g) {
        g.clearRect(previousX, previousY, getMySize(), getMySize());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //clearPrevious(g);

        g.setColor(Color.green);
        g.fillRect(x, y, getMySize(), getMySize());
        g.setColor(Color.yellow);
        g.fillOval(x + 10, y + 10, 35, 35);
        g.fillOval(x + 55, y + 55, 35, 35);

        g.setColor(Color.green);
        g.fillRect(x + 200, y + 200, getMySize(), getMySize());
        g.setColor(Color.yellow);
        g.fillOval(x + 200, y + 200, 35, 35);
        g.fillOval(x + 200, y + 200, 35, 35);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMySize() {
        return mySize;
    }

    public void setMySize(int mySize) {
        this.mySize = mySize;
    }
}