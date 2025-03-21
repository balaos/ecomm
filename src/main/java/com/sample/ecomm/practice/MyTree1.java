package com.sample.ecomm.practice;

import java.util.Scanner;

class TNode {
    int val;
    TNode left;
    TNode right;

    TNode (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class MyTree1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TNode root = null;
        while (n-- > 0) {
            root = insert(root, sc.nextInt());
        }

        System.out.println("Pre-Order");
        preOrder(root);

        System.out.println("Post-Order");
        postOrder(root);

        System.out.println("In-Order");
        inOrder(root);

        System.out.println("Level-Order");
        levelOrder(root);

    }

    public static void preOrder (TNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val+" ");

        preOrder(root.left);

        preOrder(root.right);
    }

    public static void postOrder(TNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val+" ");
    }

    public static void inOrder(TNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }

    public static void levelOrder(TNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val+" ");
        if(root.left != null) levelOrder(root.left);
        if(root.right != null) levelOrder(root.right);

    }

    public static TNode insert (TNode root , int val) {
        if (root == null) {
            return new TNode(val);
        } else {
            TNode cur;
            if (val <= root.val) {
                cur = insert(root.left, val);
                root.left = cur;
            } else {
                cur = insert(root.right, val);
                root.right = cur;
            }
        }

        return root;

    }
}
