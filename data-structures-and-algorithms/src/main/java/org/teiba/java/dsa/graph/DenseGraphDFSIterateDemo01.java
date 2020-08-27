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
        System.out.println(component1.isConnected(1, 2));
        
        n = 10;
        dg = DenseGraphDemo01.create(n, false);
        Component component2 = new Component(dg);
        component2.calculateComponent();
        System.out.println(component2);
        System.out.println(component2.isConnected(1, 2));
    }
    
    static class Component {
        // 图对象
        DenseGraphDemo01.DenseGraph dg;
        // 保存某个节点是否被访问过
        boolean[] visited;
        // 记录有多少个联通分量
        int componentCount;
        // 记录图中哪些节点是相连的。初始值为-1，大于-1的值中每一个值与它相等的值是相连的。
        // 例如[0, 1, 0, 2]
        // 其中有三块联通分量；第0个元素和第2个元素在一个区域内是相连的；
        // 第1个顶点自成一块区域；第3个顶点自成一块区域；
        int[] componentIds;
        
        public Component(DenseGraphDemo01.DenseGraph dg) {
            this.dg = dg;
            // 初始化visited，默认任何一个节点都没有被访问过
            this.visited = new boolean[dg.V()];
            // 初始化连通分量id列表
            this.componentIds = new int[dg.V()];
            for (int i = 0; i < dg.V(); i++) {
                this.visited[i] = false;
                this.componentIds[i] = -1;
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
            // 把所有联通着的节点的值设置为componentCount的值，由此就可以判断哪两个节点是连通的了。
            componentIds[v] = componentCount;
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
        
        /**
         * 判断v节点和w节点是否相连
         *
         * @param v v节点下标
         * @param w w节点下标
         * @return
         */
        public boolean isConnected(int v, int w) {
            // 检查下标是否越界
            assert v >= 0 && v < dg.V() : "下标越界了！";
            assert w >= 0 && w < dg.V() : "下标越界了！";
            
            return componentIds[v] == componentIds[w];
        }
        
        @Override
        public String toString() {
            return "Component{" +
                "dg=" + dg +
                ", visited=" + Arrays.toString(visited) +
                ", componentCount=" + componentCount +
                ", componentIds=" + Arrays.toString(componentIds) +
                '}';
        }
    }
    
}
