package ch.hslu.ad.sw01.part2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

    private static final Logger LOG = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        task(100);
    }

    public static void task(final int n) {

        long startTime = System.currentTimeMillis();
        // T ~ 4
        task1();
        task1();
        task1();
        task1();

        // äussere Schleife: n-mal // T ~ n · 3
        for (int i = 0; i < n; i++) {
            task2();
            task2();
            task2();
            LOG.info("still running");
            // innerer Schleife: n-mal // T ~ n · n· 2
            for (int j = 0; j < n; j++) {
                task3();
                task3();
                LOG.info("still running");
            }
        }

        long endTime = System.currentTimeMillis();
        LOG.info(endTime - startTime);

    }


    private static void task3() {
        try {
            Thread.sleep(2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void task2() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void task1() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
