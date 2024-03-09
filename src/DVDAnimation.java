import java.awt.*;
import java.awt.geom.AffineTransform;

public class DVDAnimation extends AbstractMainAnimation {

    private MyPanel myPanel;
    private boolean directionX = false;
    private boolean directionY = false;

    public DVDAnimation(MyObjectComponent objectComponent, MyPanel myPanel) {
        super(objectComponent);
        this.myPanel = myPanel;
    }

    @Override
    protected void animate() {
        int step = 10;

        if (objectComponent.getX() - step < 0 && directionX)
            directionX = false;
        if (objectComponent.getX() + objectComponent.getMySize() + step > myPanel.width && !directionX)
            directionX = true;
        if (objectComponent.getY() - step < 0 && directionY)
            directionY = false;
        if (objectComponent.getY() + objectComponent.getMySize() + step > myPanel.height && !directionY)
            directionY = true;

        objectComponent.moveObject(directionX ? -step : step, directionY ? -step : step);
        myPanel.repaint();
        System.out.println(objectComponent.getY());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform transform = new AffineTransform();
        transform.scale(Constants.SCALE, Constants.SCALE);
        g2d.setTransform(transform);

        super.paintComponent(g);
    }
}
