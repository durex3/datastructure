package com.durex.bst;

/**
 * @author durex
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.addNonRecursive(num);
        }

        System.out.println("最小元素");
        System.out.println(bst.minimum());

        System.out.println("最大元素");
        System.out.println(bst.maximum());

        System.out.println("删除任意元素");
        bst.remove(3);

        System.out.println("前序遍历");
        bst.preOrder();
        System.out.println();
        bst.preOrderNonRecursive();
        System.out.println();

        System.out.println("中序遍历");
        bst.inOrder();
        System.out.println();
        bst.inOrderNonRecursive();
        System.out.println();

        System.out.println("后序遍历");
        bst.postOrder();
        System.out.println();
        bst.postOrderNonRecursive();
        System.out.println();

        System.out.println("层序遍历");
        bst.levelOrder();
        System.out.println();

    }
}
