package com.rongaru.common.lang.utility;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionUtility {

    public static < T > String getToString( Collection< T > collection ) {
        return getToString( collection, "" );
    }

    public static < T > String getToString( Collection< T > collection, String delimiter ) {
        return getToString( collection, delimiter, "" );
    }

    public static < T > String getToString( Collection< T > collection, String delimiter, String enclosure ) {
        return getToString( collection, delimiter, enclosure, enclosure );
    }

    public static < T > String getToString( Collection< T > collection, String delimiter, String prefix, String suffix ) {
        return collection.stream( ).map( Objects :: toString ).collect( Collectors.joining( delimiter, prefix, suffix ) );
    }

    public static < T > T getFirstOrElseNull( Collection< T > collection ) {
        return getFirstOrElseDefault( collection, null );
    }

    public static < T > T getFirstOrElseDefault( Collection< T > collection, T value ) {
        return collection.isEmpty( ) ? value : collection.iterator( ).next( );
    }

    public static < T > T filterThenFindFirstOrElseNull( Collection< T > collection, Predicate< T > predicate ) {
        return collection.stream( ).filter( predicate ).findFirst( ).orElse( null );
    }

    public static < T > T filterThenFindFirstOrElseNull( Collection< T > collection, Predicate< T > predicate1, Predicate< T > predicate2 ) {
        return collection.stream( ).filter( predicate1 ).filter( predicate2 ).findFirst( ).orElse( null );
    }

    public static < T > T filterThenFindFirstOrElseNull( Collection< T > collection, Predicate< T > predicate1, Predicate< T > predicate2, Predicate< T > predicate3 ) {
        return collection.stream( ).filter( predicate1 ).filter( predicate2 ).filter( predicate3 ).findFirst( ).orElse( null );
    }

    public static < T > T filterThenFindFirstOrElseDefault( Collection< T > collection, Predicate< T > predicate, T value ) {
        return collection.stream( ).filter( predicate ).findFirst( ).orElse( value );
    }

    public static < T > T filterThenFindFirstOrElseDefault( Collection< T > collection, Predicate< T > predicate1, Predicate< T > predicate2, T value ) {
        return collection.stream( ).filter( predicate1 ).filter( predicate2 ).findFirst( ).orElse( value );
    }

    public static < T > T filterThenFindFirstOrElseDefault( Collection< T > collection, Predicate< T > predicate1, Predicate< T > predicate2, Predicate< T > predicate3, T value ) {
        return collection.stream( ).filter( predicate1 ).filter( predicate2 ).filter( predicate3 ).findFirst( ).orElse( value );
    }

    public static < T > List< T > filterThenCollectToList( Collection< T > collection, Predicate< T > predicate ) {
        return collection.stream( ).filter( predicate ).collect( Collectors.toList( ) );
    }

    public static < T > List< T > filterThenCollectToList( Collection< T > collection, Predicate< T > predicate1, Predicate< T > predicate2 ) {
        return collection.stream( ).filter( predicate1 ).filter( predicate2 ).collect( Collectors.toList( ) );
    }

    public static < T > List< T > filterThenCollectToList( Collection< T > collection, Predicate< T > predicate1, Predicate< T > predicate2, Predicate< T > predicate3 ) {
        return collection.stream( ).filter( predicate1 ).filter( predicate2 ).filter( predicate3 ).collect( Collectors.toList( ) );
    }

    public static < T, R > List< R > applyThenCollectToList( Collection< T > collection, Function< T, R > function ) {
        return collection.stream( ).map( function ).collect( Collectors.toList( ) );
    }

    public static < T, U, R > List< R > applyThenCollectToList( Collection< T > collection, Function< T, U > function1, Function< U, R > function2 ) {
        return collection.stream( ).map( function1 ).map( function2 ).collect( Collectors.toList( ) );
    }

    public static < T, U, V, R > List< R > applyThenCollectToList( Collection< T > collection, Function< T, U > function1, Function< U, V > function2, Function< V, R > function3 ) {
        return collection.stream( ).map( function1 ).map( function2 ).map( function3 ).collect( Collectors.toList( ) );
    }

}
