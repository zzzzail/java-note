package org.teiba.java.dsa.weighted_graph;

import java.util.ArrayList;
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
        for (int i = 0; i < 2 * n; i++) {
            dg.addEdge((int) (Math.random() * n), (int) (Math.random() * n), (int) (Math.random() * 10));
        }
        return dg;
    }
    
    public static DenseGraph create(boolean directed) {
        DenseGraphDemo01.DenseGraph dg = new DenseGraphDemo01.DenseGraph(8, directed);
        dg.addEdge(4, 5, 35);
        dg.addEdge(4, 7, 37);
        dg.addEdge(5, 7, 28);
        dg.addEdge(0, 7, 16);
        dg.addEdge(1, 5, 32);
        dg.addEdge(0, 4, 38);
        dg.addEdge(2, 3, 17);
        dg.addEdge(1, 7, 19);
        dg.addEdge(0, 2, 26);
        dg.addEdge(1, 2, 36);
        dg.addEdge(1, 3, 29);
        dg.addEdge(2, 7, 34);
        dg.addEdge(6, 2, 40);
        dg.addEdge(3, 6, 52);
        dg.addEdge(6, 0, 58);
        dg.addEdge(6, 4, 93);
        return dg;
    }
    
    static class DenseGraph {
        // 节点数
        Integer n;
        // 边数
        Integer m;
        // 有向图还是无向图
        Boolean directed;
        // 存储图中的数据
        List<List<Edge>> g;
        
        public DenseGraph(Integer n, Boolean directed) {
            this.n = n;
            this.m = 0;
            this.directed = directed;
            this.g = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                List<Edge> list = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    // 初始化为null
                    list.add(null);
                }
                this.g.add(list);
            }
        }
        
        // 返回有多少个顶点
        public Integer V() {
            return n;
        }
        
        // 返回有多少条边
        public Integer E() {
            return m;
        }
        
        /**
         * v点与w点建立一条边
         *
         * @param from y轴中的v
         * @param to   x轴中的w
         */
        public void addEdge(Integer from, Integer to, Integer weight) {
            assert from >= 0 && from < n;
            assert to >= 0 && to < n;
            assert weight >= 0;
            // if (hasEdge(from, to)) return;
            // 如果有边，则覆盖
            if (hasEdge(from, to)) m--;
            
            Edge newEdge = Edge.of(from, to, weight);
            // g[from][to] = true
            g.get(from).set(to, newEdge);
            // 判断是否为有向图。如果不是无向图，则g[from][to]也要设置为true
            if (!directed) {
                newEdge = Edge.of(to, from, weight);
                g.get(to).set(from, newEdge);
            }
            m++;
        }
        
        /**
         * 判断两个顶点是否有边
         *
         * @param from 从此顶点出发
         * @param to   到此顶点
         * @return 是否有边
         */
        public boolean hasEdge(Integer from, Integer to) {
            assert from >= 0 && from < n;
            assert to >= 0 && to < n;
            
            return g.get(from).get(to) != null;
        }
        
        public List<Edge> get(Integer from) {
            assert from >= 0 && from < n;
            
            return g.get(from);
        }
        
        public Edge get(Integer from, Integer to) {
            assert from >= 0 && from < n;
            assert to >= 0 && to < n;
            
            return g.get(from).get(to);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");
            for (int i = 0; i < g.size(); i++) {
                List<Edge> edges = g.get(i);
                sb.append("\t")
                    .append(edges.toString())
                    .append("\n");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
}
