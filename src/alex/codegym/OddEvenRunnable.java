package alex.codegym;

public class OddEvenRunnable implements Runnable {
    public static final int PRINT_NUMBERS_UPTO = 10;
    static int number = 1;
    int remainder;
    static Object look = new Object();
    
    OddEvenRunnable(int remainder) {
        this.remainder = remainder;
    }
    
    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO) {
            synchronized (look) {
                while (number %  2 != remainder) {
                    try {
                        Thread.sleep(300);
                        look.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+ " " + number);
                number++;
                look.notifyAll();
            }
        }

    }
}
