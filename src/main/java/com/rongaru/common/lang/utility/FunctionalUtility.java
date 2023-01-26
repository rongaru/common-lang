package com.rongaru.common.lang.utility;

import com.rongaru.common.lang.exceptional.*;
import com.rongaru.common.lang.executor.*;

public class FunctionalUtility {

    public static < T > void getThenAccept( Supplier< T > supplier, Consumer< T > consumer ) {
        ConsumerExecutor.executeOrElseThrow( SupplierExecutor.executeOrElseThrow( supplier ), consumer );
    }

    public static < T, U > U getThenApply( Supplier< T > supplier, Function< T, U > function ) {
        return FunctionExecutor.executeOrElseThrow( SupplierExecutor.executeOrElseThrow( supplier ), function );
    }

    public static < T > boolean getThenEvaluate( Supplier< T > supplier, Predicate< T > predicate ) {
        return PredicateExecutor.executeOrElseThrow( SupplierExecutor.executeOrElseThrow( supplier ), predicate );
    }

    public static < T, U > void applyThenAccept( T arg, Function< T, U > function, Consumer< U > consumer ) {
        ConsumerExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function ), consumer );
    }

    public static < T, U, R > R applyThenApply( T arg, Function< T, U > function1, Function< U, R > function2 ) {
        return FunctionExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function1 ), function2 );
    }

    public static < T, U > boolean applyThenEvaluate( T arg, Function< T, U > function, Predicate< U > predicate ) {
        return PredicateExecutor.executeOrElseThrow( FunctionExecutor.executeOrElseThrow( arg, function ), predicate );
    }

    public static < T, U, R > void applyThenAccept( T arg1, U arg2, BiFunction< T, U, R > function, Consumer< R > consumer ) {
        ConsumerExecutor.executeOrElseThrow( BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function ), consumer );
    }

    public static < T, U, V, R > R applyThenApply( T arg1, U arg2, BiFunction< T, U, V > function1, Function< V, R > function2 ) {
        return FunctionExecutor.executeOrElseThrow( BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function1 ), function2 );
    }

    public static < T, U, R > boolean applyThenEvaluate( T arg1, U arg2, BiFunction< T, U, R > function, Predicate< R > predicate ) {
        return PredicateExecutor.executeOrElseThrow( BiFunctionExecutor.executeOrElseThrow( arg1, arg2, function ), predicate );
    }

    public static < T, U, V, R > void applyThenAccept( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, Consumer< R > consumer ) {
        ConsumerExecutor.executeOrElseThrow( TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function ), consumer );
    }

    public static < T, U, V, W, R > R applyThenApply( T arg1, U arg2, V arg3, TriFunction< T, U, V, W > function1, Function< W, R > function2 ) {
        return FunctionExecutor.executeOrElseThrow( TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function1 ), function2 );
    }

    public static < T, U, V, R > boolean applyThenEvaluate( T arg1, U arg2, V arg3, TriFunction< T, U, V, R > function, Predicate< R > predicate ) {
        return PredicateExecutor.executeOrElseThrow( TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function ), predicate );
    }

    public static < T, U, V, R > R acceptThenApply( T arg1, U arg2, V arg3, TriConsumer< T, U, V > consumer, TriFunction< T, U, V, R > function ) {
        TriConsumerExecutor.executeOrElseThrow( arg1, arg2, arg3, consumer );
        return TriFunctionExecutor.executeOrElseThrow( arg1, arg2, arg3, function );
    }

}
