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
    public void before() {
        heap = new BinaryHeap<>();
    }

    @Test
    public void insert() {
        heap.insert(13);
        heap.insert(14);
        heap.insert(16);
        heap.insert(19);
        heap.insert(21);
        heap.insert(19);
        heap.insert(68);
        heap.insert(65);
        heap.insert(26);
        heap.insert(32);
        heap.insert(22);
        heap.printHeap();
    }

    @Test
    public void deleteMin() {
        insert();
        heap.deleteMin();
        heap.printHeap();
    }


}
