package com.fsocity.learn.java.lambda;

import java.util.function.Function;

/**
 * @author zail
 * @since 2018-05-29
 */
public interface ServiceInvoker<T> {
    
    /**
     * 执行
     * @param function
     * @param <R>
     * @return
     */
    <R> R invoke(Function<T, R> function);
    
}
