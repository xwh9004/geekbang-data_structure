package com.example;

/**
 * <p>
 * <b>Description:
 * 摘录于 数据结构与算法分析 Java语言描述
 * </b>
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:09 on 2019/12/12
 * @version V0.1
 * @classNmae BinaryHeap
 */
public class BinaryHeap<T extends Comparable> {

    private Object[] items;

    private int capacity;

    private int currentSize;

    public BinaryHeap() {
        this.capacity = 16; //default size
        this.currentSize = 0;
        items = new Object[capacity];
    }

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        items = (T[]) new Object[capacity];
    }

    public BinaryHeap(T[] items) {
        this.items = items;
        capacity = items.length;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }

    public void insert(T item) {

        int hole = ++currentSize;
        /**
         *hole/2=0 后 hole值可能为0
         * 处理空指针：items[0]=item
         */
        for (items[0] = item; ((T) items[hole / 2]).compareTo(item) > 0; hole /= 2) {
            items[hole] = items[hole / 2];
        }
        items[hole] = item;
    }

    /**
     *
     * @return
     */
    public T findMin(){
        if(isEmpty()){
            throw new UnderflowException("empty heap");
        }
        return (T)items[1];
    }

    /**
     * 删除最小元素
     * @return
     */
    public T deleteMin(){
        T min =findMin();
        percolateDown(1);
        items[1] = items[currentSize--];
        percolateDown(1);
        return min;
    }

    /**
     * 思路：将最后一个元素放在在index =1的位置,在将该元素下滤
     * @param hole
     */
    public void percolateDown(int hole) {
        //最后一个元素
        T tmp = (T) items[hole];
        int child ;
        for ( ; hole * 2 < currentSize;hole=child ) {
            child = hole*2;
            if (child!=currentSize
                    &&((T) items[child]).compareTo((T) items[child + 1]) > 0) {
                child++;
            }
            if(((T)items[child]).compareTo(tmp)<0){
                items[hole]=items[child];
            }else{
                //找到最后一个元素的位置了
                break;
            }
        }
        items[hole] = tmp;
    }

    public void printHeap(){
        StringBuilder sb = new StringBuilder();
        if(isEmpty()){
            sb.append("empty heap");
        }

        for (int i =1;i<=currentSize;i++){
            sb.append(items[i].toString() + " ");
        }
        System.out.println(sb.toString());
    }
}