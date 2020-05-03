package com.durex.set;

/**
 * @author durex
 */
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//        Node node = new Node(t);
//        node.next = prev.next;
//        prev.next = node;

        prev.next = new Node(t, prev.next);
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

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.t = t;
    }

    public boolean contains(T t) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.t.equals(t)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node result = prev.next;
        prev.next = result.next;
        result.next = null;
        size--;
        return result.t;
    }

    public T removeFirst() {
       return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T t) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.equals(t)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = prev.next.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            result.append(cur + "->");
            cur = cur.next;
        }
        result.append("NULL");
        return result.toString();
    }
}
