package org.teiba.java.dsa.tree;

/**
 * @author zail
 */
public class BinarySearchTreeDemo02 {
    
    public static void main(String[] args) {
    
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
                // insertByRecursion(root, newNode);
                insertByLoop(root, newNode);
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
    
        @Override
        public String toString() {
            return "BinarySearchTreeNode{" +
                "key=" + key +
                ", value=" + value +
                ", \nleft=" + left +
                ", \tright=" + right +
                '}';
        }
    }
    
}
