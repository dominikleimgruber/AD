package ch.hslu.ad.sw08.waitpool;

public class DemoWaitPool2 {

    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new DemoWaitPool2().demo();
    }

    private synchronized void demo() throws InterruptedException {

        final MyTask waiter = new MyTask(lock);
        new Thread(waiter).start();
        new Thread(new MyTask(lock)).start();
        Thread.sleep(1000);

        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
