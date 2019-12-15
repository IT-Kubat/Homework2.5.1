package com.company;

public class Uploader extends Thread {
    private int file = 1;
    private int SpeedUploader = 500 / 20;

    public Uploader() {

    }

    @Override
    public void run() {
        while (file < 2) {
            try {
                System.out.println("Downloading one file ");
                sleep(SpeedUploader * 100);
                System.out.println("Downloaded one file");

            } catch (InterruptedException e) {

            }
            break;
        }
    }
}



