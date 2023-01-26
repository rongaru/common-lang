package com.rongaru.common.lang.executor;

import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.utility.ExceptionUtility;

public class ConsumerExecutor {

    public static < T > void executeOrElseThrow( T arg, Consumer< T > consumer ) {
        executeOrElseApply( arg, consumer, ExceptionUtility :: throwRuntimeException );
    }

    public static < T > void executeOrElsePrint( T arg, Consumer< T > consumer ) {
        executeOrElseApply( arg, consumer, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T > void executeOrElseApply( T arg, Consumer< T > consumer, Consumer< Throwable > exceptional ) {
        try { consumer.accept( arg ); } catch ( Throwable exception ) { ExceptionUtility.acceptExceptional( exception, exceptional ); }
    }

}
