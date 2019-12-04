package com.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:32 on 2019/11/28
 * @version V0.1
 * @classNmae SkipList2
 */
public class SkipList2 {

    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL =16;
    private int levelCount =1;


    private Node head = new Node();


    public Node find(int value){
        Node low = head;
        Node high = head;
        high = high.next;
        //一层一层查找被查询数所在区间
        for (int i=levelCount;i>0;i--){
            if(high.data<value){
                while (high.next!=null&&high.next.data<value){
                 high = high.next;
                }
                low =high;
                if(high.next!=null){
                    high = high.next;
                }
            }
            if(high.data==value){
                return high;
            }

            if(low.down!=null){
                low = low.down;
                high=low.next!=null?low.next:low;
            }
        }
        return null;
    }


    public void delete(int value){
        Node target = find(value);
        if(target==null){
            return;
        }
        //查看元素的层数，逐层删除
        int startLevel = target.maxLevel;
        Node previewNode = head;
        Node nextNode = head;
        //下降到startLevel层
        int downCt=levelCount-startLevel;
        while (downCt-->0){
            previewNode = previewNode.down;
        }
        nextNode =previewNode;
        //查找第i层target节点的前后节点
        for (int i = startLevel;i>0;i--){
            //
            while (previewNode.next!=null&&previewNode.next.data<value){
                previewNode=previewNode.next;
            }
            while (nextNode.next!=null&&nextNode.next.data<=value){
                nextNode=nextNode.next;
            }
            if(nextNode.next==null){
                previewNode.next = null;
            }else{
                previewNode.next =nextNode.next;
            }
            previewNode =previewNode.down;
            nextNode =nextNode.down;
        }


    }


    public void insert(int value){
      int levels = randomLevel();  //随机产生插入的层数
      if(levelCount<levels){  //层数发生变化
          for (int i = 0;i<levels -levelCount;i++){
              Node node  =  new Node();
              node.maxLevel =levelCount+i+1;
              node.down =head;
              head = node;
          }
          levelCount = levels;
      }
      int downCt = levels;
      Node point = head;
        //在第level层插入数据
      Node[] newNodes =new Node[levels];
      int headDownCt = levelCount -levels;
      while (headDownCt>0){
          point =point.down;
          headDownCt--;
      }
      while (downCt-->0){
          Node node = new Node();
          node.data = value;
          node.maxLevel =levels;

          while (point.next!=null&&point.next.data<value){
              point =point.next;
          }
          node.next =point.next;
          point.next =node ;
          point =point.down;
          newNodes[downCt]=node;
      }
     for (int i = newNodes.length-1;i>0;i--){
         newNodes[i].down=newNodes[i-1];
     }

    }
    public void printAll() {
        Node p = head;
        while (p.down!= null) {
            p =p.down;
        }
        //第一层head
        int count=0;
        StringBuilder sb = new StringBuilder();
        while (p.next!=null){
            sb.append(p.next.toString()+" ");

            p = p.next;
            if(++count%5==0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    private int randomLevel() {
        int level = 1;

        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }


    public class Node {
        private int data = -1;
        private  int maxLevel =1;
        private Node next;
        private Node down;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: "+data+"; levels: "+maxLevel+" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        SkipList2 skipList = new SkipList2();
        LinkedList linkedList = new LinkedList();
        long start  =System.currentTimeMillis();
        int bound = 10000;
        for (int i=0;i<bound;i++){
            linkedList.add(i);
            skipList.insert(i);
        }
        long end  =System.currentTimeMillis();
        System.out.println("构造数据耗时: "+(end-start)+"ms");
        int target = 0;
        int times = 100000;
        ArrayList<Integer> linkRes = new ArrayList();
        ArrayList<Integer> skipRes = new ArrayList();
        start  =System.currentTimeMillis();
         //查找10000次
        for(int i = 0;i<times;i++){
            target = random.nextInt(bound);
            Integer node = (Integer) linkedList.find(target);
            linkRes.add(node);
        }

        end  =System.currentTimeMillis();
        System.out.println("查找"+times+" 次linkedList 耗时: "+(end-start)+"ms result=" +linkRes.size());
         start  =System.currentTimeMillis();

        for(int i = 0;i<times;i++){
            target = random.nextInt(bound);
            Node res = skipList.find(0);
            skipRes.add(res.data);
        }
         end  =System.currentTimeMillis();
        System.out.println("查找"+times+"次 skipList 耗时: "+(end-start)+"ms result=" +skipRes.size());

    }
}
