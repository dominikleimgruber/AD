package ch.hslu.ad.sw05.ex4;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class JoinAndSleep implements Runnable {


    private static final Logger LOG = LogManager.getLogger(JoinAndSleep.class);
    private final Thread t;
    private final int sleepTime;

    public JoinAndSleep(final Thread t, final int sleepTime) {
        this.t = t;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        LOG.info("Start task in Thread: {} ", Thread.currentThread().getName());
        if(t != null){
            try {
                t.join();
            } catch (InterruptedException e) {
               LOG.info(e);
            }
        }

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            LOG.info(e);
        }
        LOG.info("End task in: {} ", Thread.currentThread().getName());
    }
}
