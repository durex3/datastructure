package com.durex;

public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (T[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        data = (T[])new Object[10 + 1];
        front = 0;
        tail = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(T t) {
        if ((tail + 1) % data.length == front) {
            reSize(getCapacity() * 2);
        }
        data[tail] = t;
        tail = (tail + 1) % data.length;
    }

    private void reSize(int newCapacity) {
        int size = getSize();
        T[] newData = (T[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        T result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (data.length / 4 == getSize() && getCapacity() / 2 != 0) {
            reSize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return tail >= front ? tail - front : data.length - front + tail;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue:size = %d, capacity = %d\n", getSize(), getCapacity()));
        stringBuilder.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
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
