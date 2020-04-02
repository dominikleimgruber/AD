package ch.hslu.ad.sw05.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);
    private Thread runThread;
    private long num;
    private boolean isStopped;

    public AdditionTask(long num) {
        this.num = num;
        this.isStopped = false;
    }


    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        long sum = 0;

        try {
            while (num > 0) {
                if (!isStopped) {
                    sum = sum + num % 10;
                    num = num / 10;
                    Thread.sleep(15);
                } else {
                    LOG.info("{} is interrupted", runThread);
                    return;
                }
            }
            LOG.info("Cross-sum: {}", sum);
        } catch (Exception e) {
            LOG.info(this.runThread + ": interrupted");
        }

    }

    private boolean isStopped() {
        return runThread.isInterrupted();
    }
}

