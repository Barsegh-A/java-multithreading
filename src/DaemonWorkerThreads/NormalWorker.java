package DaemonWorkerThreads;

public class NormalWorker implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from Normal Worker");
    }
}
