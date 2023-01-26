package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface BiPredicate< T, U > {

    boolean test( T arg1, U arg2 ) throws Exception;

}
