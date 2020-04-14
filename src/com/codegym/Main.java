package com.codegym;

public class Main {

    public static void main(String[] args) {
        OddEvenPrint oddEvenPrint = new OddEvenPrint();
        oddEvenPrint.odd = true;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenPrint.printEven();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenPrint.printOdd();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
