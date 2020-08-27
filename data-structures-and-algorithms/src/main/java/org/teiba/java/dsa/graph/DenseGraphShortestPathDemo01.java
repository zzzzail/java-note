package org.teiba.java.dsa.graph;

import java.util.*;

/**
 * 稠密图的最短路径
 *
 * @author zail
 */
public class DenseGraphShortestPathDemo01 {
    
    public static void main(String[] args) {
        int n = 6;
        DenseGraphDemo01.DenseGraph dg = DenseGraphDemo01.create(n, false);
        DenseGraphShortestPath path = new DenseGraphShortestPath(dg, 0);
        System.out.println(path);
        path.showPath(3);
    }
    
    static class DenseGraphShortestPath {
        // 存储图数据
        DenseGraphDemo01.DenseGraph dg;
        // 起始位置
        int s;
        // 保存每个顶点是否被访问过
        boolean[] visited;
        // 从哪个顶点能直达到该下标的顶点
        int[] from;
        // 记录从s到每个节点具体的最短距离是多少
        int[] order;
        
        public DenseGraphShortestPath(DenseGraphDemo01.DenseGraph dg, int s) {
            this.dg = dg;
            this.s = s;
            this.visited = new boolean[dg.V()];
            this.from = new int[dg.V()];
            this.order = new int[dg.V()];
            for (int i = 0; i < dg.V(); i++) {
                this.visited[i] = false;
                this.from[i] = -1;
                this.order[i] = -1;
            }
            
            // bfs 开始
            bfs(s);
        }
        
        /**
         * 利用广度优先算法，计算无向图中的最短路径
         *
         * @param w
         */
        public void bfs(int w) {
            assert w >= 0 && w < dg.V();
            // 申请一个队列，用来存放临时数据
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(w);
            visited[w] = true;
            order[w] = 0;
            
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                List<Boolean> curList = dg.get(cur);
                for (int i = 0; i < curList.size(); i++) {
                    if (curList.get(i)) {
                        // 如果顶点已经被问了或队列中有了该顶点，则忽略
                        if (!visited[i]) {
                            queue.offer(i);
                            visited[i] = true;
                            from[i] = cur;
                            // 步长：它从哪里过来的，步长加1即可
                            order[i] = order[cur] + 1;
                        }
                    }
                }
            }
        }
        
        /**
         * 判断从s出发到w是否有路径
         *
         * @param w w终点🏁
         * @return 是否存在路径
         */
        public boolean hasPath(int w) {
            assert w >= 0 && w < dg.V();
            return visited[w];
        }
        
        /**
         * 从s出发到w的路径
         *
         * @param w
         * @return
         */
        public List<Integer> path(int w) {
            assert w >= 0 && w < dg.V();
            if (!hasPath(w)) return null;
            
            Stack<Integer> stack = new Stack<>();
            int p = w;
            while (p != -1) {
                stack.push(p);
                p = from[p];
            }
            List<Integer> result = new ArrayList<>();
            while (!stack.empty()) {
                result.add(stack.pop());
            }
            return result;
        }
        
        public void showPath(int w) {
            assert w >= 0 && w < dg.V();
            List<Integer> path = path(w);
            if (path == null) {
                System.out.println(s + "到" + w + "没有能走通的路径！");
                return;
            }
            
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    System.out.print(i);
                }
                else {
                    System.out.print(path.get(i) + " -> ");
                }
            }
            System.out.println();
        }
        
        /**
         * 查询从s到w最短路径的长度是多少
         *
         * @param w
         * @return
         */
        public int length(int w) {
            assert w >= 0 && w < dg.V();
            return order[w];
        }
    
        @Override
        public String toString() {
            return "DenseGraphShortestPath{" +
                "dg=" + dg +
                ", s=" + s +
                ", visited=" + Arrays.toString(visited) +
                ", from=" + Arrays.toString(from) +
                ", order=" + Arrays.toString(order) +
                '}';
        }
    }
}
