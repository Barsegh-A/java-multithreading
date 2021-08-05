package Synchronization;

import java.util.ArrayList;
import java.util.List;

public class CustomProcessor {

    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private int value = 0;

    // For demonstration, we could use intrinsic lock as well
    private final Object lock = new Object();

    public void producer() throws InterruptedException{
        synchronized (lock) {
            while(true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("Waiting for removing items...");
                    lock.wait();
                } else {
                    System.out.println("Adding: " + value);
                    list.add(value++);
                    lock.notify();
                }

                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while(true){
                if(list.size() == LOWER_LIMIT){
                    value = 0;
                    System.out.println("Waiting for adding items...");
                    lock.wait();
                } else {
                    System.out.println("Removing: " + list.remove(list.size()-1));
                    lock.notify();
                }

                Thread.sleep(500);
            }
        }
    }


}
