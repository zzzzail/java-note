package org.teiba.java.dsa.tree;

/**
 * <p>平衡树在插入和删除的时候，会通过旋转操作将高度保持在logN。其中两款具有代表性的
 * 平衡树分别为AVL树和红黑树。AVL树由于实现比较复杂，而且插入和删除性能差，在实际
 * 环境下的应用不如红黑树。</p>
 *
 * <p>红黑树（Red-Black Tree， 以下简称RBTree）的实际应用非常广泛，比如linux内核
 * 中的完全公平调度器、高精度计时器、ext3文件系统等等，各种语言的函数库如Java的
 * TreeMap和TreeSet，C++ STL的map、multimap，multiset等。</p>
 *
 * <p>RBTree也是函数式语言中最常用的持久数据结构之一，在计算几何中也有重要的作用。值
 * 得一提的是，Java8中HashMap的实现也因为RBTree取代链表，性能有所提升。</p>
 * <p>
 * 红黑树的定义：
 * <ul>
 * <li>1. 每一个节点不是红色的就是黑色的。<li/>
 * <li>2. 根节点是黑色的<li/>
 * <li>3. 红色节点下必须是两个黑色的节点（父子节点之间不能出现两个连续的红色节点）<li/>
 * <li>4. 所有的叶节点（树的末梢节点）都是黑色的空节点<li/>
 * <li>5. 根节点遍历到任意一个叶节点（树的末梢节点）所经过路径上，经过的黑色节点数量相等<li/>
 * </ul>
 * <br/>
 *
 * <p>数据结构如下：</p>
 * <blockquote><pre>
 * class Node<T> {
 *   public T value;          // 值
 *   public Node<T> parent;   // 父节点
 *   public boolean isRed;    // 是否为红色的节点（非红即黑）
 *   public Node<T> left;     // 左子节点（比自己小的节点）
 *   public Node<T> right;    // 右子节点（比自己大的节点）
 * }
 * </pre></blockquote>
 *
 * <p>RBTree在理论上还是一颗BST树，但是它在对BST树的插入和删除操作时会维持树的平衡，
 * 即保证树的高度在[logN, logN+1]（理论上，极端的情况下，RBTree可以出现的高度可以达
 * 到2*logN， 但实际上很难遇到）。这样RBTree的查找时间复杂度始终保持在O(logN)，从而
 * 接近于理想的BST，RBTree的删除和插入操作的时间复杂度也是O(logN)。RBTree的查找操作
 * 就是BST的查找操作。<p/>
 * <p>
 * RBTree的操作
 * 1. RBTree的旋转操作
 *    目的： 使节点颜色符合定义，让RBTree的高度达到平衡（左右平衡）
 *    Rotate 分为 LeftRotate（左旋） 和 RightRotate（右旋）。
 *    区分左旋和右旋的方法是：
 *      左旋是向左逆时针旋转，待旋转的节点从右边上升到父节点就是左旋
 *      右旋是向右顺时针旋转，待旋转的节点从左边上升到父节点就是右旋
 * <p>
 *    ① 左旋转示意图：对节点x进行左旋转
 *          p                  p
 *         /                  /
 *        x                  y
 *       / \     ------>    / \
 *     lx  y               x  ry
 *        / \             / \
 *      ly  ry          lx  ly
 *    ② 右旋转示意图：对节点x进行右旋转
 *         p                   p
 *        /                   /
 *       x                   y
 *      / \      ------>    / \
 *     y  rx              ly  x
 *    / \                    / \
 *   ly ry                 ry  rx
 * <p>
 * 2. RBTree的查找操作
 * RBTree的查找操作和BST查找操作是一样的，请参考BST的查找操作代码。
 * <p>
 * 3. RBTree的插入操作
 * RBTree的插入操作和BST的插入操作是一致的，只不过在插入之后，可能会导
 * 致树的不平衡，这时就需要对树进行变色操作和旋转操作，使得它符合RBTree
 * 的定义。
 * <p>
 * 新插入的节点是红色的，如果遇到父节点的颜色是黑色，则完成插入工作。也就
 * 是说只有在父节点为红色节点的时候是需要变色操作的。
 * <p>
 * 当插入的节点的父节点是红色的，变色操作分为一下三种情况：
 * 1. 叔叔节点也变红色。
 * 2. 叔叔节点为空，且祖父节点、父节点和新节点处于一条斜线上。
 * 3. 叔叔节点为空，且祖父节点、父节点和新节点不处于一条斜线上。
 * <p>
 * 插入操作case1
 * case1的操作是将父节点和叔叔节点与祖父节点的颜色呼唤，这样就复合了RBTree
 * 的定义。即维持了高度的平衡，变色后也符合RBTree定义的第三条和第四条。下图中，
 * 操作完成后A节点变成了新的节点，如果A节点的父节点不是黑色的话，则继续做变色
 * 操作。
 *
 * @author zail
 * @date 2020/7/6
 */
public class RBTree<T extends Comparable<T>> {
    
    /**
     * 根节点
     */
    public RBTreeNode<T> mRoot = null;
    
    /**
     * ----------- 对红黑树节点x进行左旋转操作 -------------
     * ---------------------------------------------
     * ｜      p                       p
     * ｜     /                       /
     * ｜    x                       y
     * ｜   / \                     / \
     * ｜  lx  y      ----->       x  ry
     * ｜     / \                 / \
     * ｜    ly ry               lx ly
     * ---------------------------------------------
     * 左旋做三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    public void leftRotate(RBTreeNode<T> x) {
        if (x == null) {
            return;
        }
        
        // 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
        RBTreeNode<T> y = x.getLeft();
        x.setRight(y.getLeft());
        if (y.getLeft() != null) {
            y.getLeft().setParent(x);
        }
        
        // 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            // mRoot是RBTree的根节点
            this.mRoot = y;
        } else {
            if (x == x.getParent().getLeft()) {
                x.getParent().setLeft(y);
            } else {
                x.getParent().setRight(y);
            }
        }
        
        // 3. 将y的左子节点设为x，将x的父节点设为y
        y.setLeft(x);
        x.setParent(y);
    }
    
    /**
     * ----------- 对红黑树节点y进行右旋操作 -------------
     * 右旋示意图：对节点y进行右旋
     * ---------------------------------------------
     * ｜         p                   p
     * ｜        /                   /
     * ｜       y                   x
     * ｜      / \                 / \
     * ｜     x  ry    ----->     lx  y
     * ｜    / \                     / \
     * ｜  lx  rx                  rx  ry
     * ---------------------------------------------
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    public void rightRotate(RBTreeNode<T> y) {
        if (y == null) {
            return;
        }
        // 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
        RBTreeNode<T> x = y.getLeft();
        y.setLeft(x.getRight());
        if (x.getRight() != null) {
            x.getRight().setParent(y);
        }
        // 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
        x.setParent(y.getParent());
        if (y.getParent() == null) {
            this.mRoot = x;
        } else {
            if (y == y.getParent().getLeft()) {
                y.getParent().setLeft(x);
            } else {
                y.getParent().setRight(x);
            }
        }
        //3. 将x的右子节点设为y，将y的父节点设为x
        x.setRight(y);
        y.setParent(x);
    }
    
    /*********************** 向红黑树中插入节点 **********************/
    public void insert(T value) {
        RBTreeNode<T> node = new RBTreeNode<>(value, true);
        insert(node);
    }
    
    /**
     * 1. 将节点插入到红黑树中，这个过程与二叉树的搜索树是一样的。
     * 2. 将插入的节点着色为红色；将插入的节点着色为红色，不会违背"特性5"！
     * 越少地违背一条特性，意味着我们需要处理的情况越少。
     * 3. 通过一系列的旋转和变色操作，使之重新称为一颗符合所有特性的红黑树。
     *
     * @param node
     */
    private void insert(RBTreeNode<T> node) {
        // node的父节点
        RBTreeNode<T> current = null;
        RBTreeNode<T> x = mRoot;
        
        while (x != null) {
            current = x;
            int cmp = node.getValue().compareTo(x.getValue());
            if (cmp < 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        
        // 找到位置，将当前current作为node的父节点
        node.setParent(current);
        
        // 接下来判断node是插在左子节点还是右子节点
        if (current != null) {
            int cmp = node.getValue().compareTo(current.getValue());
            if (cmp < 0) {
                current.setLeft(node);
            } else {
                current.setRight(node);
            }
            node.makeRed(); // 设置插入的节点为红色
            insertFixUp(node);
        } else {
            this.mRoot = node;
        }
    }
    
    /**
     * 调整整插入node节点之后的红黑树，使之符合红黑树的所有特性
     *
     * @param node
     */
    private void insertFixUp(RBTreeNode<T> node) {
        // 定义父节点和祖父节点
        RBTreeNode<T> parent, grandParent;
        // 需要修整的条件：父节点存在，且父节点的颜色是红色
        while (((parent = node.getParent()) != null) && parent.isRed()) {
            // 祖父节点
            grandParent = parent.getParent();
            // 若父节点是祖父节点的左子节点
            if (parent == grandParent.getLeft()) {
                // 获取叔叔节点
                RBTreeNode<T> uncle = grandParent.getRight();
                // case1:叔叔节点是红色
                if (uncle != null && uncle.isRed()) {
                    // 把父亲和叔叔节点涂黑色
                    parent.makeBlack();
                    uncle.makeBlack();
                    // 把祖父节点涂红色
                    grandParent.makeRed();
                    // 将位置放到祖父节点
                    node = grandParent;
                    // 继续往上循环判断
                    continue;
                }
                
                // case2：叔叔节点是黑色，且当前节点是右子节点
                if (node == parent.getRight()) {
                    // 从父亲即诶单处左旋
                    leftRotate(parent);
                    // 将父节点和自己调换一下，为右旋左准备
                    RBTreeNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // case3：叔叔节点是黑色，且当前节点是左子节点
                parent.makeBlack();
                grandParent.makeRed();
                rightRotate(grandParent);
            } else {
                // 若父亲节点是祖父节点的右子节点，与上面的完全相反，本质一样的
                RBTreeNode<T> uncle = grandParent.getLeft();
                // case1:叔叔节点也是红色
                if (uncle != null & uncle.isRed()) {
                    parent.makeBlack();
                    uncle.makeBlack();
                    grandParent.makeRed();
                    node = grandParent;
                    continue;
                }
                
                // case2: 叔叔节点是黑色的，且当前节点是左子节点
                if (node == parent.getLeft()) {
                    rightRotate(parent);
                    RBTreeNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // case3: 叔叔节点是黑色的，且当前节点是右子节点
                parent.makeBlack();
                grandParent.makeRed();
                leftRotate(grandParent);
            }
        }
        // 将根节点设置为黑色
        this.mRoot.makeBlack();
    }
    
    /*********************** 删除红黑树中的节点 **********************/
    public void remove(T value) {
        RBTreeNode<T> node;
        if ((node = search(mRoot, value)) != null) {
            remove(node);
        }
    }
    
    /**
     * 删除节点
     * <p>
     * 删除节点分为如下三种情况
     * 1. 被删除的节点没有子节点，即删除的是叶节点。那么直接删除即可
     * 2. 被删除的节点只有一个子节点，那么直接删除该节点，并用它的唯一的子节点顶替它的位置即可
     * 3. 被删除的节点有两个子节点。那么先找出它的后继节点（左子节点中找最大的，右子节点中找最小的）
     * 然后把后继节点的内容赋值给该节点，再然后删除它的后继节点。
     * 在这里，后继节点相当于一个替身，当将后继节点的内容赋值给被删除节点之后，再将后继节点删除。
     * 这个问题又转化为该怎么删除后继节点的问题。
     * 在被删除节点有两个非空子节点的情况下，它的后继节点不可能是双子节点都为空，后继节点也有
     * 仅有一个子节点、有两个子节点的情况。
     * 若后继节点没有子节点，回归到1
     * 若后继节点有一个子节点，回归到2
     * 若后继节点有两个子节点，回归到3
     *
     * @param node
     */
    private void remove(RBTreeNode<T> node) {
        
        RBTreeNode<T> child = null,
                parent = null;
        
        // 3. 删除节点的左右子节点都不为空
        if (node.getLeft() != null && node.getRight() != null) {
            // 先找到被删除节点的后继节点，用来替代被删除节点的位置
            // 1) 获取后继节点：右节点中最小的
            RBTreeNode<T> replace = node.getRight();
            while (replace.getLeft() != null) {
                replace = replace.getLeft();
            }
            // 2) 处理【后继节点的子节点】和【被删除节点的子节点】之间的关系
            // 要删除的节点不是根节点
            if (node.getParent() != null) {
                if (compareNodeValue(node, node.getParent().getLeft()) == 0) {
                    node.getParent().setLeft(replace);
                } else if (compareNodeValue(node, node.getParent().getRight()) == 0) {
                    node.getParent().setRight(replace);
                }
            } else {
                mRoot = replace;
            }
            
            // 3) 处理【后继节点的子节点】和【被删除节点的子节点】之间的关系
            // 因为后继节点选择的是右节点中最小的（左节点），所以后继节点肯定不存在左子节点，所以只处理后继节点的右节点即可
            child = replace.getRight();
            parent = replace.getParent();
            // 如果后继节点是被删除的节点
            if (compareNodeValue(parent, node) == 0) {
                parent = replace;
            } else {
                if (child != null) {
                    child.setParent(parent);
                }
                parent.setLeft(child);
                replace.setRight(node.getRight());
                node.getRight().setParent(replace);
            }
            replace.setParent(node.getParent());
            replace.setRed(node.getRed());
            replace.setLeft(node.getLeft());
            node.getLeft().setParent(replace);
            // 如果移走的后继节点颜色是黑色，重新修正红黑树
            if (replace.isBlack()) {
                removeFixUp(child, parent);
            }
            
            node = null;
        }
        // 1. 被删除的节点没有子节点，即删除的是叶节点。那么直接删除即可
        // 2. 被删除的节点只有一个子节点，那么直接删除该节点，并用它的唯一的子节点顶替它的位置即可
        else {
            if (node.getLeft() != null) {
                child = node.getLeft();
            } else if (node.getRight() != null) {
                child = node.getRight();
            }
            
            parent = node.getParent();
            
            // 如果任意一个子节点不为空，则直接用该节点顶替node节点
            if (child != null) {
                child.setParent(parent);
            }
            
            // node 节点不是根节点
            if (parent != null) {
                if (compareNodeValue(parent.getLeft(), node) == 0) {
                    parent.setLeft(child);
                } else if (compareNodeValue(parent.getRight(), node) == 0) {
                    parent.setRight(child);
                }
            } else {
                this.mRoot = child;
            }
            
            if (node.isBlack()) {
                removeFixUp(child, parent);
            }
            
            node = null;
        }
        
    }
    
    /**
     * 红黑树删除修正函数
     * <p>
     * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     * 如果当前待删除节点是红色的，它被删除之后对当前树的特性不会造成任何破坏影响。
     * 而如果被删除的节点是黑色的，这就需要进行进一步的调整来保证后续的树结构满足要求。
     * 这里我们只修正删除的节点是黑色的情况：
     * <p>
     * 调整思想：
     * 为了保证删除节点的父节点左右两边黑色节点数一致，需要重点关注父节点没删除的那一边节点是不是黑色。
     * 如果删除后父亲节点另一边比删除的一边黑色多，就要想办法搞到平衡。
     * 1、把父亲节点另一边（即删除节点的兄弟树）其中一个节点弄成红色，也少了一个黑色。
     * 2、或者把另一边多的节点（染成黑色）转过来一个
     * <p>
     * 1）、当前节点是黑色的，且兄弟节点是红色的（那么父节点和兄弟节点的子节点肯定是黑色的）；
     * 2）、当前节点是黑色的，且兄弟节点是黑色的，且兄弟节点的两个子节点均为黑色的；
     * 3）、当前节点是黑色的，且兄弟节点是黑色的，且兄弟节点的左子节点是红色，右子节点时黑色的；
     * 4）、当前节点是黑色的，且兄弟节点是黑色的，且兄弟节点的右子节点是红色，左子节点任意颜色。
     * <p>
     * 以上四种情况中，2，3，4都是（当前节点是黑色的，且兄弟节点是黑色的）的子集。
     * <p>
     * 参数说明：
     *
     * @param node   删除之后代替的节点（后序节点）
     * @param parent 后序节点的父节点
     */
    private void removeFixUp(RBTreeNode<T> node, RBTreeNode<T> parent) {
        RBTreeNode<T> other;
        RBTreeNode<T> root = mRoot;
        while ((node == null || node.isBlack()) && node != root) {
            if (parent.getLeft() == node) {
                other = parent.getRight();
                if (other.isRed()) {
                    //case 1：x的兄弟w是红色的【对应状态1，将其转化为2，3，4】
                    other.makeBlack();
                    parent.makeRed();
                    leftRotate(parent);
                    other = parent.getRight();
                }
                
                if ((other.getLeft() == null || other.getLeft().isBlack())
                        && (other.getRight() == null || other.getRight().isBlack())) {
                    //case 2：x的兄弟w是黑色，且w的两个孩子都是黑色的【对应状态2，利用调整思想1网树的根部做递归】
                    other.makeRed();
                    node = parent;
                    parent = node.getParent();
                } else {
                    if (other.getRight() == null || other.getRight().isBlack()) {
                        //case 3:x的兄弟w是黑色的，并且w的左孩子是红色的，右孩子是黑色的【对应状态3，调整到状态4】
                        other.getLeft().makeBlack();
                        other.makeRed();
                        rightRotate(other);
                        other = parent.getRight();
                    }
                    //case 4:x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色【对应状态4，利用调整思想2做调整】
                    other.setRed(parent.getRed());
                    parent.makeBlack();
                    other.getRight().makeBlack();
                    leftRotate(parent);
                    node = root;
                    break;
                }
            } else {
                other = parent.getLeft();
                if (other.isRed()) {
                    //case 1:x的兄弟w是红色的
                    other.makeBlack();
                    parent.makeRed();
                    rightRotate(parent);
                    other = parent.getLeft();
                }
                
                if ((other.getLeft() == null || other.getLeft().isBlack())
                        && (other.getRight() == null || other.getRight().isBlack())) {
                    //case 2:x兄弟w是黑色，且w的两个孩子也都是黑色的
                    other.makeRed();
                    node = parent;
                    parent = node.getParent();
                } else {
                    if (other.getLeft() == null || other.getLeft().isBlack()) {
                        //case 3:x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        other.getRight().makeBlack();
                        other.makeRed();
                        leftRotate(other);
                        other = parent.getLeft();
                    }
                    //case 4:x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    other.setRed(parent.getRed());
                    parent.makeBlack();
                    other.getLeft().makeBlack();
                    rightRotate(parent);
                    node = root;
                    break;
                }
            }
        }
        if (node != null) {
            node.makeBlack();
        }
    }
    
    /**
     * 根据值搜索
     *
     * @param value
     * @return
     */
    public T search(T value) {
        if (value == null) {
            return null;
        }
        
        RBTreeNode<T> node = search(this.mRoot, value);
        
        return node.getValue();
    }
    
    /**
     * 根据值搜索节点
     *
     * @param mRoot
     * @param value
     * @return
     */
    private RBTreeNode<T> search(RBTreeNode<T> mRoot, T value) {
        if (value == null) {
            return null;
        }
        
        // 如果根节点的值与搜索的值相等，则直接返回
        if (value.compareTo(mRoot.getValue()) == 0) {
            return mRoot;
        } else {
            
            RBTreeNode<T> x = mRoot;
            RBTreeNode<T> result = null;
            while (x != null) {
                // 如果小于x节点，则向下查找左节点
                if (value.compareTo(x.getValue()) < 0) {
                    x = x.getLeft();
                    continue;
                }
                // 如果大于x节点，则向下查找右节点
                else if (value.compareTo(x.getValue()) > 0) {
                    x = x.getRight();
                    continue;
                }
                
                result = x;
                x = null;
            }
            
            return result;
        }
    }
    
    
    /**
     * 比较两个值的大小
     * 如果 > 0，则说明 a > b
     * 如果 < 0，则说明 a < b
     * 如果 = 0，则说明 a = b
     *
     * @param a 比较的第一个值
     * @param b 比较的第二个值
     * @return 比较后的结果
     */
    private int compareNodeValue(RBTreeNode<T> a, RBTreeNode<T> b) {
        return a.getValue().compareTo(b.getValue());
    }
    
}
