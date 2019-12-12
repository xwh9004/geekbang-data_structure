package com.example;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p><b>Description:</b>  简单的实现
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:49 on 2019/12/2
 * @version V0.1
 * @classNmae BinaryTree
 */
public class BinaryTree<E> {

    private BinaryNode root;

    public BinaryTree() {

    }

    /**
     * 插入规则 left<root<right
     *
     * @param item
     */
    public void add(int item) {
        root = addChild(root, item);
    }

    /**
     * @param root
     * @param item
     */
    private BinaryNode addChild(BinaryNode root, int item) {
        if (root == null) {
            BinaryNode node = new BinaryNode(item);
            return node;
        }
        if (item > root.item) {
            root.right = addChild(root.right, item);
        } else {
            root.left = addChild(root.left, item);
        }
        return root;
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        System.out.println("post order");
        this.doPostOrder(root);
        System.out.println();
    }

    private void doPostOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        doPostOrder(root.left);
        doPostOrder(root.right);
        System.out.print(root + " ");
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        System.out.println("in order");
        this.doInOrder(root);
        System.out.println();
    }

    private void doInOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        doInOrder(root.left);
        System.out.print(root + " ");
        doInOrder(root.right);

    }
    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println("pre order");
        this.doPreOrder(root);
        System.out.println();
    }

    private void doPreOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root + " ");
        doPreOrder(root.left);
        doPreOrder(root.right);

    }

    /**
     * 获得树的高度
     * 递归遍历
     * @return
     */
    public int height(){
        return  height(root);
    }


    /**
     * 递归计算左右子树高度
     * @param root
     * @return
     */
    private int height(BinaryNode root){
        if(root==null){
            return 0;
        }else{
            return 1+Math.max(height(root.left),height(root.right));
        }
       
    }

    /**
     * 还可以再优化
     * @return
     */
    public int getDepthBy(){
        Queue queue = new ArrayDeque();
        queue.add(root);
        queue.add(root);
        int level =0;
        BinaryNode head = root;
        while (queue.size()!=0){
            BinaryNode node = (BinaryNode)queue.remove();
            if(node==head){
                    if(queue.size()==0){
                        break;
                    }
                    level++;
                    head =(BinaryNode)queue.remove();
                    queue.add(head);
                    node =head;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }

      return level;

    }
    /**
     * 深度优先遍历
     */
    public void levelOrder() {
        System.out.println("level order");
        Queue queue = new ArrayDeque();
        queue.add(root);
        doLevelOrder(queue);
        System.out.println();
    }




    private void doLevelOrder(Queue queue) {
        if(queue.size()==0){
            return;
        }
        BinaryNode node = (BinaryNode)queue.remove();
        System.out.print(node.item+" ");
        if(node.left!=null){
            queue.add(node.left);
        }
        if(node.right!=null){
            queue.add(node.right);
        }
        doLevelOrder(queue);
    }

    private class BinaryNode {
        public BinaryNode left;
        public BinaryNode right;
        public int item;

        public BinaryNode(int item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(6);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(7);
        tree.add(13);
        tree.add(9);
        System.out.println(tree.height());
        System.out.println(tree.getDepthBy());
        String s= "Example";
        s=s+1;
//        int i = s.length();
    }


}
