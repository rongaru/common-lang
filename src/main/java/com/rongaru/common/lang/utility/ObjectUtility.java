package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.exceptional.Function;
import com.rongaru.common.lang.exceptional.Runnable;
import com.rongaru.common.lang.exceptional.Supplier;

import java.util.Objects;

public class ObjectUtility {

    public static < T > T cast( Object arg ) {
        return ( T ) arg;
    }

    public static boolean isNull( Object arg ) {
        return arg == null;
    }

    public static boolean isNotNull( Object arg ) {
        return arg != null;
    }

    public static boolean isEquals( Object arg1, Object arg2 ) {
        return Objects.equals( arg1, arg2 );
    }

    public static boolean isNotEquals( Object arg1, Object arg2 ) {
        return BooleanUtility.isFalse( isEquals( arg1, arg2 ) );
    }

    public static void runOnNull( Object arg, Runnable runnable ) {
        RunnableUtility.runOnTrue( isNull( arg ), runnable );
    }

    public static void runOnNotNull( Object arg, Runnable runnable ) {
        RunnableUtility.runOnTrue( isNotNull( arg ), runnable );
    }

    public static < T > T getOnNull( T arg, Supplier< T > supplier ) {
        return SupplierUtility.getOnTrueOrElse( isNull( arg ), supplier, arg );
    }

    public static < T > T getOnNotNull( T arg, Supplier< T > supplier ) {
        return SupplierUtility.getOnTrueOrElse( isNotNull( arg ), supplier, arg );
    }

    public static < T > void acceptOnNull( T arg, Consumer< T > consumer ) {
        ConsumerUtility.acceptOnTrue( isNull( arg ), arg, consumer );
    }

    public static < T > void acceptOnNotNull( T arg, Consumer< T > consumer ) {
        ConsumerUtility.acceptOnTrue( isNotNull( arg ), arg, consumer );
    }

    public static < T, R > R applyOnNull( T arg, Function< T, R > function ) {
        return FunctionUtility.applyOnTrue( isNull( arg ), arg, function );
    }

    public static < T, R > R applyOnNotNull( T arg, Function< T, R > function ) {
        return FunctionUtility.applyOnTrue( isNotNull( arg ), arg, function );
    }

    public static < T > T getOnNullOrElse( T arg, Supplier< T > supplier, T value ) {
        return SupplierUtility.getOnTrueOrElse( isNull( arg ), supplier, value );
    }

    public static < T > T getOnNotNullOrElse( T arg, Supplier< T > supplier, T value ) {
        return SupplierUtility.getOnTrueOrElse( isNotNull( arg ), supplier, value );
    }

    public static < T > T getOnNullOrElse( T arg, Supplier< T > supplier, Supplier< T > supplier2 ) {
        return SupplierUtility.getOnTrueOrElse( isNull( arg ), supplier, supplier2 );
    }

    public static < T > T getOnNotNullOrElse( T arg, Supplier< T > supplier, Supplier< T > supplier2 ) {
        return SupplierUtility.getOnTrueOrElse( isNotNull( arg ), supplier, supplier2 );
    }

    public static < T, R > void applyOnNullThen( T arg, Function< T, R > function, Consumer< R > consumer ) {
        ConsumerUtility.acceptOnTrue( isNull( arg ), applyOnNull( arg, function ), consumer );
    }

    public static < T, R > void applyOnNotNullThen( T arg, Function< T, R > function, Consumer< R > consumer ) {
        ConsumerUtility.acceptOnTrue( isNotNull( arg ), applyOnNotNull( arg, function ), consumer );
    }

    public static < T > void getOnNullThen( T arg, Supplier< T > supplier, Consumer< T > consumer ) {
        ConsumerUtility.acceptOnTrue( isNull( arg ), getOnNull( arg, supplier ), consumer );
    }

    public static < T > void getOnNotNullThen( T arg, Supplier< T > supplier, Consumer< T > consumer ) {
        ConsumerUtility.acceptOnTrue( isNotNull( arg ), getOnNotNull( arg, supplier ), consumer );
    }

    public static < T > T getOnNullThenAcceptThenGet( T arg, Supplier< T > supplier, Consumer< T > consumer ) {
        ConsumerUtility.acceptOnTrue( isNull( arg ), getOnNull( arg, supplier ), consumer );
        return arg;
    }

    public static < T > T getOnNotNullThenAcceptThenGet( T arg, Supplier< T > supplier, Consumer< T > consumer ) {
        ConsumerUtility.acceptOnTrue( isNotNull( arg ), getOnNotNull( arg, supplier ), consumer );
        return arg;
    }

}
