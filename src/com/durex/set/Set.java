package com.durex.set;

/**
 * @author gelong
 * @date 2020/5/3 14:19
 */
public interface Set<T> {
    /**
     * 添加元素
     * @param t 元素
     */
    void add(T t);

    /**
     * 删除元素
     * @param t 元素
     */
    void remove(T t);

    /**
     * 是否包含某个元素
     * @param t 元素
     * @return boolean
     */
    boolean contains(T t);

    /**
     * 返回集合的大小
     * @return int
     */
    int getSize();

    /**
     * 集合是否为空
     * @return boolean
     */
    boolean isEmpty();

}
