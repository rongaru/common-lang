package com.rongaru.common.lang.utility;

import java.util.Map;

public class StringBuilderUtility {

    public static StringBuilder replace( StringBuilder builder, String target, String replacement ) {
        return replace( builder, builder.indexOf( target ), target, replacement );
    }

    public static StringBuilder replace( StringBuilder builder, int start, int end, String replacement ) {
        return builder.replace( start, end, replacement );
    }

    public static StringBuilder replace( StringBuilder builder, int start, String target, String replacement ) {
        return replace( builder, start, start + target.length( ), replacement );
    }

    public static StringBuilder replace( StringBuilder builder, Map< String, String > replacementRegexValueMap ) {
        replacementRegexValueMap.forEach( ( target, replacement ) -> replace( builder, target, replacement ) );
        return builder;
    }

}
