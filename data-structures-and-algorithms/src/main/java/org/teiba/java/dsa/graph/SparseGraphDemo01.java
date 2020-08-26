package org.teiba.java.dsa.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 稀疏图
 *
 * @author zail
 */
public class SparseGraphDemo01 {
    
    public static void main(String[] args) {
        int n = 100_000;
        SparseGraph sg = create(n, false);
        System.out.println(sg);
        System.out.println("-----------------------");
        for (int i = 0; i < sg.m; i++) {
            System.out.print(i + "的边有：");
            Iterator<Integer> itr = sg.iterator(i);
            while (itr.hasNext()) {
                System.out.print(itr.next() + ", ");
            }
            System.out.println();
        }
    }
    
    public static SparseGraph create(int n, boolean directed) {
        SparseGraph sg = new SparseGraph(n, directed);
        for (int i = 0; i < n; i++) {
            sg.addEdge((int) (Math.random() * n), (int) (Math.random() * n));
        }
        return sg;
    }
    
    static class SparseGraph {
        // 节点数
        int n;
        // 边数
        int m;
        // 有向图还是无向图
        boolean directed;
        // 存储图的数据
        List<LinkedList<Integer>> g;
        
        public SparseGraph(int n, boolean directed) {
            this.n = n;
            this.m = 0;
            this.directed = directed;
            this.g = new ArrayList<>(n);
            
            for (int i = 0; i < n; i++) {
                LinkedList<Integer> list = new LinkedList<>();
                this.g.add(list);
            }
        }
        
        // 返回有多少个定点
        public int V() {
            return n;
        }
        
        // 返回有多少条边
        public int E() {
            return m;
        }
        
        /**
         * v点与w点建立一条边
         *
         * @param v y轴中的v
         * @param w x轴中的w
         */
        public void addEdge(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            
            if (hasEdge(v, w)) return;
            
            this.g.get(v).add(w);
            // 判断v是不是自环边，如果是，则无需w与v连接
            // 如果是无向图
            if (v != w && !directed) {
                this.g.get(w).add(v);
            }
            m++;
        }
        
        /**
         * 判断v与w是否有边
         *
         * @param v y轴中的v
         * @param w x轴中的w
         * @return 布尔值
         */
        public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            
            return this.g.get(v).contains(w);
        }
        
        public Iterator<Integer> iterator(int v) {
            return this.g.get(v).iterator();
        }
        
        @Override
        public String toString() {
            return "SparseGraph{" +
                "n=" + n +
                ", m=" + m +
                ", directed=" + directed +
                ", g=" + g +
                '}';
        }
        
    }
    
}
