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
        
        tree.insert(100);
        treeNode = tree.find(100);
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
        
        /**
         * 删除树中的某个节点
         *
         * @param val 要删除节点的值
         */
        public void delete(int val) {
            TreeNode p = root; // p指向要删除的节点，初始化指向根节点
            TreeNode pp = null; // pp记录的是p的父节点
            while (p != null && p.val != val) {
                pp = p;
                if (val > p.val) p = p.right;
                else p = p.left;
            }
            if (p == null) return; // 没有找到
            
            // 要删除的节点有两个子节点
            if (p.left != null && p.right != null) { // 查找右子树中最小节点
                TreeNode minP = p.right;
                TreeNode minPP = p; // minPP表示minP的父节点
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                p.val = minP.val; // 将minP的数据替换到p中
                p = minP; // 下面就变成了删除minP了
                pp = minPP;
            }
            
            // 删除节点是叶子节点或者仅有一个子节点
            TreeNode child; // p的子节点
            if (p.left != null)
                child = p.left;
            else if (p.right != null)
                child = p.right;
            else
                child = null;
            
            if (pp == null)
                root = child; // 删除的是根节点
            else if (pp.left == p)
                pp.left = child;
            else
                pp.right = child;
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
