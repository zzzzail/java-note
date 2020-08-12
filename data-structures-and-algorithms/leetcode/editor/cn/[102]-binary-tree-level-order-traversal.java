// 102-binary-tree-level-order-traversal
// 二叉树的层序遍历
// 2020-08-12 11:16:20
// 
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 594 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * BFS 广度优先遍历
 * 1. 当前层的所有节点都添加到queue队列中
 * 2. 遍历queue队列，把值添加到数组中
 * 3. 把queue的所有子节点都再次加入到队列中
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 边界条件
        if (root == null) return new ArrayList(0);
        
        // 申请一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 存储树的当前层的所有节点
        Queue<TreeNode> curTreeNodes = new LinkedList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        // 遍历队列
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            curTreeNodes.offer(node);
            
            // 如果队列为空了，则说明已经走到了当前层的最后一个节点
            if (queue.isEmpty()) {
                List<Integer> list = new ArrayList<>(curTreeNodes.size());
                while (!curTreeNodes.isEmpty()) {
                    TreeNode curNode = curTreeNodes.poll();
                    list.add(curNode.val);
                    
                    // 把当前层的所有子节点都加入到队列中
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
}
//leetcode submit region end(Prohibit modification and deletion)
