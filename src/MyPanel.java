import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel {
    public int width;
    public int height;
    private MyObjectComponent objectComponent;
    private MyPanel myPanel;

    public MyPanel() {
        objectComponent = new MyObjectComponent();
        objectComponent.setPreferredSize(new Dimension(500, 600));
        add(objectComponent);

        myPanel = this;
        DVDAnimation DVDAnimation = new DVDAnimation(objectComponent, this);
        add(DVDAnimation);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateSizes();
            }
        });

        objectComponent.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                keyPressedMovement(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        objectComponent.setFocusable(true);
        objectComponent.requestFocus();

        setVisible(true);
    }

    private void keyPressedMovement(KeyEvent event) {
        int key = event.getKeyCode();
        int step = 20;

        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (objectComponent.getX() + objectComponent.getMySize() + step > myPanel.width)
                    break;
                objectComponent.moveObject(step, 0);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (objectComponent.getX() - step < 0)
                    break;
                objectComponent.moveObject(-step, 0);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (objectComponent.getY() + objectComponent.getMySize() + step > myPanel.height)
                    break;
                objectComponent.moveObject(0, step);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (objectComponent.getY() - step < 0)
                    break;
                objectComponent.moveObject(0, -step);
                break;
        }

        System.out.println("Current x: " + objectComponent.getX() + " Current y: " + objectComponent.getY());
        System.out.println("Current x: " + myPanel.width + " Current y: " + myPanel.height);
        repaint();
    }

    public void updateSizes() {
        Dimension size = myPanel.getSize();
        width = size.width;
        height = size.height;

        System.out.println("Текущие размеры панели: " + width + " " + height);
    }
}