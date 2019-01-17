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
    private Node head;
    private int size;

    public LinkedList(T[] t) {

    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T t) {
//        Node node = new Node(t);
//        node.next = head;
//        head = node;

        head = new Node(t, head);
        size++;

    }

    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index");
        }
        if (index == 0) {
            addFirst(t);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(t);
//            node.next = prev.next;
//            prev.next = node;

            prev = new Node(t, prev.next);
            size++;
        }
    }

    public void addLast(T t) {
        add(size, t);
    }
}
