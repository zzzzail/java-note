package org.teiba.java.dsa.graph;

import java.util.Arrays;

/**
 * 稀疏图的深度优先遍历
 *
 * @author zail
 */
public class SparseGraphDFSDemo01 {
    
    public static void main(String[] args) {
        int n = 10;
        SparseGraphDemo01.SparseGraph sg = SparseGraphDemo01.create(n, false);
        SparseGraphComponentWrapper component1 = new SparseGraphComponentWrapper(sg);
        component1.calculateComponent();
        System.out.println(component1);
        System.out.println(component1.isConnected(0, 1));
    }
    
    static class SparseGraphComponentWrapper {
        SparseGraphDemo01.SparseGraph sg;
        // 记录某个节点是否被访问过
        boolean[] visited;
        // 记录联通分量有多少个
        int componentCount;
        // 记录各个联通分量中的节点，通过它可以判断两个节点是否相连
        int[] componentIds;
        
        public SparseGraphComponentWrapper(SparseGraphDemo01.SparseGraph sg) {
            this.sg = sg;
            // 初始化visited
            this.visited = new boolean[sg.V()];
            // 初始化联通分量列表
            this.componentIds = new int[sg.V()];
            for (int i = 0; i < sg.V(); i++) {
                this.visited[i] = false;
                this.componentIds[i] = -1;
            }
            this.componentCount = 0;
        }
        
        public void calculateComponent() {
            for (int i = 0; i < sg.V(); i++) {
                if (!visited[i]) {
                    dfs(i);
                    this.componentCount++;
                }
            }
        }
        
        /**
         * 对v进行深度优先遍历
         *
         * @param v
         */
        private void dfs(int v) {
            visited[v] = true;
            componentIds[v] = componentCount;
            
            for (Integer next : sg.get(v)) {
                if (!visited[next]) {
                    dfs(next);
                }
            }
        }
        
        /**
         * 判断顶点v是否与顶点w相连接
         *
         * @param v
         * @param w
         * @return
         */
        public boolean isConnected(int v, int w) {
            return componentIds[v] == componentIds[w];
        }
        
        @Override
        public String toString() {
            return "SparseGraphComponentWrapper{" +
                "sg=" + sg +
                ", visited=" + Arrays.toString(visited) +
                ", componentCount=" + componentCount +
                ", componentIds=" + Arrays.toString(componentIds) +
                '}';
        }
    }
    
}
