package com.algo.tree;

public class BinaryTree {

    TreeNode root = null;

    public BinaryTree(int data) {
        this.root = new TreeNode(data);
    }

    public void add(int data) {
        if( root == null ) root = new TreeNode(data);
        addRecursively(root, data);
    }

    private TreeNode addRecursively(TreeNode node, int data) {
        if( node == null ) return new TreeNode(data);

        if( data < node.data) {
            node.left = addRecursively(node.left, data);
        }

        if( data > node.data) {
            node.right = addRecursively(node.right, data);
        }
        return node;
    }


    class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public TreeNode(TreeNode left, int data, TreeNode right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

    }
}
