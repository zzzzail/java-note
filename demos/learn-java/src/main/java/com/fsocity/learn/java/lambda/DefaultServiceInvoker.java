package com.fsocity.learn.java.lambda;

import java.util.function.Function;

/**
 * @author zail
 * @since 2018-05-29
 */

public class DefaultServiceInvoker<T> implements ServiceInvoker<T> {
    
    private final T service;
    
    public DefaultServiceInvoker(T service) {
        this.service = service;
    }
    
    @Override
    public <R> R invoke(Function<T, R> function) {
        return function.apply(service);
    }
    
}
