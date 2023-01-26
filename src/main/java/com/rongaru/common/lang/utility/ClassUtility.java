package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.executor.BiFunctionExecutor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassUtility {

    public static Method getStaticMethod( Class arg, String name ) {
        return getStaticMethod( arg, name, new Class[] { } );
    }

    public static < T > T invokeStaticMethod( Class arg, String name ) {
        return invokeStaticMethod( arg, name, new Object[] { } );
    }

    public static < T > Constructor< T > getConstructor( Class< T > arg ) {
        return getConstructor( arg, new Class[] { } );
    }

    public static Method getStaticMethod( Class arg, String name, Class... args ) {
        return BiFunctionExecutor.executeOrElseThrow( name, args, arg :: getMethod );
    }

    public static < T > Constructor< T > getConstructor( Class< T > arg, Class... args ) {
        return BiFunctionExecutor.executeOrElseThrow( arg, args, Class :: getConstructor );
    }

    public static < T > T invokeStaticMethod( Class arg, String name, Object... args ) {
        return MethodUtility.invoke( getStaticMethod( arg, name, ArrayUtility.applyToAllThenCollectToArray( args, Object :: getClass, Class[] :: new ) ), args );
    }

}
