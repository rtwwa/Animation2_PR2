import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JFrame {

    private MyObjectComponent objectComponent;

    public MyPanel() {
        objectComponent = new MyObjectComponent();
        add(objectComponent);

        AnimatedShape animatedCircle = new AnimatedCircle(objectComponent, 40);
        add(animatedCircle);

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void keyPressedMovement(KeyEvent event) {
        int key = event.getKeyCode();
        int step = 20;

        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (objectComponent.getX() + step > 240)
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
                if (objectComponent.getY() + step > 180)
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
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyPanel::new);
    }
}