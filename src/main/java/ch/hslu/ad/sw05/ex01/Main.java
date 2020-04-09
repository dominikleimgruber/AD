package ch.hslu.ad.sw05.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {


        Random random = new Random();
        String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 50; i++) {

            int diameter = random.nextInt(31) + 20;
            int xPosition = random.nextInt(600 - (2 * diameter)) + diameter;
            int yPosition = random.nextInt(101) + (diameter / 2);

            threads.add(new Thread(new Ball(diameter, xPosition, yPosition, colors[random.nextInt(6)]), "Ball" + i));
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
