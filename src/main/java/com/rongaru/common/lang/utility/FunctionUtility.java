package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Function;
import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.executor.FunctionExecutor;
import com.rongaru.common.lang.executor.SupplierExecutor;

public class FunctionUtility {

    public static < T, R > R apply( T arg, Function< T, R > function ) {
        return FunctionExecutor.executeOrElseThrow( arg, function );
    }

    public static < T, R > R applyOnTrue( boolean condition, T arg, Function< T, R > function ) {
        return condition ? FunctionExecutor.executeOrElseThrow( arg, function ) : null;
    }

    public static < T, R > R applyOnFalse( boolean condition, T arg, Function< T, R > function ) {
        return condition ? null : FunctionExecutor.executeOrElseThrow( arg, function );
    }

    public static < T, R > R applyOnTrueOrElse( boolean condition, T arg, Function< T, R > function, R value ) {
        return condition ? FunctionExecutor.executeOrElseThrow( arg, function ) : value;
    }

    public static < T, R > R applyOnFalseOrElse( boolean condition, T arg, Function< T, R > function, R value ) {
        return condition ? value : FunctionExecutor.executeOrElseThrow( arg, function );
    }

    public static < T, R > R applyOnTrueOrElseGet( boolean condition, T arg, Function< T, R > function, Supplier< R > supplier ) {
        return condition ? FunctionExecutor.executeOrElseThrow( arg, function ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T, R > R applyOnFalseOrElseGet( boolean condition, T arg, Function< T, R > function, Supplier< R > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : FunctionExecutor.executeOrElseThrow( arg, function );
    }

    public static < T, U, R > R applyMultipleTimes( T arg, Function< T, U > function1, Function< U, R > function2 ) {
        return FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function1 ), function2 );
    }

    public static < T, R > R applyOnTrueOrElseApply( boolean condition, T arg, Function< T, R > functionOnTrue, Function< T, R > functionOnFalse ) {
        return FunctionExecutor.executeOrElseThrow( arg, condition ? functionOnTrue : functionOnFalse );
    }

    public static < T, U, V, R > R applyMultipleTimes( T arg, Function< T, U > function1, Function< U, V > function2, Function< V, R > function3 ) {
        return FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function1 ), function2 ), function3 );
    }

    public static < T, U, V, W, R > R applyMultipleTimes( T arg, Function< T, U > function1, Function< U, V > function2, Function< V, W > function3, Function< W, R > function4 ) {
        return FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function1 ), function2 ), function3 ), function4 );
    }

    public static < T, U, V, W, X, R > R applyMultipleTimes( T arg, Function< T, U > function1, Function< U, V > function2, Function< V, W > function3, Function< W, X > function4, Function< X, R > function5 ) {
        return FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function1 ), function2 ), function3 ), function4 ), function5 );
    }

}
