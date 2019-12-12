package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:17 on 2019/12/11
 * @version V0.1
 * @classNmae BinarySearchTreeTest
 */
public class BinarySearchTreeTest {
    BinarySearchTree tree = null;

    @Before
    public void tree() {
        tree = new BinarySearchTree();
//        tree.insert(6);
//        tree.insert(2);
//        tree.insert(8);
//        tree.insert(1);
//        tree.insert(4);
//        tree.insert(3);
    }

    @Test
    public void insert() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);
        tree.insert(16);
        tree.printTree();
        System.out.println();
    }
    @Test
    public void remove() {
        tree.remove(2);
        tree.printTree();
        System.out.println();
    }
    @Test
    public void getHeight() {
        System.out.println(tree.height());
    }
}
