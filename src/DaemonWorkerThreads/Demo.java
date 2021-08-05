package DaemonWorkerThreads;

public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new NormalWorker());

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }
}
