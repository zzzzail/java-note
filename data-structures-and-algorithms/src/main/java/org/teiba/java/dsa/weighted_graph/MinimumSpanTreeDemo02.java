package org.teiba.java.dsa.weighted_graph;

import org.teiba.java.dsa.heap.IndexMinHeap;
import org.teiba.java.dsa.heap.MinHeap;

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
        IndexMinHeap<Integer> indexPriorityQueue;
        // 访问的点所对应的边, 算法辅助数据结构
        Edge[] edgeTo;
        // 切分时要将一个一个顶点切分到另一边去，marked用来标记到另一边的顶点（红色的）
        Boolean[] marked;
        // 求出来的最小生成树，起始就是v-1个边。mst用来存放最小生成树的边
        List<Edge> mst;
        // 最小生成树的权值
        Integer mstWeight;
        
        public PrimMST(DenseGraphDemo01.DenseGraph denseGraph) {
            this.denseGraph = denseGraph;
            this.indexPriorityQueue = new IndexMinHeap<>(denseGraph.V());
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
                int v = indexPriorityQueue.extractMinIndex();
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
            if (!marked[v]) return;
            marked[v] = true;
            
            List<Edge> edges = denseGraph.get(v);
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                if (e != null) {
                    Integer w = e.to;
                    if (!marked[w]) {
                        if (edgeTo[w] != null) {
                            indexPriorityQueue.insert(w, e.weight);
                            edgeTo[w] = e;
                        }
                        // 不再考虑以前的权值更大的横切边了
                        else if (e.weight < edgeTo[w].weight) {
                            edgeTo[w] = e;
                            indexPriorityQueue.change(w, e.weight);
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
