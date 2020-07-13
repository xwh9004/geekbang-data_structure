package com.example.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 15:09 on 2020/3/27
 * @version V0.1
 * @classNmae CountDownLatchDemo
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        Player[] players = new Player[10];
        for (int i=0;i<10;i++){
            players[i] = new Player(i,latch);
        }
        for (int i=0;i<10;i++){
            players[i].run();
        }
        latch.await();
        System.out.println("all player finished!");
    }



}

class Player {


    CountDownLatch latch;

    int no;   //名字

    int score;

    Player(int no,CountDownLatch latch){
       this.no = no;
       this.latch = latch;
    }


    public void run() {
        new Thread(){
            @Override
            public void run() {
                Random random = new Random();
                score= random.nextInt(1000);
                try {
                    Thread.sleep(score);
                    printScore();
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public int getScore() {
        return score;
    }

    public void printScore(){
        System.out.println("player " + no + " score: " +score);
    }
}
