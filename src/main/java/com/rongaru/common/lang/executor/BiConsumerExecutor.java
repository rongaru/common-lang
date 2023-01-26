package com.rongaru.common.lang.executor;

import com.rongaru.common.lang.exceptional.BiConsumer;
import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.utility.ExceptionUtility;

public class BiConsumerExecutor {

    public static < T, U > void executeOrElseThrow( T arg1, U arg2, BiConsumer< T, U > consumer ) {
        executeOrElseApply( arg1, arg2, consumer, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U > void executeOrElsePrint( T arg1, U arg2, BiConsumer< T, U > consumer ) {
        executeOrElseApply( arg1, arg2, consumer, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T, U > void executeOrElseApply( T arg1, U arg2, BiConsumer< T, U > consumer, Consumer< Throwable > handler ) {
        try { consumer.accept( arg1, arg2 ); } catch ( Throwable exception ) { ExceptionUtility.acceptExceptional( exception, handler ); }
    }

}
