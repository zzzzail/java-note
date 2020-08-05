package org.teiba.java.dsa.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @date 2020/7/12
 */
public class ListRemoveDemo2 {
    
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        
        for (String s : list) {
            if (s.equals("a")) {
                list.remove(s);
            }
        }
        
        System.out.println(list);
    }
    
}
