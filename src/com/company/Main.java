package com.company;

import Downloaders.Downloaders;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Uploader uploader = new Uploader();
        uploader.start();
        synchronized (uploader) {
            uploader.wait();

        }
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3, true);
        for (int i = 1; i <= 10; i++) {
            new Downloaders(i, semaphore, countDownLatch).start();
        }
        countDownLatch.await();
        System.out.println("File is deleted");

    }


}
