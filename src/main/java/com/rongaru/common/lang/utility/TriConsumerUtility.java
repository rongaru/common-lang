package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.TriConsumer;
import com.rongaru.common.lang.executor.TriConsumerExecutor;

import java.util.Arrays;

public class TriConsumerUtility {

    public static < T, U, V > void accept( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer ) {
        TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, consumer );
    }

    public static < T, U, V > void acceptOnTrue( boolean condition, T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer ) {
        TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, condition ? consumer : ( val1, val2, val3 ) -> { } );
    }

    public static < T, U, V > void acceptOnFalse( boolean condition, T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer ) {
        TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, condition ? ( val1, val2, val3 ) -> { } : consumer );
    }

    public static < T, U, V > void acceptMultipleTimes( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2 ) {
        Arrays.asList( consumer1, consumer2 ).forEach( consumer -> TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, consumer ) );
    }

    public static < T, U, V > void acceptOnTrueOrElse( boolean condition, T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumerOnTrue, TriConsumer< T, U, V > consumerOnFalse ) {
        TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, condition ? consumerOnTrue : consumerOnFalse );
    }

    public static < T, U, V > void acceptMultipleTimes( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2, TriConsumer< T, U, V > consumer3 ) {
        Arrays.asList( consumer1, consumer2, consumer3 ).forEach( consumer -> TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, consumer ) );
    }

    public static < T, U, V > void acceptMultipleTimes( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2, TriConsumer< T, U, V > consumer3, TriConsumer< T, U, V > consumer4 ) {
        Arrays.asList( consumer1, consumer2, consumer3, consumer4 ).forEach( consumer -> TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, consumer ) );
    }

    public static < T, U, V > void acceptMultipleTimes( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer1, TriConsumer< T, U, V > consumer2, TriConsumer< T, U, V > consumer3, TriConsumer< T, U, V > consumer4, TriConsumer< T, U, V > consumer5 ) {
        Arrays.asList( consumer1, consumer2, consumer3, consumer4, consumer5 ).forEach( consumer -> TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, consumer ) );
    }

}
