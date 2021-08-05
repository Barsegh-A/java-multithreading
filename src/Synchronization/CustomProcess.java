package Synchronization;

public class CustomProcess {

    // Both methods use intrinsic lock, otherwise wait and notify would be meaningless

    public void produce() throws InterruptedException{
        synchronized (this) {
            System.out.println("Running produce method");
            wait();
            System.out.println("Running produce method again");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("Running consume method");
            notifyAll();
            System.out.println("Running consume method again");
        }
    }
}
