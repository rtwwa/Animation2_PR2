import java.awt.*;

public class AnimatedCircle extends AnimatedShape {
    private int radius;

    public AnimatedCircle(MyObjectComponent objectComponent, int radius) {
        super(objectComponent);
        this.radius = radius;
    }

    @Override
    protected void animate() {
        // Пример: движение круга вправо и вниз
        int step = 10;
        int newX = objectComponent.getX() + step;
        int newY = objectComponent.getY() + step;

        // Ограничение движения круга внутри объекта MyObjectComponent
        if (newX + 2 * radius > objectComponent.getWidth() || newX < 0) {
            step = -step; // Изменение направления движения по X
        }
        if (newY + 2 * radius > objectComponent.getHeight() || newY < 0) {
            step = -step; // Изменение направления движения по Y
        }

        objectComponent.moveObject(step, step);
    }
}
