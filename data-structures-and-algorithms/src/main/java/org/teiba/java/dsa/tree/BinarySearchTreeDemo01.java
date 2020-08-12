package org.teiba.java.dsa.tree;

import java.time.Year;

/**
 * 二叉查找树
 *
 * @author zail
 */
public class BinarySearchTreeDemo01 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(13);
        
        Tree tree = new Tree(root);
        TreeNode treeNode = tree.find(13);
        System.out.println(treeNode);
        
        treeNode = tree.find(20);
        System.out.println(treeNode);
    }
    
    static class Tree {
        TreeNode root;
        
        public Tree(TreeNode root) {
            this.root = root;
        }
        
        public TreeNode find(int val) {
            if (this.root == null) return null;
            TreeNode p = root;
            while (p != null) {
                if (p.val == val)
                    return p;
                else if (val < p.val)
                    p = p.left;
                else if (val > p.val)
                    p = p.right;
            }
            return null;
        }
        
        public boolean insert(Integer val) {
            TreeNode node = new TreeNode(val);
            
            // 边界条件
            if (root == null) root = node;
            
            TreeNode p = root;
            while (p != null) {
                if (val > p.val) {
                    if (p.right == null) {
                        p.right = node;
                        return true;
                    }
                    p = p.right;
                }
                else {
                    if (p.left == null) {
                        p.left = node;
                        return true;
                    }
                    p = p.left;
                }
            }
            
            return false;
        }
    }
    
    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(Integer val) {
            this.val = val;
        }
        
        @Override
        public String toString() {
            return "TreeNode{" +
                "val=" + val +
                '}';
        }
    }
    
}
