package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface TriFunction< T, U, V, R > {

    R apply( T arg1, U arg2, V arg3 ) throws Throwable;

}
