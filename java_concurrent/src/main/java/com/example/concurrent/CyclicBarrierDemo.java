package com.example.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:22 on 2020/5/6
 * @version V0.1
 * @classNmae CyclicBarrierDemo
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int num =2;
        int result[] = new int[num];

        CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println("汇总。。。! ");
                int sum = 0;
                for (int i = 0;i<num;i++){
                    sum+=(int)result[i];
                }
                System.out.println(sum);
            }
        });

        for (int i = 0; i < num; i++) {
            Thread t = new Thread(new CalculateWorker(barrier,i,result));
            t.start();
        }


    }

    static class CalculateWorker implements Runnable {

        private int num;

        private int[] result ;
        private CyclicBarrier barrier;
        public CalculateWorker(CyclicBarrier barrier,int num,int[] result) {
            this.barrier = barrier;
            this.num =num;
            this.result = result;
        }
        @Override
        public void run() {
            try {

                   for (int i = 0;i<=num;i++){
                       result[num]+=i*i;
                   }
                    System.out.println(Thread.currentThread().getName() +" Executed!");
                    barrier.await();

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



