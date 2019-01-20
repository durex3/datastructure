package com.durex;

public class LinkedList<T> {
    private class Node {
        public T t;
        public Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList(T[] t) {

    }

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }



    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illagal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//        Node node = new Node(t);
//        node.next = prev.next;
//        prev.next = node;

        prev = new Node(t, prev.next);
        size++;

    }

    public void addFirst(T t) {
//        Node node = new Node(t);
//        node.next = head;
//        head = node;

        add(0, t);
    }

    public void addLast(T t) {
        add(size, t);
    }
}
