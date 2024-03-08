import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public abstract class AbstractMainAnimation extends JPanel {

    private static final int INACTIVITY_DELAY = 1000;
    private Timer animationTimer;
    private long lastActivityTime;

    protected MyObjectComponent objectComponent;

    public AbstractMainAnimation(MyObjectComponent objectComponent) {
        this.objectComponent = objectComponent;

        lastActivityTime = System.currentTimeMillis();

        animationTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                repaint();
            }
        });

        Timer inactivityTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInactivity();
            }
        });

        inactivityTimer.start();

        // add listeners to stop animation if user is active
        objectComponent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastActivityTime = System.currentTimeMillis();
                if (animationTimer.isRunning()) {
                    stopAnimation();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                lastActivityTime = System.currentTimeMillis();
                if (animationTimer.isRunning()) {
                    stopAnimation();
                }
            }
        });

        objectComponent.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                lastActivityTime = System.currentTimeMillis();
                if (animationTimer.isRunning()) {
                    stopAnimation();
                }
            }
        });
    }

    protected abstract void animate();

    private void checkInactivity() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastActivityTime;

        if (elapsedTime >= INACTIVITY_DELAY) {
            startAnimation();
        }
    }

    private void startAnimation() {
        System.out.println("Play animation..");
        animate();
    }

    private void stopAnimation() {
        System.out.println("Stop animation...");
        animationTimer.stop();
    }
}
