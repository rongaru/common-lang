package com.rongaru.common.lang.utility;

public class BooleanUtility {

    public static boolean isTrue( boolean condition ) {
        return condition;
    }

    public static boolean isFalse( boolean condition ) {
        return !condition;
    }

    public static boolean inverse( boolean condition ) {
        return !condition;
    }

    public static < T > T getOnTrueOrElse( boolean condition, T valueOnTrue, T valueOnFalse ) {
        return condition ? valueOnTrue : valueOnFalse;
    }

    public static < T > T getOnFalseOrElse( boolean condition, T valueOnFalse, T valueOnTrue ) {
        return condition ? valueOnTrue : valueOnFalse;
    }

}
