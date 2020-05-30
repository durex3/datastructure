package com.durex.heap;

/**
 * @author gelong
 * @date 2020/5/9 0:08
 */
public class MaxHeap<T extends Comparable<T>> {

    private Array<T> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(T[] arr){
        data = new Array<>(arr);
        if(arr.length != 1){
            for(int i = parent(arr.length - 1) ; i >= 0 ; i --) {
                siftDown(i);
            }
        }
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public int getSize() {
        return data.getSize();
    }

    private int parent(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("index doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index doesn't have child.");
        }
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index doesn't have child.");
        }
        return index * 2 + 2;
    }

    public void add(T t) {
        data.addLast(t);
        siftUp(getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            // 交换结点和结点的父亲的位置
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    public T findMax() {
        if (getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    private void siftDown(int k) {
        while (leftChild(k) < getSize()) {
            int left = leftChild(k);
            int right = rightChild(k);
            int max = left;
            // 取左右孩子中最大的结点的下标
            if (right < getSize() && data.get(left).compareTo(data.get(right)) < 0) {
                max = right;
            }
            // 如果是父亲结点大
            if (data.get(k).compareTo(data.get(max)) >= 0) {
                break;
            }
            data.swap(k, max);
            k = max;
        }
    }

    public T extractMax() {
        T t = findMax();
        // 交换堆顶和堆尾的结点
        data.swap(0, getSize() - 1);
        data.removeLast();
        siftDown(0);
        return t;
    }

    public T replace(T t) {
        T result = findMax();
        data.set(0, t);
        siftDown(0);
        return result;
    }
}
