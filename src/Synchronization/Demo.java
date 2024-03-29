package Synchronization;

public class Demo {
    public static volatile Integer counter = 0;
    public static Integer counter2 = 0;


    public static void main(String[] args) {
        process();
    }

    public static  void increment() {
        counter++;
    }

    public static  void increment2() {
        counter2++;
    }

    public static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment();
                }
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

        System.out.println("Counter: " + counter);

    }
}
