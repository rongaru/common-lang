package com.rongaru.common.lang.executor;

import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.exceptional.Runnable;
import com.rongaru.common.lang.utility.ExceptionUtility;

public class RunnableExecutor {

    public static void executeOrElseThrow( Runnable runnable ) {
        executeOrElseApply( runnable, ExceptionUtility :: throwRuntimeException );
    }

    public static void executeOrElsePrint( Runnable runnable ) {
        executeOrElseApply( runnable, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static void executeOrElseApply( Runnable runnable, Consumer< Throwable > exceptional ) {
        try { runnable.run( ); } catch ( Throwable exception ) { ExceptionUtility.acceptExceptional( exception, exceptional ); }
    }

}
