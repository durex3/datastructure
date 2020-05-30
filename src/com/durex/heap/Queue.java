package com.durex.heap;

/**
 * @author durex
 */
public interface Queue<T> {

    void enqueue(T t);

    T dequeue();

    T getFront();

    int getSize();

    boolean isEmpty();
}
