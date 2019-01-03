package com.durex;

public interface Stack<T> {

    int getSize();
    boolean isEmpty();
    void push(T t);
    T pop();
    T peek();
}
