package org.teiba.java.dsa.weighted_graph;

/**
 * 图中的边
 *
 * @author zail
 */
public class Edge implements Comparable<Edge> {
    
    // 根顶点
    Integer from;
    
    // 连接的顶点
    Integer to;
    
    // 权重值
    Integer weight;
    
    /**
     * 静态创建对象方法
     */
    public static Edge of(Integer from, Integer to, Integer weight) {
        return new Edge(from, to, weight);
    }
    
    public Edge() {
    }
    
    public Edge(Integer from, Integer to, Integer weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    /**
     * 有时候我们只知道这个边中的一个顶点，不知道另外有一个顶点是谁。
     * other帮助我们找到另外一个顶点是谁
     *
     * @param x x作为一个未知的顶点
     * @return 返回找到的另外一个顶点
     */
    public Integer other(Integer x) {
        assert x != null;
        assert x.equals(from) || x.equals(to);
        
        return x.equals(to) ? from : to;
    }
    
    public Integer getTo() {
        return to;
    }
    
    @Override
    public String toString() {
        return from + "-" + to + ":" + weight;
    }
    
    /**
     * 比较方法
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Edge o) {
        // this.weight > o.weight 返回 +1
        // this.weight < o.weight 返回 -1
        // this.weight == o.weight 返回 0
        return weight.compareTo(o.weight);
    }
    
}
