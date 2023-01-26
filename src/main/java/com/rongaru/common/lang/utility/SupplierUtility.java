package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.executor.SupplierExecutor;

public class SupplierUtility {

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : null;
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier ) {
        return condition ? null : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier, T value ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : value;
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier, T value ) {
        return condition ? value : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T > T getOnTrueOrElse( boolean condition, Supplier< T > supplier, Supplier< T > supplier2 ) {
        return SupplierExecutor.executeOrElseThrow( condition ? supplier : supplier2 );
    }

    public static < T > T getOnFalseOrElse( boolean condition, Supplier< T > supplier, Supplier< T > supplier2 ) {
        return SupplierExecutor.executeOrElseThrow( condition ? supplier2 : supplier );
    }

}
