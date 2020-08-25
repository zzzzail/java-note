package org.teiba.java.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 稀疏图
 *
 * @author zail
 */
public class SparseGraphDemo01 {
    
    public static void main(String[] args) {
        SparseGraph sg = new SparseGraph(100, false);
        sg.addEdge(1, 2);
        sg.addEdge(2, 3);
        sg.addEdge(3, 4);
        System.out.println(sg);
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
            // 如果是无向图
            if (!directed) {
                this.g.get(w).add(v);
            }
        }
        
        /**
         * 判断v与w是否有边
         *
         * @param v y轴中的v
         * @param w x轴中的w
         * @return 布尔值
         */
        public boolean hasEdge(int v, int w) {
            return this.g.get(v).contains(w);
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
