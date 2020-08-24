package org.teiba.java.dsa.union;

/**
 * 并查集的rank优化
 *
 * @author zail
 */
public class UnionFindDemo05 {
    
    public static void main(String[] args) {
        test(100_000);
    }
    
    public static void test(int n) {
        UnionFind5 uf = new UnionFind5(n);
        
        long startTime = System.currentTimeMillis();
        
        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.unionElements(a, b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();
        
        // 打印输出对这2n个操作的耗时
        System.out.println("UF5, " + 2 * n + " ops, " + (endTime - startTime) + "ms");
    }
    
    static class UnionFind5 {
        int[] parent;
        int[] rank; // rank[i]表示跟节点为i的树的高度
        int count;
        
        public UnionFind5(int count) {
            this.count = count;
            this.parent = new int[count];
            this.rank = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int p) {
            // 判断p不要越界
            if (p < 0 || p >= count) {
                return -1;
            }
            // 第一版的路径压缩
            // while (p != parent[p]) {
            //     // p的父节点指向p的祖父节点（压缩路径）
            //     parent[p] = parent[parent[p]];
            //     p = parent[p];
            // }
            // 第二版的路径压缩
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }
        
        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        
        void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            
            if (pRoot == qRoot) return;
            
            // 利用减少指向的长度，优化并查集
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            }
            else if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            }
            else { // rank[pRoot] == rank[qRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1;
            }
        }
    }
}
