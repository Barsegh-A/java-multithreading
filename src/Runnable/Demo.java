package Runnable;

public class Demo {
    public static void main(String[] args){

        // Not parallel execution, instead, time-slicing algorithm is used (shared resource)

        Thread t1 = new Thread(new Runner3());

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println("Anonymous Runner: " + i);
                }
            }
        });

        Thread t3 = new Runner4();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}
