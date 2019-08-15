package com.durex.stack;

/**
 * @author durex
 */
public class Array<T> {
    T[] data;
    int size;

    /**
     * 构造函数
     * @param capacity
     */
    public Array(int capacity) {
        data = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造默认是capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 返回数组实际的大小
     * @return int
     */
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
       add(size, e);
    }

    /**
     * 指定索引添加元素
     * @param index 待插入的索引
     * @param e 被插入的元素
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
           reSize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 给数组扩容
     * @param newCapacity 新的容量
     */
    private void reSize(int newCapacity) {
        T[] newData = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 返回指定索引的元素
     * @param index 指定的索引
     * @return T 返回的元素
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 替换指定索引的元素
     * @param index 被替换元素的索引
     * @param e 替换的元素
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断数组是否包含此元素
     * @param e 需要查看的元素
     * @return 是否包含
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素
     * @param e 查找的元素
     * @return int 查找的元素的索引
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 删除指定索引的元素
     * @param index 待删除元素的索引
     * @return T 被删除的元素
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index <= size.");
        }
        T result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if ((size == data.length / 4) && (data.length / 2 != 0)) {
            reSize(data.length / 2);
        }
        return result;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除一个指定的元素，如果她存在
     * @param e 被删除的元素
     * @return boolean 删除是否成功
     */
    public boolean removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
