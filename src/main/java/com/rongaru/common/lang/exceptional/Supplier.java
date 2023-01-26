package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface Supplier< T > {

    T get( ) throws Throwable;

}
