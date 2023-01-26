package com.rongaru.common.lang.utility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayUtility {

    public static < T > T getIndexValue( T[] array, int index ) {
        return array[ index ];
    }

    public static < T > T[] createArray( Class< T > arg, int length ) {
        return ( T[] ) Array.newInstance( arg, length );
    }

    public static < T > void copyIndexValue( T[] source, T[] target, int index ) {
        target[ index ] = source[ index ];
    }

    public static < T, R > Object[] applyToAll( T[] array, Function< T, R > function ) {
        return Arrays.stream( array ).map( function ).toArray( );
    }

    public static < T, R > Set< R > applyToAllThenCollectToSet( T[] array, Function< T, R > function ) {
        return Arrays.stream( array ).map( function ).collect( Collectors.toSet( ) );
    }

    public static < T, R > List< R > applyToAllThenCollectToList( T[] array, Function< T, R > function ) {
        return Arrays.stream( array ).map( function ).collect( Collectors.toList( ) );
    }

    public static < T, R > Object[] filterThenApplyToAll( T[] array, Predicate< T > predicate, Function< T, R > function ) {
        return Arrays.stream( array ).filter( predicate ).map( function ).toArray( );
    }

    public static < T, R > R[] applyToAllThenCollectToArray( T[] array, Function< T, R > function, IntFunction< R[] > intFunction ) {
        return Arrays.stream( array ).map( function ).toArray( intFunction );
    }

}
