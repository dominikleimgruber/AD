package ch.hslu.ad.sw05.ex01;



public class Ball extends Circle implements Runnable {

    public Ball(final int diameter, final int xPosition, final int yPosition, final String color) {

        //Random random = new Random();
        // int xPosition = random.nextInt(601 - (diameter / 2)) + (diameter / 2);
        // int yPosition = random.nextInt(101) + (diameter / 2);

        super(diameter, xPosition, yPosition, color);
        makeVisible();
    }

    @Override
    public void run() {

        Canvas canvas = Canvas.getCanvas();

        while(getY() < canvas.getHeight() - (getDiameter() / 2)){
            moveDown();
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(getDiameter() > 0) {
            changeSize(getDiameter() - 10);
            moveVertical(getY() - 10);
        }
    }
}
