package org.teiba.java.dsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图
 * 使用邻接矩阵的方式存储稠密图
 *
 * @author zail
 */
public class DenseGraphDemo01 {
    
    static class DenseGraph {
        // 节点数
        int n;
        // 边数
        int m;
        // 有向图还是无向图
        boolean directed;
        // 存储图中的数据
        List<List<Boolean>> g;
        
        public DenseGraph(int n, boolean directed) {
            this.n = n;
            this.m = 0;
            this.directed = directed;
            this.g = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                List<Boolean> list = new ArrayList<>(n);
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
            
            if (hasEdge(v, w))
                return;
            
            // g[v][w] = true
            g.get(v).set(w, true);
            // 判断是否为有向图。如果不是无向图，则g[w][v]也要设置为true
            if (!directed) {
                g.get(w).set(v, true);
            }
            
            m++;
        }
        
        public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            
            return g.get(v).get(w);
        }
    }
    
}
