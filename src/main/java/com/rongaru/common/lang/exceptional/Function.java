package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface Function< T, R > {

    R apply( T arg ) throws Throwable;

}
