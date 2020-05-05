package com.durex.map;

/**
 * @author gelong
 * @date 2020/5/5 13:23
 */
public interface Map<K, V> {

    /**
     * 添加
     * @param key k
     * @param value v
     */
    void add(K key, V value);

    /**
     * 删除
     * @param key k
     * @return V
     */
    V remove(K key);

    /**
     * 是否包含
     * @param key k
     * @return V
     */
    boolean contains(K key);

    /**
     * 获取
     * @param key k
     * @return V
     */
    V get(K key);

    /**
     * 设置k的新v
     * @param key K
     * @param newValue v
     */
    void set(K key, V newValue);

    /**
     * 返回大小
     * @return int
     */
    int getSize();

    /**
     * 是否为空
     * @return boolean
     */
    boolean isEmpty();
}
