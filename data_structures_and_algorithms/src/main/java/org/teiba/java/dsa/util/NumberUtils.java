package org.teiba.java.dsa.util;

/**
 * @author zail
 * @date 2020/7/27
 */
public class NumberUtils {
    
    /**
     * 生成随机数
     *
     * @param min 随机数最小值
     * @param max 随机数最大值
     * @return
     */
    public static int genRandom(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
    
}
