package com.rongaru.common.lang.executor;

import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.exceptional.TriConsumer;
import com.rongaru.common.lang.utility.ExceptionUtility;

public class TriConsumerExecutor {

    public static < T, U, V > void executeOrElseThrow( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer ) {
        executeOrElseApply( arg1, arg2, arg3, consumer, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U, V > void executeOrElsePrint( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer ) {
        executeOrElseApply( arg1, arg2, arg3, consumer, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T, U, V > void executeOrElseApply( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer, Consumer< Throwable > exceptional ) {
        try { consumer.accept( arg1, arg2, arg3 ); } catch ( Throwable exception ) { ExceptionUtility.acceptExceptional( exception, exceptional ); }
    }

}
