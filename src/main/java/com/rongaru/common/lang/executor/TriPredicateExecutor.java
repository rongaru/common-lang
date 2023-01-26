package com.rongaru.common.lang.executor;

import com.rongaru.common.lang.exceptional.Function;
import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.exceptional.TriPredicate;
import com.rongaru.common.lang.utility.ExceptionUtility;

public class TriPredicateExecutor {

    public static < T, U, V > boolean executeOrElseThrow( T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return executeOrElseApply( arg1, arg2, arg3, predicate, ExceptionUtility :: throwRuntimeException );
    }

    public static < T, U, V > boolean executeOrElsePrintAndGetFalse( T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return executeOrElseApply( arg1, arg2, arg3, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, false ) );
    }

    public static < T, U, V > boolean executeOrElsePrintAndGetDefault( T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, boolean value ) {
        return executeOrElseApply( arg1, arg2, arg3, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, value ) );
    }

    public static < T, U, V > boolean executeOrElsePrintAndGetDefault( T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, Supplier< Boolean > supplier ) {
        return executeOrElseApply( arg1, arg2, arg3, predicate, exception -> ExceptionUtility.printStackTraceAndGetDefault( exception, supplier ) );
    }

    public static < T, U, V > boolean executeOrElseApply( T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, Function< Throwable, Boolean > exceptional ) {
        try { return predicate.test( arg1, arg2, arg3 ); } catch ( Throwable exception ) { return ExceptionUtility.applyExceptional( exception, exceptional ); }
    }

}
