package org.teiba.java.dsa.weighted_graph;

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
        int n = 10;
        SparseGraph sg = create(n, false);
        System.out.println(sg);
    }
    
    public static SparseGraph create(int n, boolean directed) {
        SparseGraph sg = new SparseGraph(n, directed);
        for (int i = 0; i < 2 * n; i++) {
            sg.addEdge((int) (Math.random() * n), (int) (Math.random() * n), (int) (Math.random() * 10));
        }
        return sg;
    }
    
    static class SparseGraph {
        // 节点数
        Integer n;
        // 边数
        Integer m;
        // 有向图还是无向图
        Boolean directed;
        // 存储图的数据
        List<LinkedList<Edge>> g;
        
        public SparseGraph(Integer n, Boolean directed) {
            this.n = n;
            this.m = 0;
            this.directed = directed;
            this.g = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                LinkedList<Edge> list = new LinkedList<>();
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
         * @param from y轴中的v
         * @param to   x轴中的w
         */
        public void addEdge(Integer from, Integer to, Integer weight) {
            assert from >= 0 && from < n;
            assert to >= 0 && to < n;
            assert weight >= 0;
            // 如果存在边
            if (hasEdge(from, to)) return;
            
            Edge newEdge = Edge.of(from, to, weight);
            this.g.get(from).add(newEdge);
            // 判断from是不是自环边，如果是，则无需to与from连接
            // 如果是无向图
            if (!from.equals(to) && !directed) {
                newEdge = Edge.of(to, from, weight);
                this.g.get(to).add(newEdge);
            }
            m++;
        }
        
        /**
         * 判断v与w是否有边
         *
         * @param from y轴中的v
         * @param to   x轴中的w
         * @return 布尔值
         */
        public boolean hasEdge(Integer from, Integer to) {
            assert from >= 0 && from < n;
            assert to >= 0 && to < n;
            
            LinkedList<Edge> edges = this.g.get(from);
            if (edges.size() == 0)
                return false;
            for (Edge edge : edges)
                if (edge.to.equals(to))
                    return true;
            
            return false;
        }
        
        public LinkedList<Edge> get(int v) {
            return g.get(v);
        }
        
        public Iterator<Edge> iterator(int v) {
            return this.g.get(v).iterator();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");
            for (LinkedList<Edge> edges : g) {
                sb.append("\t")
                    .append(edges.toString())
                    .append("\n");
            }
            sb.append("]");
            return sb.toString();
        }
        
    }
    
}
