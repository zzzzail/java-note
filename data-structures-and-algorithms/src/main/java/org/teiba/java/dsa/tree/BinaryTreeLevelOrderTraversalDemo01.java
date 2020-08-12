package org.teiba.java.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zail
 */
public class BinaryTreeLevelOrderTraversalDemo01 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        List<List<Integer>> levelOrderTree = levelOrder2(root);
        System.out.println(levelOrderTree);
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 边界条件
        if (root == null) return new ArrayList<>(0);
        
        List<List<Integer>> result = new ArrayList<>();
        
        // 构建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        Queue<TreeNode> curLevelNodes = new LinkedList<>();
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevelNodes.offer(node);
            
            if (queue.isEmpty()) {
                List<Integer> list = new ArrayList<>(curLevelNodes.size());
                while (!curLevelNodes.isEmpty()) {
                    TreeNode curNode = curLevelNodes.poll();
                    list.add(curNode.val);
                    
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
                result.add(list);
            }
        }
        
        return result;
    }
    
    /**
     * 按照层级遍历树
     *
     * @param root 树的根节点
     * @return 返回一个二维数组
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        // 边界条件
        if (root == null) return new ArrayList<>(0);
        
        List<List<Integer>> result = new ArrayList<>();
        
        // 申请一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<TreeNode> curLevelNodes = new LinkedList<>();
        
        // 如果队列不为空，则继续遍历
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevelNodes.offer(node); // 添加到当前层的队列中存储
            
            // 如果队列空了，则说明树的一层遍历完，把所有的子节点加入到队列中
            if (queue.isEmpty()) {
                List<Integer> list = new ArrayList<>(curLevelNodes.size());
                
                while (!curLevelNodes.isEmpty()) {
                    TreeNode curNode = curLevelNodes.poll();
                    list.add(curNode.val);
                    
                    // 当前层所有的子节点添加到队列中
                    if (curNode.left != null)
                        queue.offer(curNode.left);
                    if (curNode.right != null)
                        queue.offer(curNode.right);
                }
                
                result.add(list);
            }
        }
        
        return result;
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
}
