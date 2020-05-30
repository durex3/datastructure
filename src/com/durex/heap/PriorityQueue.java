package com.durex.heap;

/**
 * @author gelong
 * @date 2020/5/30 23:15
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private MaxHeap<T> heap;

    public PriorityQueue() {
        this.heap = new MaxHeap<>();
    }

    @Override
    public void enqueue(T t) {
        heap.add(t);
    }

    @Override
    public T dequeue() {
        return heap.extractMax();
    }

    @Override
    public T getFront() {
        return heap.findMax();
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.getSize() == 0;
    }
}
