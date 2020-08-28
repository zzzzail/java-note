package org.teiba.java.dsa.weighted_graph;

import org.teiba.java.dsa.heap.MinHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小生成树
 *
 * @author zail
 */
public class MinimumSpanTreeDemo01 {
    
    public static void main(String[] args) {
        DenseGraphDemo01.DenseGraph dg = new DenseGraphDemo01.DenseGraph(8, false);
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
        
        // 最小生成树
        LazyPrimMST mst = new LazyPrimMST(dg);
        System.out.println(mst);
    }
    
    /**
     * 人生中的第一个最小生成树算法
     * Lazy Prim，Prim是一个人名
     */
    static class LazyPrimMST {
        // 图对象
        DenseGraphDemo01.DenseGraph dg;
        // 把最小堆作为优先队列
        MinHeap<Edge> pq;
        // 切分时要将一个一个顶点切分到另一边去，marked用来标记到另一边的顶点（红色的）
        Boolean[] marked;
        // 求出来的最小生成树，起始就是v-1个边。mst用来存放最小生成树的边
        List<Edge> mst;
        // 最小生成树的权值
        Integer mstWeight;
        
        public LazyPrimMST(DenseGraphDemo01.DenseGraph dg) {
            this.dg = dg;
            this.pq = new MinHeap<>(dg.E());
            this.marked = new Boolean[dg.V()];
            for (int i = 0; i < dg.V(); i++) {
                this.marked[i] = false;
            }
            this.mst = new ArrayList<>(dg.V());
            
            /**
             * Lazy Prim 算法
             * 在Lazy Prim算法中，我们要一个一个的把所有顶点从蓝色的节点转化成红色的节点。
             * 每一次转化都要遍历新进到红色的顶点的所有边，把相应的新的横切边加入到最小堆中，
             * 设计一个初始函数 visit
             */
            visit(0);
            while (!pq.isEmpty()) {
                // 取出最小的边
                Edge edge = pq.extractMin();
                // 我们取出来的边有可能不是横切边（意思就是两个断点切分到了同一侧，两个颜色相等）
                if (marked[edge.from] == marked[edge.to])
                    continue;
                // 切出来的就是最小生成树的边
                mst.add(edge);
                // 此时有一个端点是红色，有点一个端点是蓝色
                if (!marked[edge.from])
                    visit(edge.from);
                else
                    visit(edge.to);
            }
            
            // 计算最小生成树的权值
            this.mstWeight = mst.get(0).weight;
            for (int i = 1; i < mst.size(); i++)
                this.mstWeight += this.mst.get(i).weight;
        }
        
        private void visit(Integer v) {
            assert v >= 0 && v < dg.V();
            
            // 顶点没有被标记为红色的顶点
            if (marked[v]) return;
            marked[v] = true;
            
            // 遍历新转成红色的节点所有的邻边
            List<Edge> edges = dg.get(v);
            for (Edge edge : edges) {
                if (edge != null) {
                    // 如果邻边所对应的节点没有被访问过（没有被标记为红色）
                    if (!marked[edge.to]) {
                        // 这就说明我们找到了一条横切边，我们就把它加入到优先队列中
                        pq.insert(edge);
                    }
                }
            }
        }
        
        /**
         * 返回最小生成树
         *
         * @return
         */
        public List<Edge> mstEdges() {
            return mst;
        }
        
        /**
         * 返回最小生成树的权值
         *
         * @return
         */
        public Integer weight() {
            return mstWeight;
        }
        
        @Override
        public String toString() {
            return mst.toString() + "\n" + "权重值为：" + mstWeight;
        }
    }
    
}
