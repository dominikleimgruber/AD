package ch.hslu.ad.sw05.ex01;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball extends Circle implements Runnable {

    private static final Logger LOG = LogManager.getLogger(Ball.class);

    public Ball(final int diameter, final int xPosition, final int yPosition, final String color) {

        super(diameter, xPosition, yPosition, color);
        makeVisible();
    }

    @Override
    public void run() {

        Canvas canvas = Canvas.getCanvas();
        long speed = (long)(Math.random() * 1000);
        while (getY() <= (canvas.getHeight() - getDiameter())) {

           moveDown();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                LOG.info(e);
            }
        }

        while (getDiameter() > 0) {
            changeSize(getDiameter() - 5);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                LOG.info(e);
            }
        }
    }
}