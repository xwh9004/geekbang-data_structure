package com.example;

import jdk.nashorn.internal.ir.BinaryNode;

/**
 * <p><b>Description:</b>  摘录于 数据结构与算法分析 Java语言描述
 * <p>
 * 1.假定节点的元素值都不相同
 * 2.该查找树是一颗平衡查找树
 * 3.对节点k左旋 指旋转k左子树,对节点k右旋，指对k右子树旋转
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 13:58 on 2019/12/6
 * @version V0.1
 * @classNmae BinarySearchTree
 */
public class BinarySearchTree<T extends Comparable> {

    private BinaryNode root;

    /**
     * 允许的不平衡条件
     */
    private final int ALLOWED_IMBALANCE = 1;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return (T) findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return (T) findMax(root).element;
    }

    private BinaryNode findMin(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    private BinaryNode findMax(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        }
        return findMax(t.right);
    }


    public boolean contains(T item) {
        return contains(item, root);
    }

    private boolean contains(T item, BinaryNode root) {
        if (root == null) {
            return false;
        }
        int compareResult = item.compareTo(root.element);
        if (compareResult < 0) {
            return contains(item, root.left);
        } else if (compareResult > 0) {
            return contains(item, root.right);
        } else
            return false;   //match
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    /**
     * @return
     */
    public int height() {
        return height(root);
    }

    public void printTree() {
        printTree(root);
    }

    /**
     * 树叶的高度,叶子节点高度为0
     *
     * @param t
     * @return
     */
//    private int height(BinaryNode t) {
//        if (t == null) {
//            return -1;
//        } else {
//            return 1 + Math.max(height(t.left), height(t.right));
//        }
//    }

    /**
     * 为了树便利的查找树的平衡条件，在节点中引入节点高度。
     * @param t
     * @return
     */
    private int height(BinaryNode t){
        return t==null?-1:t.height;
    }

    private BinaryNode insert(T x, BinaryNode t) {
        if (t == null) {
            return new BinaryNode(x);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else
            ;
        return balance(t);
    }

    private BinaryNode remove(T x, BinaryNode t) {

        if (t == null) {
            return null;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else {
            //find item then delete
            if (t.left != null && t.right != null) {  //two children
                t.element = findMin(t.right).element;  //替换又子树中最小的节点
                t.right = remove((T)t.element, t.right);//
            } else {
                t = (t.left != null) ? t.left : t.right;
            }
        }
        return balance(t);
    }

    /**
     * 假定t要么是平衡的要么需要一次平衡操作能达到平衡
     * @param t
     * @return
     */
    private BinaryNode balance(BinaryNode t){
        if(t == null){
            return null;
        }
        /*
         *  四种插入结果 conditions
         *  1. 对节点的左儿子的左子树进行一次插入
         *  2. 对节点的左儿子的右子树进行一次插入
         *  3. 对节点的右儿子的左子树进行一次插入
         *  4. 对节点的右儿子的右子树进行一次插入
         *
         */
        if((height(t.left))-height(t.right)>ALLOWED_IMBALANCE){
            //notice 这里=的情况
           if(height(t.left.left)>=height(t.left.right)){
               //condition 1
                t= rotateWithLeftChild(t);
           }else{
               //condition 2
               t= doubleWithLeftChild(t);
           }
        }
        else if((height(t.right))-height(t.left)>ALLOWED_IMBALANCE){
            if(height(t.right.right)>=height(t.right.left)){
                //condition 4
                t= rotateWithRightChild(t);

            }else{
                //condition 3
                t= doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left),height(t.right))+1;
        return t;
    }

    /**
     * 右-左旋
     * 先对k1.right 左旋 在k1右旋
     * @param k1
     * @return
     */
    private BinaryNode doubleWithRightChild(BinaryNode k1) {
        k1.right=rotateWithLeftChild(k1.right);
        BinaryNode k2=rotateWithRightChild(k1);
        return k2;
    }

    /**
     * 先对k3.left 右旋 在k3左旋
     * @param k3
     * @return
     */
    private BinaryNode doubleWithLeftChild(BinaryNode k3) {
        k3.left=rotateWithRightChild(k3.left);
        BinaryNode k2=rotateWithLeftChild(k3);
        return k2;
    }

    /**
     * 单次右旋
     * @param k1
     * @return
     */
    private BinaryNode rotateWithRightChild(BinaryNode k1) {
        BinaryNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left),height(k1.right))+1;
        k2.height = Math.max(k1.height,height(k2.right))+1;
        return k2;
    }

    /**
     * 单次左旋
     * @param k2
     * @return
     */
    private BinaryNode rotateWithLeftChild(BinaryNode k2) {
        BinaryNode k1 = k2.left;
        k2.left = k1.right;
        k1.right =k2;
        k2.height = Math.max(height(k2.left),height(k2.right))+1;
        k1.height = Math.max(height(k1.left),k2.height)+1;
        return k1;
    }

    /**
     * 前序遍历
     *
     * @param t
     */
    private void printTree(BinaryNode t) {
        if (t == null) {
            return;
        }
        System.out.print(t.element + " ");
        printTree(t.left);
        printTree(t.right);
    }

    /**
     * 树节点，在节点高度属性
     * @param <T>
     */
    private static class BinaryNode<T> {
        private T element;
        private BinaryNode left;
        private BinaryNode right;
        /**
         * 为了树便利的查找树的平衡条件，在节点中引入节点高度。
         */
        private int height;  //节点高度，叶子节点的高度为0

        public BinaryNode(T element) {
            this(element, null, null);
        }

        public BinaryNode(T element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height =0;
        }
    }

}





