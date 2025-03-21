package com.sample.ecomm.hacker;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    public Node (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MyTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node root = null;
        while(n-- > 0) {
            root = insert(root, scan.nextInt());
        }
        scan.close();

        System.out.println("Pre-Order");
        preOrder(root);

        System.out.println("Post-Order");
        postOrder(root);

        System.out.println("In-Order");
        inOrder(root);

        System.out.println("Level-Order");
        bfsLevelOrder(root);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        } else {
            Node cur;
            if (val <= root.val) {
                cur = insert(root.left, val);
                root.left = cur;
            } else {
                cur = insert(root.right, val);
                root.right = cur;
            }

            return root;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val+" ");

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }

    public static void bfsLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}
