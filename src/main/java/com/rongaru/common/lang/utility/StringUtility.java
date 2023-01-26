package com.rongaru.common.lang.utility;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtility {

    public static boolean isEmpty( String value ) {
        return value == null || value.trim( ).length( ) == 0;
    }

    public static boolean isBlank( String value ) {
        return value == null || value.trim( ).length( ) == 0;
    }

    public static boolean equals( String value1, String value2 ) {
        String var1 = ObjectUtility.applyOnNotNull( value1, String :: trim );
        String var2 = ObjectUtility.applyOnNotNull( value2, String :: trim );
        return ObjectUtility.isEquals( var1, var2 );
    }

    public static boolean equalsIgnoreCase( String value1, String value2 ) {
        String var1 = ObjectUtility.applyOnNotNull( value1, String :: trim );
        String var2 = ObjectUtility.applyOnNotNull( value2, String :: trim );
        return var1 == null ? var2 == null : var1.equalsIgnoreCase( var2 );
    }

    public static String getDefaultOnNull( String value, String defaultValue ) {
        return value == null ? defaultValue : value;
    }

    public static String replace( String value, String target, String replacement ) {
        return StringBuilderUtility.replace( new StringBuilder( value ), target, replacement ).toString( );
    }

    public static String replace( String value, Map< String, String > replacementKeyValueMap ) {
        return StringBuilderUtility.replace( new StringBuilder( value ), replacementKeyValueMap ).toString( );
    }

    public static String join( String... values ) {
        return join( "", values );
    }

    public static String join( String delimiter, String... values ) {
        return join( delimiter, "", values );
    }

    public static String join( String delimiter, String enclosure, String... values ) {
        return join( delimiter, enclosure, enclosure, values );
    }

    public static String join( String delimiter, String prefix, String suffix, String... values ) {
        return Arrays.stream( values ).collect( Collectors.joining( delimiter, prefix, suffix ) );
    }

    public static String join( Collection< String > values ) {
        return join( values, "" );
    }

    public static String join( Collection< String > values, String delimiter ) {
        return join( values, delimiter, "" );
    }

    public static String join( Collection< String > values, String delimiter, String enclosure ) {
        return join( values, delimiter, enclosure, enclosure );
    }

    public static String join( Collection< String > values, String delimiter, String prefix, String suffix ) {
        return values.stream( ).collect( Collectors.joining( delimiter, prefix, suffix ) );
    }

}
