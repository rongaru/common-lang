package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface Predicate< T > {

    boolean test( T arg ) throws Exception;

}
