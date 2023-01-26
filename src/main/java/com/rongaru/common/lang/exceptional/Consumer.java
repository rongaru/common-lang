package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface Consumer< T > {

    void accept( T arg ) throws Throwable;

}
