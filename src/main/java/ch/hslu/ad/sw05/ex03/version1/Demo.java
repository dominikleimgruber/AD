package ch.hslu.ad.sw05.ex03.version1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo {

    public static void main(String[] args) throws InterruptedException {


        Random random = new Random();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new AdditionTask(random.nextLong()), ("Thread " + i)));
        }


         threads.forEach(Thread::start);

        Thread.sleep(500);

        threads.forEach(Thread::interrupt);


    }

}
