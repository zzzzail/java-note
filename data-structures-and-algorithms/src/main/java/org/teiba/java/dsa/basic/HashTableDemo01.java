package org.teiba.java.dsa.basic;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author zail
 */
public class HashTableDemo01 {
    
    public static void main(String[] args) {
        
        Map<String, Object> map = new Hashtable<>(20, 0.8F);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        System.out.println(map);
        
    }
    
}
