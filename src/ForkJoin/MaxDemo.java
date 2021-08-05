package ForkJoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import static java.lang.Runtime.getRuntime;

public class MaxDemo {
    public static int THRESHOLD = 0;

    public static void main(String[] args) {
        int[] nums = initializeNums();
        THRESHOLD = nums.length / getRuntime().availableProcessors();

        ForkJoinPool pool = new ForkJoinPool(getRuntime().availableProcessors());
        ParallelMaxFinder maxFinder = new ParallelMaxFinder(nums, 0, nums.length);

        System.out.println(pool.invoke(maxFinder));
    }

    private static int[] initializeNums(){
        Random random = new Random();
        int nums[] = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            nums[i] = random.nextInt(100000000);
        }

        return nums;
    }
}
