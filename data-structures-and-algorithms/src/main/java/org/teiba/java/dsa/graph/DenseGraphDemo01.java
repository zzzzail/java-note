package org.teiba.java.dsa.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图
 * 使用邻接矩阵的方式存储稠密图
 *
 * 更多无权图的算法
 * 1、flood fill：例如ps中的魔棒，选择一块类似的区域，背后的实现就是利用图
 * 周边顶点的相似性，进行划分区域，一块是选中的区域、另一块是未选中的区域。让两
 * 片区域形成不同的连通分量。Tolerance容忍度，利用这个配置可以调整周边顶点的相
 * 似性。
 * 扫雷游戏，也是通过flood fill实现的。从某个点向外探索，如果周围的8个区域中没
 * 有雷，则展开这片区域，如果周围的点有雷了，则停止。这也是通过点击向外探索一块联
 * 通分量。
 * 2、走迷宫、迷宫生成
 * 可以随机化的生成迷宫，迷宫本质上就是一棵树，可以把这棵树的跟节点作为入口，而迷
 * 宫的出口就是其中叶子节点之一。迷宫的生成，其本质就是生成树的过程。
 * 首先建立一张固定大小的图，图中的节点是成顺序排列，并且排列成一个长方形。把其中
 * 的某些块（顶点）取消，就可以形成一个一个的可以通过的路。原来没有取消的则作为墙。
 * 3、更多的图算法
 * 欧拉路径、哈密尔顿路径、BluePath游戏、二分图（多对多）、
 * 地图填色问题（在地图中有不同的国家和城市相互接壤，最少使用多少种颜色来为这些国家
 * 着色，才能使得这些国家的颜色是不重复的。我们可以把每一个国家当作一个节点，国家与
 * 国家的边境相邻就设置成一条边。我们怎么给每一个节点进行图色使得每个节点和它相邻的
 * 节点颜色是不重复的。）
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
