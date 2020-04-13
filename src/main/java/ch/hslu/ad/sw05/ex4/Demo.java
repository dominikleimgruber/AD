package ch.hslu.ad.sw05.ex4;

public class Demo {


    public static void main(String[] args) {

        Thread t3 = new Thread(new JoinAndSleep(null, 4000), "Thread3");
        Thread t2 = new Thread(new JoinAndSleep(t3, 3000), "Thread2");
        Thread t1 = new Thread(new JoinAndSleep(t2, 2000), "Thread1");

        t1.start();
        t2.start();
        t3.start();

        t2.interrupt();

    }


}
