package com.example;

import org.junit.Before;
import org.junit.Test;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:40 on 2019/12/12
 * @version V0.1
 * @classNmae BinaryHeapTest
 */
public class BinaryHeapTest {

    private BinaryHeap<Integer> heap;
    @Before
    public void before(){
        heap = new BinaryHeap<>();
    }
    @Test
    public void insert(){
        heap.insert(13);
        heap.insert(12);
        heap.printHeap();
    }


}
