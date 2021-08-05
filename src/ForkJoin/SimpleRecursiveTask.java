package ForkJoin;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    private int simulatedWork;

    public SimpleRecursiveTask(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }


    @Override
    protected Integer compute() {
        if(simulatedWork > 100) {
            System.out.println("Parallel execution and split task..." + simulatedWork);

            SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(simulatedWork/2);
            SimpleRecursiveTask simpleRecursiveTask2 = new SimpleRecursiveTask(simulatedWork - simulatedWork/2);

            simpleRecursiveTask1.fork();
            simpleRecursiveTask2.fork();

            int solution = 0;

            solution += simpleRecursiveTask1.join();
            solution += simpleRecursiveTask2.join();

            return solution;
        } else {
            System.out.println("No need for parallel execution, sequential algorithm is ok. " + simulatedWork);
            return simulatedWork;
        }
    }
}
