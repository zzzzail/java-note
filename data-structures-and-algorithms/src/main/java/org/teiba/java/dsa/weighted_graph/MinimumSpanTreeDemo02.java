package org.teiba.java.dsa.weighted_graph;

import org.teiba.java.dsa.heap.IndexMinHeapDemo02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 */
public class MinimumSpanTreeDemo02 {
    
    public static void main(String[] args) {
        DenseGraphDemo01.DenseGraph dg = DenseGraphDemo01.create(false);
        PrimMST primMST = new PrimMST(dg);
        System.out.println(primMST);
    }
    
    /**
     * Prim 算法
     */
    static class PrimMST {
        // 图对象
        DenseGraphDemo01.DenseGraph denseGraph;
        // 使用最小索引堆作为优先级队列
        IndexMinHeapDemo02.IndexMinHeap<Integer> indexPriorityQueue;
        // （存储和每个节点连接的最短的横切边，配合最小索引堆使用）访问的点所对应的边, 算法辅助数据结构
        Edge[] edgeTo;
        // 切分时要将一个一个顶点切分到另一边去，marked用来标记到另一边的顶点（红色的）
        Boolean[] marked;
        // 求出来的最小生成树，起始就是v-1个边。mst用来存放最小生成树的边
        List<Edge> mst;
        // 最小生成树的权值
        Integer mstWeight;
        
        public PrimMST(DenseGraphDemo01.DenseGraph denseGraph) {
            this.denseGraph = denseGraph;
            this.indexPriorityQueue = new IndexMinHeapDemo02.IndexMinHeap<>(denseGraph.V());
            this.edgeTo = new Edge[denseGraph.V()];
            this.marked = new Boolean[denseGraph.V()];
            for (int i = 0; i < denseGraph.V(); i++) {
                this.marked[i] = false;
                this.edgeTo[i] = null;
            }
            this.mst = new ArrayList<>(denseGraph.V());
            
            // Prim 算法开始
            visit(0);
            while (!indexPriorityQueue.isEmpty()) {
                Integer v = indexPriorityQueue.extractMinIndex();
                // 确认一下这个横切边是存在的
                if (edgeTo[v] != null) {
                    mst.add(edgeTo[v]);
                    visit(v);
                }
            }
            
            // 计算总的权重值
            mstWeight = mst.get(0).weight;
            for (int i = 1; i < mst.size(); i++) {
                this.mstWeight += mst.get(i).weight;
            }
        }
        
        private void visit(Integer v) {
            // 如果顶点被标记为红色，则直接略过
            if (marked[v]) return;
            marked[v] = true; // 标记顶点为红色
            
            // 访问顶点v的所有的邻边
            List<Edge> edges = denseGraph.get(v);
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                if (e != null) {
                    Integer w = e.other(v);
                    // 如果w被标记为红色了，则直接略过（这条边不是横切边）
                    if (!marked[w]) {
                        // 之前有没有找到过和w连接的横切边，如果没有找到过，则直接加入到队列和edgeTo中即可
                        if (edgeTo[w] == null) {
                            indexPriorityQueue.insert(w, e.weight);
                            edgeTo[w] = e;
                        }
                        // 如果之前找到过和w连接的横切边，则判断一下e的权值是否小于存储在edgeTo中的边的权值
                        // 如果e的权值小，则替换最小索引堆和edgeTo中的数据
                        // 这里只考虑e的权值比edgeTo存储的权值小的情况，不再考虑权值更大的横切边了
                        else if (e.weight < edgeTo[w].weight) {
                            indexPriorityQueue.change(w, e.weight);
                            edgeTo[w] = e;
                        }
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
