package com.durex.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author durex
 */
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

    /**
     * 返回二分搜索树的大小
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断二分搜索树是否为空
     * 为空返回true 非空返回false
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加结点
     * @param t 被添加的结点
     */
    public void add(T t) {
       root = add(root, t);
    }

    /**
     * 递归实现二分搜索树的添加
     * @param node 递归子树
     * @param t 被添加的结点
     * @return Node
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
     * @param t 被添加的结点
     */
    public void addNonRecursive(T t) {
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
                // 相等就替换
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

    /**
     * 判断树中是否存在某结点
     * 存在返回true 不存在返回false
     * @param t 要搜索的结点
     * @return boolean
     */
    public boolean contains(T t) {
        return contains(root, t);
    }

    /**
     * 递归判断树中是否存在某结点
     * @param node 递归的子树
     * @param t 要搜索的结点
     * @return boolean
     */
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
     * 判断树中是否存在某结点
     * @param t 要搜索的结点
     * @return boolean
     */
    public boolean containsNonRecursive(T t) {
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

    /**
     * 递归前序遍历二叉树
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 递归前序遍历二叉树的具体实现
     * @param node 递归的子树
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.t + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归前序遍历二叉树
     */
    public void preOrderNonRecursive() {
        if (root == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        Node currentNode = null;
        while (!nodeStack.isEmpty()) {
            currentNode = nodeStack.pop();
            System.out.print(currentNode.t + "\t");
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
        }
    }

    /**
     *  层序遍历
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        Node currentNode = null;
        while (!nodeQueue.isEmpty()) {
            currentNode = nodeQueue.remove();
            System.out.print(currentNode.t + "\t");
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
            }
        }
    }

    /**
     * 递归中序遍历二叉树
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 递归中序遍历二叉树的具体实现
     * @param node 递归的子树
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.t + "\t");
        inOrder(node.right);
    }

    /**
     * 非递归中序遍历二叉树
     */
    public void inOrderNonRecursive() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node node = stack.pop();
                System.out.print(node.t + "\t");
                currentNode = node.right;
            }
        }
    }

    /**
     * 递归后序遍历二叉树
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 递归后序遍历二叉树的具体实现
     * @param node 递归的子树
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.t + "\t");
    }

    /**
     * 非递归后序遍历二叉树
     */
    public void postOrderNonRecursive() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        Node previousNode = null;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node top = stack.peek();
                if (top.right == null || previousNode == top.right) {
                    top = stack.pop();
                    System.out.print(top.t + "\t");
                    previousNode = top;
                } else {
                    currentNode = top.right;
                }
            }
        }
    }

    public T minimum() {
        if (root == null) {
            return null;
        }
        return minimum(root).t;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public T maximum() {
        if (root == null) {
            return null;
        }
        return maximum(root).t;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public T removeMin() {
        if (root == null) {
            throw new RuntimeException("bst is empty");
        }
        T t = minimum();
        root = removeMin(root);
        return t;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public T removeMax() {
        if (root == null) {
            throw new RuntimeException("bst is empty");
        }
        T t = maximum();
        root = removeMax(root);
        return t;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(T t) {
        if (root == null) {
            throw new RuntimeException("bst is empty");
        }
        root = remove(root, t);
    }

    private Node remove(Node node, T t) {
        if (node == null) {
            return null;
        }
        if (node.t.compareTo(t) > 0) {
            node.left = remove(node.left, t);
        } else if (node.t.compareTo(t) < 0) {
            node.right = remove(node.right, t);
        } else {
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * 二叉树遍历字符串
     * @param node 二叉树根结点
     * @param depth 遍历的深度
     * @param stringBuilder 字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthString(depth)).append("null\n");
            return;
        }
        stringBuilder.append(generateDepthString(depth)).append(node.t).append("\n");
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
