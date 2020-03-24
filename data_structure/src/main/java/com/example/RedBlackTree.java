package com.example;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 * 此代码摘录于数据结构与算法分析 Java语言描述
 *
 * @author created by Jesse Xu at 14:21 on 2019/12/5
 * @version V0.1
 * @classNmae RedBlackTree
 */
public class RedBlackTree<T extends Comparable> {


    private RedBlackNode header;
    private RedBlackNode nullNode;
    private static final int BLACK = 1;
    private static final int RED = 0;

    /**
     * 记录插入节点的父节点，祖父节点，曾祖父节点，记录插入路径，为旋转做准备
     * Used in insert routine and its helpers
     */
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;


    RedBlackTree() {
        nullNode = new RedBlackNode(null);
        nullNode.left = nullNode.right = nullNode;   //空节点
        header = new RedBlackNode(nullNode);
        header.left = header.right = nullNode;
    }

    private  void insert(T item){
        current = parent = great = header;
        nullNode.element = item;
        while (compare(item,current)!=0){
            great= grand;
            grand = parent;
            parent = current;
            current=compare(item,current)<0?
                    current.left:current.right;

            //Check if two red children;fis if so
            if(current.left.color==RED&&current.right.color== RED){
                handleReorient(item);
            }
        }
        //Insertion fails if already present
        if(current!=nullNode){
            return;
        }
        current = new RedBlackNode(item,nullNode,nullNode);
        //Attach to parent
        if(compare(item,parent)<0){
             parent.left =current;
        }else {
            parent.right = current;
        }
        handleReorient(item);
    }

    private void handleReorient(T item) {
        //Do the color flip
        current.color=RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        //
        if(parent.color==RED){
            grand.color =RED;
            if((compare(item,grand)<0)!= (compare(item,parent)<0)){
                parent = rotate(item,great);
                current.color =BLACK;
            }
        }
        header.right.color=BLACK; //Make root black;
    }


    private RedBlackNode rotate(T item, RedBlackNode parent) {
        if (compare(item, parent) < 0) {
            return parent.left = compare(item, parent.left) < 0 ?
                    rotateWithLeftChild(parent.left) :     //LL
                    rotateWithRightChild(parent.left);    //RL
        } else
            return parent.right = compare(item, parent.right) < 0 ?
                    rotateWithLeftChild(parent.right) :     //RL
                    rotateWithRightChild(parent.right);    //RR
    }


    /**
     * 单次右旋
     * @param k1
     * @return
     */
    private RedBlackNode rotateWithRightChild(RedBlackNode k1) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /**
     * 单次左旋
     * @param k2
     * @return
     */
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right =k2;
        return k1;
    }


    /**
     * Compare item and t.element ,using compareTo,
     * with caveat that if t is header,then item is always larger.
     * This  routine is call if possible that t is header.
     * If it is not possible for t to be header,use compareTo directly.
     *
     * @param item
     * @param t
     * @return
     */
    private int compare(T item, RedBlackNode t) {
        if (t == header) {
            return 1;
        } else
            return item.compareTo(t.element);
    }


    /**
     * 红黑树节点
     *
     * @param <T>
     */
    private static class RedBlackNode<T> {
        private T element;
        private RedBlackNode left;
        private RedBlackNode right;
        int color;

        RedBlackNode(T element) {
            this(element, null, null);
        }

        RedBlackNode(T element, RedBlackNode lt, RedBlackNode rt) {
            this.element = element;
            this.left = lt;
            this.right = rt;
        }
    }
}
