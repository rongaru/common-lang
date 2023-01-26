package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.Predicate;
import com.rongaru.common.lang.exceptional.Supplier;
import com.rongaru.common.lang.executor.PredicateExecutor;
import com.rongaru.common.lang.executor.SupplierExecutor;

public class PredicateUtility {

    public static < T > boolean evaluate( T arg1, Predicate< T > predicate ) {
        return PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElseTrue( boolean condition, T arg1, Predicate< T > predicate ) {
        return BooleanUtility.isFalse( condition ) || PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElseFalse( boolean condition, T arg1, Predicate< T > predicate ) {
        return condition && PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnFalseOrElseTrue( boolean condition, T arg1, Predicate< T > predicate ) {
        return condition || PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnFalseOrElseFalse( boolean condition, T arg1, Predicate< T > predicate ) {
        return BooleanUtility.isFalse( condition ) && PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T arg1, Predicate< T > predicate, boolean value ) {
        return condition ? PredicateExecutor.executeOrElseThrow( arg1, predicate ) : value;
    }

    public static < T > boolean evaluateOnFalseOrElse( boolean condition, T arg1, Predicate< T > predicate, boolean value ) {
        return condition ? value : PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T arg1, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return condition ? PredicateExecutor.executeOrElseThrow( arg1, predicate ) : SupplierExecutor.executeOrElseThrow( supplier );
    }

    public static < T > boolean evaluateOnFalseOrElse( boolean condition, T arg1, Predicate< T > predicate, Supplier< Boolean > supplier ) {
        return condition ? SupplierExecutor.executeOrElseThrow( supplier ) : PredicateExecutor.executeOrElseThrow( arg1, predicate );
    }

    public static < T > boolean evaluateOnTrueOrElse( boolean condition, T arg1, Predicate< T > predicateOnTrue, Predicate< T > predicateOnFalse ) {
        return PredicateExecutor.executeOrElseThrow( arg1, condition ? predicateOnTrue : predicateOnFalse );
    }

}
