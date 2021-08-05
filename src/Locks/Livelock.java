package Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Livelock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        Livelock livelock = new Livelock();

        new Thread(livelock::worker1).start();
        new Thread(livelock::worker2).start();
    }

    public void worker1(){

//        while(true){
//            try {
//                lock1.tryLock(50, TimeUnit.MILLISECONDS);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("Worker 1 takes the lock 1.");
//        }
//
//        lock1.lock();
//        System.out.println("Worker 1 takes the lock 1.");
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        lock2.lock();
//        System.out.println("Worker 1 takes the lock 2.");
//
//        lock1.unlock();
//        lock2.unlock();
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
