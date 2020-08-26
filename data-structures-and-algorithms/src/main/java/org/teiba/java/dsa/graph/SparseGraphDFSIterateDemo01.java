package org.teiba.java.dsa.graph;

import java.util.Iterator;

/**
 * @author zail
 */
public class SparseGraphDFSIterateDemo01 {
    
    public static void main(String[] args) {
        int n = 1_000;
        SparseGraphDemo01.SparseGraph sg = SparseGraphDemo01.create(n, false);
        System.out.println(sg);
        
        for (int i = 0; i < n; i++) {
            System.out.print("以" + i + "为顶点的边有：");
            Iterator<Integer> itr = sg.iterator(i);
            while (itr.hasNext()) {
                System.out.print(itr.next() + ", ");
            }
            System.out.println();
        }
    }
    
}
