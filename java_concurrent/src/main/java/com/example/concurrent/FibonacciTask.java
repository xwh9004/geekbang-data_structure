package com.example.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * <p><b>Description:</b>
 * 使用forkJoin实现有依赖关系的子任务 不是个好注意。
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:53 on 2020/4/27
 * @version V0.1
 * @classNmae FibonacciTask
 */
public class FibonacciTask extends RecursiveTask<Integer>  {
    private int n;

    FibonacciTask(int n){
        this.n = n;
    }
    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
//    @Override
//    protected Object compute() {
//        int fibonacci =0;
//        if(n<=2){
//            fibonacci =1;
//        }else{
//            FibonacciTask last1Task =new FibonacciTask(n-1);
//            FibonacciTask last2Task =new FibonacciTask(n-2);
//            last1Task.fork();
//            last2Task.fork();
//
//            int last1Res = (int) last1Task.join();
//            int last2Res = (int) last2Task.join();
//            fibonacci = last1Res + last2Res;
//        }
//        return fibonacci;
//    }

    /**
     * 效果不佳
     * @return
     */
    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FibonacciTask f1 = new FibonacciTask(n - 1);
        f1.fork();
        FibonacciTask f2 = new FibonacciTask(n - 2);
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(); // 最大并发数4

        FibonacciTask fibonacci = new FibonacciTask(40);
        long startTime = System.currentTimeMillis();
        Future<Integer> result = forkJoinPool.submit(fibonacci);
        Integer rest = null;
        try {
             rest =result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            if(fibonacci.isCancelled()){
                System.out.println("task 执行异常");
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + rest + " in " + (endTime - startTime) + " ms.");

    }
}
