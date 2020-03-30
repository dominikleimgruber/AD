package ch.hslu.ad.sw05.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Random random = new Random();

        String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};


        List<Ball> balls = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int diameter = random.nextInt(31) + 20;
            int xPosition = random.nextInt(601 - (diameter / 2)) + (diameter / 2);
            int yPosition = random.nextInt(101) + (diameter / 2);
            Ball ball = new Ball(diameter, xPosition, yPosition, colors[random.nextInt(6)]);
            balls.add(ball);
            threads.add(new Thread(ball, "Ball" + i));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.exit(0);
    }
}
