package ch.hslu.ad.sw05.ex03.version1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);
    private Thread runThread;
    private long num;

    public AdditionTask(final long num) {
        this.num = Math.abs(num);
    }


    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        long sum = 0;

        while (num > 0) {

            if (!isStopped()) {
                sum = sum + num % 10;
                num = num / 10;
            } else {
                LOG.info(this.runThread + ": interrupted");
                return;
            }

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                LOG.info(this.runThread + ": interrupted");
                return;
            }
        }

        LOG.info("Cross-sum: {}", sum);

    }

    private boolean isStopped() {
        if(runThread != null){
            return runThread.isInterrupted();
        }
        return true;
    }
}

