package org.teiba.java.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zail
 */
public class BinaryTreeLevelOrderTraversalDemo02 {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        List<List<Integer>> levelOrderTree = levelOrder(root);
        System.out.println(levelOrderTree);
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 边界条件
        if (root == null) return new ArrayList<>(0);
        
        // 用来遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 当前层的所有节点
        Queue<TreeNode> curTreeNodes = new LinkedList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curTreeNodes.offer(node);
            
            // 如果队列空了，说明是该层最后一个节点
            if (queue.isEmpty()) {
                List<Integer> list = new ArrayList<>(curTreeNodes.size());
                // 遍历当前层的所有节点
                while (!curTreeNodes.isEmpty()) {
                    TreeNode curNode = curTreeNodes.poll();
                    list.add(curNode.val);
                    
                    // 把该层中所有的子节点都加入到队列中
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
        Integer val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(Integer val) {
            this.val = val;
        }
    }
    
}
