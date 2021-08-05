package ForkJoin;

import java.util.concurrent.ForkJoinPool;

import static java.lang.Runtime.getRuntime;

public class App {

    public static void main(String[] args) {
//        ForkJoinPool pool = new ForkJoinPool(getRuntime().availableProcessors());
//        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(1220);
//        pool.invoke(simpleRecursiveAction);

        ForkJoinPool pool2 = new ForkJoinPool(getRuntime().availableProcessors());
        SimpleRecursiveTask task = new SimpleRecursiveTask(500);
        System.out.println(pool2.invoke(task));
    }
}
