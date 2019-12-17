package Downloaders;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private int downloaders;
    Semaphore semaphore;
    private int downloaderSpeed = 500 / 100;
    private CountDownLatch countDownLatch;

    public Downloaders(int downloaders, Semaphore semaphore, CountDownLatch countDownLatch) {
        this.downloaders = downloaders;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("User %d is downloading file \n" , downloaders);
            sleep(downloaderSpeed * 100);
            System.out.printf("User %d downloaded and exit \n", downloaders);
            semaphore.release();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

