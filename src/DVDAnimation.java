import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class DVDAnimation extends AbstractMainAnimation {

    private MyJFrame myJFrame;
    private boolean directionX = false;
    private boolean directionY = false;

    public DVDAnimation(MyObjectComponent objectComponent, MyJFrame myJFrame) {
        super(objectComponent);
        this.myJFrame = myJFrame;
    }

    @Override
    protected void animate() {
        int step = 10;

        if (objectComponent.getX() - step < 0 && directionX)
            directionX = false;
        if (objectComponent.getX() + objectComponent.getMySize() + step > myJFrame.width && !directionX)
            directionX = true;
        if (objectComponent.getY() - step < 0 && directionY)
            directionY = false;
        if (objectComponent.getY() + objectComponent.getMySize() + step > myJFrame.height && !directionY) {
            directionY = true;
            System.out.println("Smena" + getX() + " " + getY());
            System.out.println();
        }

        objectComponent.moveObject(directionX ? -step : step, directionY ? -step : step);
        System.out.println(objectComponent.getY());
    }
}
