package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.exceptional.TriPredicate;
import com.rongaru.common.lang.executor.SupplierExecutor;
import com.rongaru.common.lang.executor.TriPredicateExecutor;

public class TriPredicateUtility {

    public static < T, U, V > boolean evaluate( T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElseTrue( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return BooleanUtility.isFalse( condition ) || TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElseFalse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return condition && TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnFalseOrElseTrue( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return condition || TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnFalseOrElseFalse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate ) {
        return BooleanUtility.isFalse( condition ) && TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, boolean value ) {
        return condition ? TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate ) : value;
    }

    public static < T, U, V > boolean evaluateOnFalseOrElse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, boolean value ) {
        return condition ? value : TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, Supplier< Boolean > supplier ) {
        return condition ? TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T, U, V > boolean evaluateOnFalseOrElse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicate, Supplier< Boolean > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, predicate );
    }

    public static < T, U, V > boolean evaluateOnTrueOrElse( boolean condition, T arg1, U arg2, V arg3, TriPredicate< T, U, V > predicateOnTrue, TriPredicate< T, U, V > predicateOnFalse ) {
        return TriPredicateExecutor.executeOrElseThrow( arg1, arg2, arg3, condition ? predicateOnTrue : predicateOnFalse );
    }

}
