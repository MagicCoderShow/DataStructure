package com.izrbh.datastructure.list;

/**
 * 单链表
 *
 * @param <T>
 */
public class LinkedList<T> {
    //头结点，头结点是为了方便在下面的方法中遍历链表用的
    public Node head = new Node(null);
    public int size;

    public LinkedList() {

    }

    /**
     * 获取指定下标元素值
     *
     * @param i 下标
     * @return 元素
     */
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new ArrayIndexOutOfBoundsException("获取的位置不合法");
        } else {
            //把第一个节点给临时节点temp，让temp遍历
            Node temp = head;
            //counter用来计数，找到i在链表里的节点位置,头结点不算链表的真实节点，所以从-1开始计数
            int counter = -1;
            while (temp != null) {
                if (counter == i) {
                    return (T) temp.t;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    /**
     * 添加元素
     *
     * @param t 元素
     */
    public void add(T t) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(t);
        size++;
    }

    /**
     * 指定位置添加元素
     *
     * @param i 下标
     * @param t 元素
     */
    public void add(int i, T t) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("插入的位置不合法");
        } else {
            Node temp = head;
            int counter = -1;
            while (temp != null) {
                if ((i - 1) == counter) {
                    //将i前面的节点指向node，node的指向i节点
                    Node node = new Node(t);
                    Node back = temp.next;
                    temp.next = node;
                    node.next = back;
                    size++;
                }
                temp = temp.next;
                counter++;
            }
        }
    }


    /**
     * 删除
     * @param i 下标
     */
    public void delete(int i) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("删除的位置不合法");
        } else {
            Node temp = head;
            int counter = -1;
            while (temp != null) {
                //将i前面的节点指向i后面的节点
                if ((i - 1) == counter) {
                    temp.next = temp.next.next;
                    size--;
                }
                counter++;
                temp = temp.next;
            }
        }
    }

    private class Node<T> {
        Node next;
        T t;

        Node(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("一");
        list.add("三");
        list.add("二");
        list.add("四");
        list.add("五");
        System.out.println(list.get(1));
        list.delete(1);
        list.add(2,"三");
        System.out.println(list.get(1));
    }
}