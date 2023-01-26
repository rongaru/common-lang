package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Consumer;
import com.rongaru.common.lang.exceptional.Function;
import com.rongaru.common.lang.exceptional.Supplier;

public class ExceptionUtility {

    public static < T > T throwRuntimeException( Throwable throwable ) {
        throw new RuntimeException( throwable );
    }

    public static < T > T printStackTraceAndGetNull( Throwable throwable ) {
        throwable.printStackTrace( );
        return null;
    }

    public static < T > T printStackTraceAndGetDefault( Throwable throwable, T value ) {
        throwable.printStackTrace( );
        return value;
    }

    public static void acceptExceptional( Throwable throwable, Consumer< Throwable > exceptional ) {
        try { exceptional.accept( throwable ); } catch ( Throwable e ) { throw new RuntimeException( e ); }
    }

    public static < T > T applyExceptional( Throwable throwable, Function< Throwable, T > exceptional ) {
        try { return exceptional.apply( throwable ); } catch ( Throwable e ) { throw new RuntimeException( e ); }
    }

    public static < T > T printStackTraceAndGetDefault( Throwable throwable, Supplier< T > supplier ) {
        try {
            throwable.printStackTrace( );
            return supplier.get( );
        } catch ( Throwable e ) { throw new RuntimeException( e ); }
    }

}
