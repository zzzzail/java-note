package com.fsocity.learn.java.lambda;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author zail
 * @since 2018-06-08
 */
public class LambdaPerformanceTest {
    
    private Integer max = 1000000;
    
    private List<String> values = new ArrayList<>(max);
    
    @Before
    public void setup() {
        UUID uuid = UUID.randomUUID();
        for (int i = 0; i < max; i++) {
            values.add(uuid.toString());
        }
    }
    
    // 顺序排序时间
    @Test
    public void testLambdaPerformance() {
        long start = new Date().getTime();
        
        long count = values
            // .stream()
            .parallelStream()
            .sorted()
            .count();
        
        long end = new Date().getTime();
        System.out.printf("sequential sort took: %d ms", end - start);
        System.out.println();
        System.out.printf("count = %d", count);
    }
    
    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        
        // map.forEach((id, val) -> System.out.println(val));
    
        // map.computeIfPresent(3, (num, val) -> val + num);
        // System.out.println(map.get(3));
        
        // map.computeIfPresent(9, (num, val) -> null);
        // System.out.println(map.containsKey(9));
        
        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23));
        
        // map.computeIfAbsent(3, val -> "bam");
        // System.out.println(map.get(3));
    
        System.out.println(map);
        
    }
    
    @Test
    public void testStream() {
        Stream.of("a1", "a2", "a3")
            .findFirst()
            .ifPresent(System.out::println);
    }
}
