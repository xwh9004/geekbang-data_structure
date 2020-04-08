package com.example.concurrent;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:09 on 2020/4/8
 * @version V0.1
 * @classNmae VolatileTest
 */
public class VolatileTest {

    public static volatile int race =0;

    public static void increase(){
        race++;
    }
    private static final int THREAD_COUNTS =20;

    public static void main(String[] args) throws InterruptedException {
//        IntStream.range(0,THREAD_COUNTS).forEach(i->{
//            new Thread(()->{
//                for(int j=0;j<10000;j++){
//                    increase();
//                }
//            }).start();
//        });

        Thread[] threads=new Thread[THREAD_COUNTS];
        for (int i=0;i<THREAD_COUNTS;i++){
            threads[i] =  new Thread(()->{
                for(int j=0;j<10000;j++){
                    increase();
                }
            });
            threads[i].start();
        }

//        System.out.println(Thread.activeCount());
        for (int i=0;i<THREAD_COUNTS;i++){
            threads[i].join();
        }
        System.out.println(race);

    }
}
