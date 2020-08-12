package org.teiba.java.dsa.tree;

/**
 * @author zail
 */
public class TreeIteratorDemo01 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        root.right = new TreeNode(3, null, null);
        root.left.left = new TreeNode(4, null, null);
        root.left.right = new TreeNode(5, null, null);
        root.right.left = new TreeNode(6, null, null);
        root.right.right = new TreeNode(7, null, null);
        
        Tree tree = new Tree(root);
        System.out.println("-------------前序遍历");
        iteratePreOrder(tree.root);
        System.out.println("-------------中序遍历");
        iterateInOrder(tree.root);
        System.out.println("-------------后序遍历");
        iteratePostOrder(tree.root);
    }
    
    /**
     * 前序遍历
     *
     * @param root
     */
    private static void iteratePreOrder(TreeNode root) {
        if (root == null) return;
        
        System.out.println(root);
        iteratePreOrder(root.left);
        iteratePreOrder(root.right);
    }
    
    /**
     * 中序遍历
     *
     * @param root
     */
    private static void iterateInOrder(TreeNode root) {
        if (root == null) return;
        iterateInOrder(root.left);
        System.out.println(root);
        iterateInOrder(root.right);
    }
    
    /**
     * 后序遍历
     *
     * @param root
     */
    private static void iteratePostOrder(TreeNode root) {
        if (root == null) return;
        
        iteratePostOrder(root.left);
        iteratePostOrder(root.right);
        System.out.println(root);
    }
    
    static class Tree {
        TreeNode root;
        
        public Tree(TreeNode root) {
            this.root = root;
        }
    }
    
    static class TreeNode {
        Object val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(Object val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public String toString() {
            return "" + val;
        }
    }
    
}
