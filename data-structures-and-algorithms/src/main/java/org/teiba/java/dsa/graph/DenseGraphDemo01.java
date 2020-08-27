package org.teiba.java.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 稠密图
 * 使用邻接矩阵的方式存储稠密图
 *
 * @author zail
 */
public class DenseGraphDemo01 {
    
    public static void main(String[] args) {
        int n = 10;
        DenseGraph dg = create(n, false);
        System.out.println(dg);
    }
    
    public static DenseGraph create(int n, boolean directed) {
        DenseGraph dg = new DenseGraph(n, directed);
        // 随机填充数据
        for (int i = 0; i < n; i++) {
            dg.addEdge((int) (Math.random() * n), (int) (Math.random() * n));
        }
        return dg;
    }
    
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
                for (int j = 0; j < n; j++) {
                    list.add(false);
                }
                this.g.add(list);
            }
        }
        
        // 返回有多少个顶点
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
        
        public List<Boolean> get(int v) {
            return g.get(v);
        }
        
        public Boolean get(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            
            return g.get(v).get(w);
        }
        
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder("DenseGraph{" +
                "n=" + n +
                ", m=" + m +
                ", directed=" + directed +
                ", g=[\n");
            for (List<Boolean> bls : g) {
                StringBuilder appendStr = new StringBuilder();
                appendStr.append("[");
                for (int i = 0; i < bls.size(); i++) {
                    appendStr.append(bls.get(i) ? "1" : "0");
                    if (i != bls.size() - 1) {
                        appendStr.append(", ");
                    }
                }
                str.append(appendStr.append("]\n").toString());
            }
            str.append("]}");
            return str.toString();
        }
    }
    
}
