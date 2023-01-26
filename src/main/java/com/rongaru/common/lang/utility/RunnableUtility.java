package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Runnable;
import com.rongaru.common.lang.executor.RunnableExecutor;

public class RunnableUtility {

    public static void run( Runnable runnable ) {
        RunnableExecutor.executeOrElseThrow( runnable );
    }

    public static void runOnTrue( boolean condition, Runnable runnable ) {
        RunnableExecutor.executeOrElseThrow( condition ? runnable : ( ) -> { } );
    }

    public static void runOnFalse( boolean condition, Runnable runnable ) {
        RunnableExecutor.executeOrElseThrow( condition ? ( ) -> { } : runnable );
    }

    public static void runOnTrueOrElse( boolean condition, Runnable runnableOnTrue, Runnable runnableOnElse ) {
        RunnableExecutor.executeOrElseThrow( condition ? runnableOnTrue : runnableOnElse );
    }

}
