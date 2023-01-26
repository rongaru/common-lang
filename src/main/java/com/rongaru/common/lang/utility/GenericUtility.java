package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.executor.FunctionExecutor;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;

public class GenericUtility {

    public static ParameterizedType getParameterizedType( Class arg ) {
        return ( ParameterizedType ) arg.getGenericSuperclass( );
    }

    public static String getParameterizedTypeArgumentClassName( Class arg, int index ) {
        return getParameterizedTypeArgumentClass( arg, index ).getName( );
    }

    public static < T > T getParameterizedTypeArgumentInstance( Class arg, int index ) {
        Class< T > val = getParameterizedTypeArgumentClass( arg, index );
        Constructor< T > constructor = ClassUtility.getConstructor( val );
        return FunctionExecutor.executeOrElseThrow( constructor, Constructor :: newInstance );
    }

    public static String getParameterizedTypeArgumentClassSimpleName( Class arg, int index ) {
        return getParameterizedTypeArgumentClass( arg, index ).getSimpleName( );
    }

    public static < T > Class< T > getParameterizedTypeArgumentClass( Class arg, int index ) {
        return getParameterizedTypeArgument( getParameterizedType( arg ), index );
    }

    public static < T > Class< T > getParameterizedTypeArgument( ParameterizedType parameterizedType, int index ) {
        return ( Class< T > ) parameterizedType.getActualTypeArguments( )[ index ];
    }

}
