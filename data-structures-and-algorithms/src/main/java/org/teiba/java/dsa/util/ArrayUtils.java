package org.teiba.java.dsa.util;

/**
 * @author zail
 * @date 2020/7/27
 */
public class ArrayUtils {
    
    /**
     * 生成一个数组
     *
     * @param length 数组的长度
     * @param min    数组中最小值
     * @param max    数组中最大值
     * @return
     */
    public static int[] gen(int length, int min, int max) {
        
        int[] result = new int[length];
        
        for (int i = 0; i < length; i++) {
            int r = NumberUtils.genRandom(min, max);
            result[i] = r;
        }
        
        return result;
    }
    
    public static boolean isEmpty(String[] arr) {
        if (arr == null) {
            return true;
        }
        
        if (arr.length == 0) {
            return true;
        }
        
        return false;
    }
}
