package com.durex.set;

/**
 * @author gelong
 * @date 2020/5/3 14:52
 */
public class LinkedListSet<T> implements Set<T> {

    private LinkedList<T> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T t) {
        if (!linkedList.contains(t)) {
            linkedList.addFirst(t);
        }
    }

    @Override
    public void remove(T t) {
        linkedList.removeElement(t);
    }

    @Override
    public boolean contains(T t) {
        return linkedList.contains(t);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
