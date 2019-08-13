package com.durex.queue;

/**
 * @author durex
 */
public class LinkedListQueue<T> implements Queue<T> {

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
    private Node tail;
    private int size;

    public LinkedListQueue() {
        dummyHead = new Node();
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(T t) {
        if (tail == null) {
            tail = new Node(t);
            dummyHead.next = tail;
        } else {
            tail.next = new Node(t);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node result = dummyHead.next;
        dummyHead.next = result.next;
        result.next = null;
        if (dummyHead.next == null) {
            tail = null;
        }
        size--;
        return result.t;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return dummyHead.next.t;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front ");
        Node cur = dummyHead.next;
        while (cur != null) {
            result.append(cur + "->");
            cur = cur.next;
        }
        result.append("NULL tail");
        return result.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
