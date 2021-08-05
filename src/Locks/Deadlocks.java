package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlocks {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        Deadlocks deadlock = new Deadlocks();

        new Thread(deadlock::worker1).start();
        new Thread(deadlock::worker2).start();
    }

    public void worker1(){
        lock1.lock();
        System.out.println("Worker 1 takes the lock 1.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("Worker 1 takes the lock 2.");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        lock2.lock();
        System.out.println("Worker 2 takes the lock 1.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println("Worker 2 takes the lock 2.");

        lock1.unlock();
        lock2.unlock();
    }
}
