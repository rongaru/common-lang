package com.rongaru.common.lang.utility;

public class LoggingUtility {

    protected static String getClassNameFromStackTrace( ) {
        StackTraceElement[] stackTraceElements = Thread.currentThread( ).getStackTrace( );
        StackTraceElement callingStackTraceElement = stackTraceElements[ 3 ];
        return callingStackTraceElement.getClassName( );
    }

    public static void info( String message ) {
        System.out.println( "[ INFO ] " + getClassNameFromStackTrace( ) + " : " + message );
    }

    public static void debug( String message ) {
        System.out.println( "[ DEBUG ] " + getClassNameFromStackTrace( ) + " : " + message );
    }

    public static void error( String message ) {
        System.out.println( "[ ERROR ] " + getClassNameFromStackTrace( ) + " : " + message );
    }

    public static void trace( String message ) {
        System.out.println( "[ TRACE ] " + getClassNameFromStackTrace( ) + " : " + message );
    }

    public static void warn( String message ) {
        System.out.println( "[ WARNING ] " + getClassNameFromStackTrace( ) + " : " + message );
    }

}
