package org.teiba.java.dsa.graph;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author zail
 */
public class DenseGraphPathDemo01 {
    
    public static void main(String[] args) {
        int n = 6;
        DenseGraphDemo01.DenseGraph dg = DenseGraphDemo01.create(n, false);
        DenseGraphPath denseGraphPath = new DenseGraphPath(dg, 0);
        System.out.println(denseGraphPath);
        denseGraphPath.showPath(3);
    }
    
    /**
     * 路径查找的类
     */
    static class DenseGraphPath {
        // 图对象
        DenseGraphDemo01.DenseGraph dg;
        // 从s点出发到可到达的顶点所经过的路径
        int s;
        // 保存某个节点是否被访问过
        boolean[] visited;
        // 没访问一个节点记录下从哪个节点过来的，根据这个数组就可以倒推出亮点之间的路径
        int[] from;
        
        public DenseGraphPath(DenseGraphDemo01.DenseGraph dg, int s) {
            assert s >= 0 && s < dg.V();
            
            this.dg = dg;
            this.s = s;
            this.visited = new boolean[dg.V()];
            this.from = new int[dg.V()];
            for (int i = 0; i < dg.V(); i++) {
                this.visited[i] = false;
                this.from[i] = -1;
            }
            
            // 寻路算法
            // 从s开始深度优先遍历，在深度优先遍历的过程中记录某个顶点是来自哪里的访问
            // dfs(s);
            // 从s开始广度优先遍历，在广度优先遍历的过程中记录某个顶点是来自哪里的访问
            bfs(s);
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
                    // 设置from的值，保存v能直接到达的顶点
                    this.from[i] = v;
                    dfs(i);
                }
            }
        }
        
        /**
         * 广度优先遍历
         * 广度优先遍历求出了无权图的最短路径
         *
         * @param v
         */
        private void bfs(int v) {
            assert v >= 0 && v < dg.V();
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(v);
            visited[v] = true;
            
            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                // 接下来把顶点直接能到达的路径全部加入到队列中
                List<Boolean> curNode = dg.get(cur);
                for (int i = 0; i < curNode.size(); i++) {
                    if (curNode.get(i)) {
                        // 如果顶点没有被访问过并且队列中也没有该顶点
                        if (!visited[i]) {
                            queue.offer(i);
                            visited[i] = true;
                            from[i] = cur;
                        }
                    }
                }
            }
        }
        
        /**
         * 判断到w是否有路径
         *
         * @param w
         * @return
         */
        public boolean hasPath(int w) {
            assert w >= 0 && w < dg.V();
            return visited[w];
        }
        
        /**
         * 返回到达w的路径所经过的节点
         *
         * @param w
         * @return
         */
        public List<Integer> path(int w) {
            assert w >= 0 && w < dg.V();
            // 判断是否有该路径
            if (!hasPath(w)) return null;
            
            Stack<Integer> s = new Stack<>();
            int p = w;
            while (p != -1) {
                s.push(p);
                p = from[p];
            }
            
            List<Integer> result = new ArrayList<>();
            while (!s.empty()) {
                result.add(s.pop());
            }
            
            return result;
        }
        
        /**
         * 打印到达w的路径
         *
         * @param w
         */
        public void showPath(int w) {
            List<Integer> path = path(w);
            if (path == null) {
                System.out.println("没有到达" + w + "的路径！");
                return;
            }
            
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i == path.size() - 1) {
                    System.out.println();
                }
                else {
                    System.out.print(" -> ");
                }
            }
        }
        
        @Override
        public String toString() {
            return "DenseGraphPath{" +
                "dg=" + dg +
                ", s=" + s +
                ", visited=" + Arrays.toString(visited) +
                ", from=" + Arrays.toString(from) +
                '}';
        }
    }
    
}
