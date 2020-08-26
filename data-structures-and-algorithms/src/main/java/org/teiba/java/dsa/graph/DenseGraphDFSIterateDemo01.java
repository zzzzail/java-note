package org.teiba.java.dsa.graph;

/**
 * 稠密图的深度优先遍历
 *
 * @author zail
 */
public class DenseGraphDFSIterateDemo01 {
    
    public static void main(String[] args) {
        int n = 10;
        DenseGraphDemo01.DenseGraph dg = DenseGraphDemo01.create(n, false);
        System.out.println(dg);
        
        for (int i = 0; i < dg.V(); i++) {
            System.out.print("以" + i + "为顶点的边有：");
            for (int j = 0; j < dg.V(); j++) {
                if (dg.get(i, j))
                    System.out.print(j + ", ");
            }
            System.out.println();
        }
    }
    
}
