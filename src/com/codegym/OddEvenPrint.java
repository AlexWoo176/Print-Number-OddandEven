package com.codegym;

public class OddEvenPrint {
    boolean odd;
    int count = 1;
    int MAX = 10;

    public void printOdd() {
        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking odd loop");

                while (!odd) {
                    try {
                        System.out.println("Odd waiting: " + count);
                        wait();
                        System.out.println("Notified odd: " + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread: " + count);
                count++;
                odd = false;
                notify();
            }
        }
    }

    public void printEven() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ire) {
            ire.printStackTrace();
        }
        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking even loop");

                while (odd) {
                    try {
                        System.out.println("Even waiting: " + count);
                        wait();
                        System.out.println("Notified even: " + count);
                    } catch (InterruptedException ire2) {
                        ire2.printStackTrace();
                    }
                }
                System.out.println("Even thread: " + count);
                count++;
                odd = true;
                notify();
            }
        }
    }
}
