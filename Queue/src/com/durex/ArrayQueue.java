package com.durex;

public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue:");
        stringBuilder.append("front[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]tail");
        return stringBuilder.toString();
    }
}
