package Downloaders;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private int downloaders;
    Semaphore semaphore;
    private int downloaderSpeed = 500 / 100;
    private CountDownLatch countDownLatch;

    public Downloaders(Semaphore semaphore, int downloaderSpeed, CountDownLatch countDownLatch) {
        this.semaphore = semaphore;
        this.downloaderSpeed = downloaderSpeed;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("User Kuba is downloading file \n" , downloaders);
            sleep(downloaderSpeed * 100);
            System.out.printf("User Maks downloaded and exit \n", downloaders);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

