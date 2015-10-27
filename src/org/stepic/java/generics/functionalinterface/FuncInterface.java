package org.stepic.java.generics.functionalinterface;



import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by ִלטענטי on 23.10.2015.
 */
public class FuncInterface {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (x) -> condition.test(x)?ifTrue.apply(x):ifFalse.apply(x); // your implementation here
    }
}
