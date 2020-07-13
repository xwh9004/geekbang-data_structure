package com.example.concurrent;

import org.junit.Test;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:10 on 2020/3/31
 * @version V0.1
 * @classNmae StopThreadTest
 */
public class StopThreadTest {

     volatile boolean isCancel =false;  //保证可见性

    @Test
    public void stopTest() throws InterruptedException {

     Thread t1 = new Thread(()->{
          while (!isCancel){
//         while (!Thread.currentThread().isInterrupted()){

              try {
                  System.out.println("continue working");
                  Thread.sleep(500);
              } catch (InterruptedException e) {
                  //重新设置线程中断状态 不能isInterrupted()返回不了标识状态
//                  Thread.currentThread().interrupt();

              }
          }
         System.out.println("work done!");
      });
        t1.start();
      for (int i = 0;i<2;i++){
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
        isCancel = true;
//        t1.interrupt();
        t1.join();
    }


}
