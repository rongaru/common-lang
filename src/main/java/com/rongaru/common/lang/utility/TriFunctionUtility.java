package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.exceptional.TriFunction;
import com.rongaru.common.lang.executor.SupplierExecutor;
import com.rongaru.common.lang.executor.TriFunctionExecutor;

public class TriFunctionUtility {

    public static < T, U, V, R > R apply( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function ) {
        return TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function );
    }

    public static < T, U, V, R > R applyOnTrue( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function ) {
        return condition ? TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function ) : null;
    }

    public static < T, U, V, R > R applyOnFalse( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function ) {
        return condition ? null : TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function );
    }

    public static < T, U, V, R > R applyOnTrueOrElse( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, R value ) {
        return condition ? TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function ) : value;
    }

    public static < T, U, V, R > R applyOnFalseOrElse( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, R value ) {
        return condition ? value : TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function );
    }

    public static < T, U, V, R > R applyOnTrueOrElseGet( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, Supplier< R > supplier ) {
        return condition ? TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T, U, V, R > R applyOnFalseOrElseGet( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, Supplier< R > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function );
    }

    public static < T, U, V, R > R applyOnTrueOrElseApply( boolean condition, T arg1, U arg2, V arg3, TriFunction< T, U, V, R > functionOnTrue, TriFunction< T, U, V, R > functionOnFalse ) {
        return TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, condition ? functionOnTrue : functionOnFalse );
    }

}
