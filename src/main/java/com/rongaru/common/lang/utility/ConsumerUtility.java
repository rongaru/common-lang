package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.executor.ConsumerExecutor;

import java.util.Arrays;

public class ConsumerUtility {

    public static < T > void accept( T arg, Consumer< T > consumer ) {
        ConsumerExecutor.executeOrElseThrow( arg, consumer );
    }

    public static < T > void acceptOnTrue( boolean condition, T arg, Consumer< T > consumer ) {
        ConsumerExecutor.executeOrElseThrow( arg, condition ? consumer : val -> { } );
    }

    public static < T > void acceptOnFalse( boolean condition, T arg, Consumer< T > consumer ) {
        ConsumerExecutor.executeOrElseThrow( arg, condition ? val -> { } : consumer );
    }

    public static < T > void acceptMultipleTimes( T arg, Consumer< T > consumer1, Consumer< T > consumer2 ) {
        Arrays.asList( consumer1, consumer2 ).forEach( consumer -> ConsumerExecutor.executeOrElseThrow( arg, consumer ) );
    }

    public static < T > void acceptMultipleTimes( T arg, Consumer< T > consumer1, Consumer< T > consumer2, Consumer< T > consumer3 ) {
        Arrays.asList( consumer1, consumer2, consumer3 ).forEach( consumer -> ConsumerExecutor.executeOrElseThrow( arg, consumer ) );
    }

    public static < T > void acceptOnTrueOrElse( boolean condition, T arg, Consumer< T > consumerOnTrue, Consumer< T > consumerOnElse ) {
        ConsumerExecutor.executeOrElseThrow( arg, condition ? consumerOnTrue : consumerOnElse );
    }

    public static < T > void acceptMultipleTimes( T arg, Consumer< T > consumer1, Consumer< T > consumer2, Consumer< T > consumer3, Consumer< T > consumer4 ) {
        Arrays.asList( consumer1, consumer2, consumer3, consumer4 ).forEach( consumer -> ConsumerExecutor.executeOrElseThrow( arg, consumer ) );
    }

    public static < T > void acceptMultipleTimes( T arg, Consumer< T > consumer1, Consumer< T > consumer2, Consumer< T > consumer3, Consumer< T > consumer4, Consumer< T > consumer5 ) {
        Arrays.asList( consumer1, consumer2, consumer3, consumer4, consumer5 ).forEach( consumer -> ConsumerExecutor.executeOrElseThrow( arg, consumer ) );
    }

}
