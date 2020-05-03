package com.durex.set;

/**
 * @author gelong
 * @date 2020/5/3 13:41
 */
public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private BST<T> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(T t) {
        bst.add(t);
    }

    @Override
    public void remove(T t) {
        bst.remove(t);
    }

    @Override
    public boolean contains(T t) {
        return bst.contains(t);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
