package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.BiFunction;
import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.executor.BiFunctionExecutor;
import com.rongaru.common.lang.executor.SupplierExecutor;

public class BiFunctionUtility {

    public static < T, U, R > R apply( T arg1, U arg2, BiFunction< T, U, R > function ) {
        return BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function );
    }

    public static < T, U, R > R applyOnTrue( boolean condition, T arg1, U arg2, BiFunction< T, U, R > function ) {
        return condition ? BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function ) : null;
    }

    public static < T, U, R > R applyOnFalse( boolean condition, T arg1, U arg2, BiFunction< T, U, R > function ) {
        return condition ? null : BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function );
    }

    public static < T, U, R > R applyOnTrueOrElse( boolean condition, T arg1, U arg2, BiFunction< T, U, R > function, R value ) {
        return condition ? BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function ) : value;
    }

    public static < T, U, R > R applyOnFalseOrElse( boolean condition, T arg1, U arg2, BiFunction< T, U, R > function, R value ) {
        return condition ? value : BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function );
    }

    public static < T, U, R > R applyOnTrueOrElseGet( boolean condition, T arg1, U arg2, BiFunction< T, U, R > function, Supplier< R > supplier ) {
        return condition ? BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T, U, R > R applyOnFalseOrElseGet( boolean condition, T arg1, U arg2, BiFunction< T, U, R > function, Supplier< R > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function );
    }

    public static < T, U, R > R applyOnTrueOrElseApply( boolean condition, T arg1, U arg2, BiFunction< T, U, R > functionOnTrue, BiFunction< T, U, R > functionOnFalse ) {
        return BiFunctionExecutor.executeOrElseThrow( arg1, arg2, condition ? functionOnTrue : functionOnFalse );
    }

}
