package com.rongaru.common.lang.exceptional;

@FunctionalInterface
public interface BiConsumer< T, U > {

    void accept( T arg1, U arg2 ) throws Throwable;

}
