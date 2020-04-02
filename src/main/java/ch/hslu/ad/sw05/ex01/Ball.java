package ch.hslu.ad.sw05.ex01;


import java.util.Random;

public class Ball extends Circle implements Runnable {

    public Ball(final int diameter, final int xPosition, final int yPosition, final String color) {

        super(diameter, xPosition, yPosition, color);
        makeVisible();
    }

    @Override
    public void run() {

        Canvas canvas = Canvas.getCanvas();
        Random random = new Random();
        while (getY() <= (canvas.getHeight() - getDiameter())) {


           moveDown();
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (getDiameter() > 0) {
            changeSize(getDiameter() - 5);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}