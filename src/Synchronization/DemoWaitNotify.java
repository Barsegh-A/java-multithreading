package Synchronization;

public class DemoWaitNotify {
    public static void main(String[] args) {
        CustomProcess customProcess = new CustomProcess();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customProcess.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customProcess.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();
    }
}
