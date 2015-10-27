package org.stepic.java.generics;

import java.util.Objects;

/**
 * Created by ִלטענטי on 20.10.2015.
 */
public class Pair<T1,T2>  {
    private final T1 first;
    private final T2 second;

    private Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public static <T1,T2> Pair<T1,T2> of(T1 first, T2 second) {
        return new Pair<>(first, second);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println(i);
        System.out.println(s);
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(first) + Objects.hashCode(second);
    }

    public boolean equals(Pair<T1,T2> pair) {
        if (pair == null) {
            return false;
        }
        return Objects.equals(pair.getFirst(), first) && Objects.equals(pair.getSecond(), second);
    }
}
