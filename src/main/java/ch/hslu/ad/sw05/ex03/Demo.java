package ch.hslu.ad.sw05.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo {

    public static void main(String[] args) throws InterruptedException {


        Random random = new Random();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(new AdditionTask(random.nextInt(Integer.MAX_VALUE)), "Thread " + i));
        }

        for(Thread thread : threads){
            thread.start();
        }

        Thread.sleep(500);

        for(Thread thread : threads){
            thread.interrupt();
        }


    }

}
