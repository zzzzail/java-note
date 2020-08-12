package org.teiba.java.dsa.tree;

/**
 * @author zail
 * @since 2020/7/7
 */
public class RBTreeNode<T extends Comparable<T>> {
    
    /**
     * node value
     */
    private T value;
    
    /**
     * left child pointer
     */
    private RBTreeNode<T> left;
    
    /**
     * right child pointer
     */
    private RBTreeNode<T> right;
    
    /**
     * parent pointer
     */
    private RBTreeNode<T> parent;
    
    /**
     * color is red or not red
     */
    private boolean red;
    
    public RBTreeNode() {
    }
    
    public RBTreeNode(T value) {
        this.value = value;
    }
    
    public RBTreeNode(T value, boolean isRed) {
        this.value = value;
        this.red = isRed;
    }
    
    public T getValue() {
        return value;
    }
    
    void setValue(T value) {
        this.value = value;
    }
    
    RBTreeNode<T> getLeft() {
        return left;
    }
    
    void setLeft(RBTreeNode<T> left) {
        this.left = left;
    }
    
    RBTreeNode<T> getRight() {
        return right;
    }
    
    void setRight(RBTreeNode<T> right) {
        this.right = right;
    }
    
    RBTreeNode<T> getParent() {
        return parent;
    }
    
    void setParent(RBTreeNode<T> parent) {
        this.parent = parent;
    }
    
    public boolean getRed() {
        return red;
    }
    
    void setRed(boolean red) {
        this.red = red;
    }
    
    boolean isRed() {
        return red;
    }
    
    boolean isBlack() {
        return !red;
    }
    
    void makeRed() {
        red = true;
    }
    
    void makeBlack() {
        red = false;
    }
    
    /**
     * is leaf node
     **/
    boolean isLeaf() {
        return left == null && right == null;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}
