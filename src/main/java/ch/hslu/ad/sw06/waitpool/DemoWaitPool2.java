package ch.hslu.ad.sw06.waitpool;

public class DemoWaitPool2 {

    private static final Object LOCK = new Object();

    private static synchronized void  demo() throws InterruptedException {

        final MyTask waiter = new MyTask(LOCK);
        new Thread(waiter).start();
        new Thread(new MyTask(LOCK)).start();
        Thread.sleep(1000);

        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        demo();
    }
}
