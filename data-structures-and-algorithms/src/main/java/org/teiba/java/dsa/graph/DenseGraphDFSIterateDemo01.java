package org.teiba.java.dsa.graph;

import java.util.Arrays;
import java.util.List;

/**
 * 稠密图的深度优先遍历
 * 求出图的联通分量
 *
 * @author zail
 */
public class DenseGraphDFSIterateDemo01 {
    
    public static void main(String[] args) {
        int n = 6;
        DenseGraphDemo01.DenseGraph dg = DenseGraphDemo01.create(n, false);
        Component component1 = new Component(dg);
        component1.calculateComponent();
        System.out.println(component1);
        
        n = 10;
        dg = DenseGraphDemo01.create(n, false);
        Component component2 = new Component(dg);
        component2.calculateComponent();
        System.out.println(component2);
    }
    
    static class Component {
        // 图对象
        DenseGraphDemo01.DenseGraph dg;
        // 保存某个节点是否被访问过
        boolean[] visited;
        // 记录有多少个联通分量
        int componentCount;
        
        public Component(DenseGraphDemo01.DenseGraph dg) {
            this.dg = dg;
            // 初始化visited，默认任何一个节点都没有被访问过
            this.visited = new boolean[dg.V()];
            for (int i = 0; i < dg.V(); i++) {
                this.visited[i] = false;
            }
            this.componentCount = 0;
        }
        
        public void calculateComponent() {
            for (int i = 0; i < dg.V(); i++) {
                // 如果该节点没有被访问过
                if (!visited[i]) {
                    // 进行一个深度优先遍历
                    dfs(i);
                    this.componentCount++;
                }
            }
        }
        
        /**
         * 深度优先遍历
         *
         * @param v
         */
        private void dfs(int v) {
            visited[v] = true;
            List<Boolean> list = dg.get(v);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) && !visited[i]) {
                    dfs(i);
                }
            }
        }
        
        public int count() {
            return this.componentCount;
        }
        
        @Override
        public String toString() {
            return "Component{" +
                "dg=" + dg +
                ", visited=" + Arrays.toString(visited) +
                ", componentCount=" + componentCount +
                '}';
        }
    }
    
}
