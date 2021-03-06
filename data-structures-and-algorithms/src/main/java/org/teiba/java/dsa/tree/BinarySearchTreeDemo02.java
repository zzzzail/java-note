package org.teiba.java.dsa.tree;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zail
 */
public class BinarySearchTreeDemo02 {
    
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4, new Date());
        tree.insert(2, 2);
        tree.insert(0, 0);
        tree.insert(1, 1);
        tree.insert(3, 3);
        System.out.println(tree);
        
        boolean flag = tree.contain(10);
        System.out.println(flag);
        flag = tree.contain(4);
        System.out.println(flag);
        
        flag = tree.containByRecursion(10);
        System.out.println(flag);
        flag = tree.containByRecursion(4);
        System.out.println(flag);
        
        Object obj = tree.search(4);
        System.out.println(obj);
        obj = tree.search(10);
        System.out.println(obj);
        
        obj = tree.searchByRecursion(4);
        System.out.println(obj);
        obj = tree.searchByRecursion(10);
        System.out.println(obj);
        
        System.out.println("------- pre order -------");
        tree.preOrder();
        System.out.println("------- in order -------");
        tree.inOrder();
        System.out.println("------- post order -------");
        tree.postOrder();
        
        // tree.destroy();
        // System.out.println(tree);
        System.out.println("------- level order -------");
        tree.levelOrder();
        
        System.out.println("------- level2 order -------");
        tree.levelOrder2();
        
        System.out.println("最小值：" + tree.minimum());
        System.out.println("最大值：" + tree.max());
    }
    
    static class BinarySearchTree {
        BinarySearchTreeNode head;
        int count;
        
        public BinarySearchTree() {
            this.head = null;
            this.count = 0;
        }
        
        public BinarySearchTree(BinarySearchTreeNode head) {
            this.head = head;
        }
        
        /**
         * 往树中插入一个元素
         * 如果key键重复，则把重复的数据删除
         *
         * @param key   键
         * @param value 值
         */
        public boolean insert(int key, Object value) {
            BinarySearchTreeNode newNode = new BinarySearchTreeNode(key, value);
            
            if (head == null) {
                head = newNode;
            }
            else {
                BinarySearchTreeNode root = head;
                insertByRecursion(root, newNode);
                // insertByLoop(root, newNode);
            }
            count++;
            
            return true;
        }
        
        /**
         * 递归插入新节点
         *
         * @param root    根节点
         * @param newNode 新节点
         * @return
         */
        private BinarySearchTreeNode insertByRecursion(BinarySearchTreeNode root, BinarySearchTreeNode newNode) {
            if (root == null) {
                return newNode;
            }
            
            // 如果key相等，则覆盖
            if (newNode.key < root.key) { // 放左边
                root.left = insertByRecursion(root.left, newNode);
            }
            else if (newNode.key > root.key) { // 放右边
                root.right = insertByRecursion(root.right, newNode);
            }
            else { // root.key == newNode.key
                root.value = newNode.value;
            }
            
            return root;
        }
        
        /**
         * 使用循坏的方式插入新元素
         *
         * @param root    根节点
         * @param newNode 新插入的节点
         */
        private void insertByLoop(BinarySearchTreeNode root, BinarySearchTreeNode newNode) {
            while (root != null) {
                if (newNode.key < root.key) { // 放左边
                    if (root.left == null) {
                        root.left = newNode;
                        return;
                    }
                    root = root.left;
                }
                else if (newNode.key > root.key) {
                    if (root.right == null) {
                        root.right = newNode;
                        return;
                    }
                    root = root.right;
                }
                else { // newNode.key == root.key 覆盖值
                    root.value = newNode.value;
                    return;
                }
            }
        }
        
        /**
         * 返回树的大小
         *
         * @return
         */
        public int size() {
            return count;
        }
        
        /**
         * 树是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return count == 0;
        }
        
        /**
         * 判断是否包含key这个键的值
         *
         * @param key 主键
         * @return 是否存在
         */
        public boolean contain(int key) {
            BinarySearchTreeNode root = head;
            while (root != null) {
                if (key < root.key) { // 左边查找
                    root = root.left;
                }
                else if (key > root.key) { // 右边查找
                    root = root.right;
                }
                else { // key == root.key
                    return true;
                }
            }
            return false;
        }
        
        public boolean containByRecursion(int key) {
            BinarySearchTreeNode root = head;
            return containByRecursion(root, key);
        }
        
        private boolean containByRecursion(BinarySearchTreeNode root, int key) {
            if (root == null)
                return false;
            
            if (key < root.key)
                return containByRecursion(root.left, key);
            else if (key > root.key)
                return containByRecursion(root.right, key);
            else
                return true;
        }
        
        public Object search(int key) {
            BinarySearchTreeNode root = head;
            while (root != null) {
                if (key < root.key) { // 左
                    root = root.left;
                }
                else if (key > root.key) { // 右
                    root = root.right;
                }
                else { // key == root.key
                    return root.value;
                }
            }
            
            return null;
        }
        
        public Object searchByRecursion(int key) {
            return searchByRecursion(head, key);
        }
        
        private Object searchByRecursion(BinarySearchTreeNode root, int key) {
            if (root == null)
                return null;
            
            if (key < root.key)
                return searchByRecursion(root.left, key);
            else if (key > root.key)
                return searchByRecursion(root.right, key);
            else
                return root.value;
        }
        
        /**
         * 前序遍历
         */
        public void preOrder() {
            preOrder(head);
        }
        
        private void preOrder(BinarySearchTreeNode node) {
            if (node != null) {
                System.out.println(node.key);
                preOrder(node.left);
                preOrder(node.right);
            }
        }
        
        /**
         * 中序遍历
         */
        public void inOrder() {
            inOrder(head);
        }
        
        private void inOrder(BinarySearchTreeNode node) {
            if (node != null) {
                inOrder(node.left);
                System.out.println(node.key);
                inOrder(node.right);
            }
        }
        
        /**
         * 后序遍历
         */
        public void postOrder() {
            postOrder(head);
        }
        
        private void postOrder(BinarySearchTreeNode node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.key);
            }
        }
        
        /**
         * 清空对象
         */
        public void destroy() {
            destroy(head);
        }
        
        private void destroy(BinarySearchTreeNode node) {
            if (node != null) {
                destroy(node.left);
                destroy(node.right);
                
                node = null;
                count--;
            }
        }
        
        /**
         * 层序遍历（广度优先的遍历）
         * 需要引入一个队列
         */
        public void levelOrder() {
            // 申请一个队列
            Queue<BinarySearchTreeNode> queue = new LinkedList<>();
            queue.offer(head);
            Queue<BinarySearchTreeNode> curLevelNodes = new LinkedList<>();
            
            // 第一层遍历，如果队列为空了，则结束循环
            while (!queue.isEmpty()) {
                // 取出元素
                BinarySearchTreeNode node = queue.poll();
                System.out.println(node.key);
                curLevelNodes.offer(node);
                
                // 如果队列中没有内容了，则说明当前层遍历完成
                if (queue.isEmpty()) {
                    while (!curLevelNodes.isEmpty()) {
                        BinarySearchTreeNode curNode = curLevelNodes.poll();
                        if (curNode.left != null) {
                            queue.offer(curNode.left);
                        }
                        if (curNode.right != null) {
                            queue.offer(curNode.right);
                        }
                    }
                }
            }
        }
        
        /**
         * 层序遍历（广度优先的遍历）
         * 需要引入一个队列
         */
        public void levelOrder2() {
            Queue<BinarySearchTreeNode> queue = new LinkedList<>();
            queue.offer(head);
            
            while (!queue.isEmpty()) {
                BinarySearchTreeNode node = queue.poll();
                System.out.println(node.key);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        /**
         * 树中的最小值
         *
         * @return
         */
        public int minimum() {
            if (count == 0) return -1;
            
            BinarySearchTreeNode root = minimum(head);
            return root.key;
        }
        
        private BinarySearchTreeNode minimum(BinarySearchTreeNode root) {
            if (root.left == null) {
                return root;
            }
            
            return minimum(root.left);
        }
        
        public int max() {
            if (count == 0) return -1;
            
            BinarySearchTreeNode root = max(head);
            return root.key;
        }
        
        private BinarySearchTreeNode max(BinarySearchTreeNode root) {
            if (root.right == null) {
                return root;
            }
            return max(root.right);
        }
        
        /**
         * 从二叉树中删除最小值的节点
         */
        public void removeMin() {
            if (head != null) {
                BinarySearchTreeNode node = removeMin(head);
            }
        }
        
        /**
         * 删除掉以root为根的二分搜索树中的最小节点
         * 返回删除节点后新的二分搜索树的根
         *
         * @param root
         * @return
         */
        private BinarySearchTreeNode removeMin(BinarySearchTreeNode root) {
            if (root.left == null) {
                // 如果相应的右节点存在，右节点要代替要删除的节点，并成为二分搜索树的根
                BinarySearchTreeNode rightNode = root.right;
                root.right = null;
                count--;
                return rightNode;
            }
            
            root.left = removeMin(root.left);
            return root;
        }
        
        public void removeMax() {
            if (head != null) {
                BinarySearchTreeNode node = removeMax(head);
            }
        }
        
        /**
         * 删除掉以root为根的二分搜索树中的最大节点
         * 返回删除节点后新的二分搜索树的根
         *
         * @param root
         * @return
         */
        private BinarySearchTreeNode removeMax(BinarySearchTreeNode root) {
            if (root.right == null) {
                BinarySearchTreeNode leftNode = root.left;
                root.left = null;
                count--;
                return leftNode;
            }
            
            root.right = removeMax(root.right);
            return root;
        }
        
        /**
         * 删除键为key的节点
         *
         * @param key
         */
        public void remove(int key) {
            remove(head, key);
        }
        
        /**
         * 删除以root为根的二分搜索树中键值为key的节点
         * 返回删除节点后新的二分搜索树的根
         *
         * @param root
         * @param key
         * @return
         */
        private BinarySearchTreeNode remove(BinarySearchTreeNode root, int key) {
            // 没有要查找的节点
            if (root == null) {
                return null;
            }
            
            if (key < root.key) {
                root.left = remove(root.left, key);
                return root;
            }
            else if (key > root.key) {
                root.right = remove(root.right, key);
                return root;
            }
            else { // key == root.key
                // 如果只有右子节点的话
                if (root.left == null) {
                    BinarySearchTreeNode rightNode = root.right;
                    root.right = null;
                    count--;
                    return root.right;
                }
                // 如果只有左子节点
                if (root.right == null) {
                    BinarySearchTreeNode leftNode = root.left;
                    root.left = null;
                    count--;
                    return root.left;
                }
                // root的左右子节点都不为空
                // 找到要比删除节点大的最小节点， 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                BinarySearchTreeNode successor = new BinarySearchTreeNode(minimum(root.right));
                count++;
                
                successor.right = removeMin(root.right);
                successor.left = root.left;
                
                root.left = root.right = null;
                count--;
                
                return successor;
            }
            
        }
        
        @Override
        public String toString() {
            return "BinarySearchTree{" +
                "head=" + head +
                ", count=" + count +
                '}';
        }
        
        
    }
    
    static class BinarySearchTreeNode {
        // 主键
        int key;
        // 值
        Object value;
        // 左节点
        BinarySearchTreeNode left;
        // 右节点
        BinarySearchTreeNode right;
        
        public BinarySearchTreeNode(int key, Object value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
        
        public BinarySearchTreeNode(BinarySearchTreeNode node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
        
        @Override
        public String toString() {
            return "BinarySearchTreeNode{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
    
}
