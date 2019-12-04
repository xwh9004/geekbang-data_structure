package com.example;

/**
 * <p><b>Description:</b>  TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Xu at 15:16 on 2019/11/19
 * @version V0.1
 * @classNmae LinkList
 */
public class LinkedList<E> {

    private Node<E> head;

    public LinkedList(){
        head = new Node<>(null,null);
    }

    public void add(E item){

        Node<E> node = new Node<>(item,null);
        Node p = head;
        while (p.next!=null){
            p = p.next;
        }
        p.next =node;
    }

    public E find(E item){
        Node p = head;
        while (p.next!=null){
            p = p.next;
            if(p!=null&&p.item.equals(item)){
                return (E) p.item;
            }
        }
       return null;
    }

    public boolean checkCircle(){
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,null);
        Node node3= new Node(3,null);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node1;
        head.next = node1;
        Node fast = head;
        Node slow = head;
        while (fast!=null&&fast.next!=null){
            fast =fast.next.next;
            slow =slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public LinkedList reverse(){
        if(head==null || head.next==null){
            return null;
        }
        Node current = head.next;   //记录链表位置，移动指针
        Node p =head.next;  //新链表的起点
        Node next = null;
        while (current!=null){
            current =current.next;
            p.next =next;
            next = p;
            p = current;

        }
        head.next = next;
        return this;
    }

    public void print(){
        if(head != null && head.next ==null){
            System.out.println("LinkList is empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p.next!=null){
            p = p.next;
            sb.append(p.item.toString());
            sb.append("->");
        }
        System.out.println(sb.substring(0,sb.lastIndexOf("->")));
    }


    private class Node<E>{
        private E item;
        Node<E> next;

        public Node(E item,Node next){
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        boolean res=list.checkCircle();
        System.out.println(res);
        try{

        }catch (Throwable e){

        }
    }
}
