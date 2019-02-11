package com.durex;

public class BST<T extends Comparable<T>> {

    private class Node {
        private T t;
        private Node left;
        private Node right;

        public Node(T t) {
            this.t = t;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T t) {
        add(root, t);
    }

    /**
     * 递归实现二分搜索树的添加
     * @param node
     * @param t
     * @return
     */
    public Node add(Node node, T t) {
        if (node == null) {
            size++;
            return new Node(t);
        }
        if (t.compareTo(node.t) < 0) {
            node.left = add(node.left, t);
        } else if (t.compareTo(node.t) > 0) {
            node.right = add(node.right, t);
        }
        return node;
    }

    /**
     * 非递归实现二分搜索树的添加
     * @param node
     * @param t
     */
    public void add2(Node node, T t) {
        if (node == null) {
            node = new Node(t);
            size++;
            return;
        }
        Node current = node;
        Node parent = node;
        while (current != null) {
            parent = current;
            if (t.compareTo(current.t) < 0) {
                current = current.left;
            } else if (t.compareTo(current.t) > 0) {
                current = current.right;
            } else {
                current.t = t;
                return;
            }
        }
        if (t.compareTo(parent.t) < 0) {
            parent.left = new Node(t);
        } else {
            parent.right = new Node(t);
        }
    }

    public boolean contains(T t) {
        return contains(root, t);
    }

    public boolean contains(Node node, T t) {
        if (node == null) {
            return false;
        }
        if (t.compareTo(node.t) == 0) {
            return true;
        } else if (t.compareTo(node.t) < 0) {
            return contains(node.left, t);
        } else {
            return contains(node.right, t);
        }
    }

    /**
     * 非递归查询
     * @param node
     * @param t
     * @return
     */
    public boolean contains2(Node node, T t) {
        if (node == null) {
            return false;
        }
        Node current = node;
        while (current != null) {
            if (t.compareTo(current.t) == 0) {
                return true;
            } else if (t.compareTo(current.t) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
}
