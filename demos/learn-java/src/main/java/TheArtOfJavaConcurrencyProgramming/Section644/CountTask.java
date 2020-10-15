package TheArtOfJavaConcurrencyProgramming.Section644;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author zail
 * @since 2018-09-17
 */
public class CountTask extends RecursiveTask<Integer> {
    
    // 阈值
    private static final int THRESHOLD = 100;
    
    private int start;
    private int end;
    
    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Integer compute() {
        int sum = 0;
        // 如果任务足够小就直接计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + ": " +
                start + " - " + end +
                "计算得出 sum = " + sum);
        }
        else {
            // 如果任务大于阈值, 就分裂成两个子任务进行计算
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完成, 并得到结果
            int leftTaskResult = leftTask.join();
            int rightTaskResult = rightTask.join();
            // 合并子任务
            sum = leftTaskResult + rightTaskResult;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        // 生成一个计算任务, 负责计算 1+2+3+4
        CountTask countTask = new CountTask(1, 10000);
        Future<Integer> result = pool.submit(countTask);
        try {
            System.out.println(result.get());
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
}
