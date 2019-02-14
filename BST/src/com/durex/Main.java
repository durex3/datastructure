package com.durex;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add2(num);
        }
        //System.out.println(bst.toString());
        bst.preOrder();
        System.out.println();
        bst.preOrderNonrecursive();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
    }
}
