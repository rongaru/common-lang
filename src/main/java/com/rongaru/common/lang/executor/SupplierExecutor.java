package com.rongaru.common.lang.executor;

import com.rongaru.common.lang.exceptional.Function;
import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.utility.ExceptionUtility;

public class SupplierExecutor {

    public static < T > T executeOrElseThrow( Supplier< T > supplier ) {
        return executeOrElseApply( supplier, ExceptionUtility :: throwRuntimeException );
    }

    public static < T > T executeOrElsePrintAndGetNull( Supplier< T > supplier ) {
        return executeOrElseApply( supplier, ExceptionUtility :: printStackTraceAndGetNull );
    }

    public static < T > T executeOrElsePrintAndGetDefault( Supplier< T > supplier, T value ) {
        return executeOrElseApply( supplier, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T > T executeOrElsePrintAndGetDefault( Supplier< T > supplier, Supplier< T > exceptional ) {
        return executeOrElseApply( supplier, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, exceptional ) );
    }

    public static < T > T executeOrElseApply( Supplier< T > supplier, Function< Throwable, T > exceptional ) {
        try { return supplier.get( ); } catch ( Throwable exception ) { return ExceptionUtility.applyExceptional( exception, exceptional ); }
    }

}
