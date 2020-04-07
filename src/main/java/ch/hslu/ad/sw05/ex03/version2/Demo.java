package ch.hslu.ad.sw05.ex03.version2;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for(int i = 1; i <= 10; i ++){
            threads.add(new Thread(new ApplicationTask(i , i * 5), ("Thread: " + i)));
        }

        //start threads
        for(Thread thread : threads){
            thread.start();
        }
        //sleep for 500ms
        Thread.sleep(500);
        //interrupt threads
        for(Thread thread : threads){
            thread.interrupt();
        }
    }
}
