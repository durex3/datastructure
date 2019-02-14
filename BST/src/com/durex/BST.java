package com.durex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
       root = add(root, t);
    }

    /**
     * 递归实现二分搜索树的添加
     * @param node
     * @param t
     * @return
     */
    private Node add(Node node, T t) {
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
     * @param t
     */
    public void add2(T t) {
        if (root == null) {
            root = new Node(t);
            size++;
            return;
        }
        Node current = root;
        Node parent = root;
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

    private boolean contains(Node node, T t) {
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
     * @param t
     * @return
     */
    public boolean contains2(T t) {
        if (root == null) {
            return false;
        }
        Node current = root;
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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.t);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNonrecursive() {
        if (root == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        Node currentNode = null;
        while (!nodeStack.isEmpty()) {
            currentNode = nodeStack.pop();
            System.out.println(currentNode.t);
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
        }
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Node currentNode = null;
        while (!nodeQueue.isEmpty()) {
            currentNode = nodeQueue.remove();
            System.out.println(currentNode.t);
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.t);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.t);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthString(depth) + "null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth) + node.t + "\n");
        generateBSTString(node.left, depth + 1, stringBuilder);
        generateBSTString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }

}
