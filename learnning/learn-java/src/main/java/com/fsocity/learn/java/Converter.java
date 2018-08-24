package com.fsocity.learn.java;

/**
 * 转换器
 * @author zail
 * @since 2018-06-08
 */
public interface Converter<S, T> {
    
    /**
     * 转换
     * @param srouce
     * @return
     */
    T convert(S srouce);

}
