package org.stepic.java.StreamAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.*;

/**
 * Created by Дмитрий on 23.10.2015.
 */
public class StreamTest {
    public static void main(String[] args) {
        //pseudoRandomStream(13).limit(10).forEachOrdered(System.out::println);

        /** Вывод 10 наиболее встречающихся слов в порядке их частоты и в лексикографическом порядке*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> stream = br.lines();
        stream.map(String::toLowerCase)
                .flatMap(s -> Arrays.stream(s.split("[^a-zа-я0-9]+")))
                .collect(Collectors.toMap(String::toString, s -> 1, (x,y) -> x + y))
                .entrySet().stream()
                .sorted(Comparator.comparing(/*препроцессинг*/ x -> x,
                        //x < y <==> numX > numY || numX == numY && strX < strY
                        (x, y) -> (x.getValue() > y.getValue()
                                || x.getValue() == y.getValue() && (x.getKey().compareTo(y.getKey()) < 0)
                                ? -1
                                : 1) ))
                .map(x -> x.getKey())
                .limit(10)
                .forEachOrdered(System.out::println);
    }
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> ((x * x) / 10) % 1000);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
}
