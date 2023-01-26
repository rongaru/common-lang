package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Function;
import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.executor.FunctionExecutor;
import com.rongaru.common.lang.executor.SupplierExecutor;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicUtility {

    public static < T > void changeReference( AtomicReference< T > arg, Supplier< T > supplier ) {
        arg.set( SupplierExecutor.executeOrElseThrow( supplier ) );
    }

    public static < T > void changeReference( AtomicReference< T > arg, Function< T, T > function ) {
        arg.set( FunctionExecutor.executeOrElseThrow( arg.get( ), function ) );
    }

}
