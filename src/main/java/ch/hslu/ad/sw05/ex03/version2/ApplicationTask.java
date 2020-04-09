package ch.hslu.ad.sw05.ex03.version2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(ApplicationTask.class);
    private Thread runThread;
    private int rangeBegin;
    private int rangeEnd;

    public ApplicationTask(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        long sum = 0;

        for (int i = rangeBegin; (i <= rangeEnd); i++) {
            if (!isStopped()) {
                sum += i;
            } else {
                LOG.info("{} interrupted.", this.runThread);
                return;
            }

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                LOG.info("{} interrupted while sleeping.", this.runThread);
                return;
            }
        }

        LOG.info(runThread.getName() + ": SUM" + (this.rangeBegin - this.rangeEnd) + " -> " + sum);


    }

    private boolean isStopped() {
        if (this.runThread != null) {
            return runThread.isInterrupted();
        }
        return true;
    }
}
