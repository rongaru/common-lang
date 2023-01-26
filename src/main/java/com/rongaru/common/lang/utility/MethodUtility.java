package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.executor.BiFunctionExecutor;

import java.lang.reflect.Method;

public class MethodUtility {

    public static < T > T invoke( Method method, Object... args ) {
        return ( T ) BiFunctionExecutor.executeOrElseThrow( null, args, method :: invoke );
    }

    public static < T > T invoke( Object object, Method method, Object... args ) {
        return ( T ) BiFunctionExecutor.executeOrElseThrow( object, args, method :: invoke );
    }

}
