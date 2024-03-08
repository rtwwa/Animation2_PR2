import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class AnimatedShape extends JPanel {

    private static final int INACTIVITY_DELAY = 5000; // 5 секунд бездействия
    private Timer animationTimer;
    private long lastActivityTime;

    protected MyObjectComponent objectComponent;

    public AnimatedShape(MyObjectComponent objectComponent) {
        this.objectComponent = objectComponent;

        // Начальное время последней активности
        lastActivityTime = System.currentTimeMillis();

        // Создаем таймер анимации, но не запускаем его
        animationTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                repaint();
            }
        });

        // Создаем таймер для проверки бездействия
        Timer inactivityTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInactivity();
            }
        });

        // Запускаем таймер проверки бездействия
        inactivityTimer.start();

        // Добавляем слушатель мыши для отслеживания активности пользователя
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
    }


    protected abstract void animate();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void checkInactivity() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastActivityTime;

        if (elapsedTime >= INACTIVITY_DELAY) {
            // Выполнить анимацию после задержки бездействия
            startAnimation();
        }
    }

    private void startAnimation() {
        System.out.println("Starting animation after inactivity!");
        animate();
    }

    private void stopAnimation() {
        System.out.println("Stopping animation due to user activity!");
        // Останавливаем таймер анимации
        animationTimer.stop();
    }
}
