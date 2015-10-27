package org.stepic.java.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ִלטענטי on 22.10.2015.
 */
public class SetOperations {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> A_B = new HashSet<>(set1);
        A_B.removeAll(set2);
        Set<T> B_A = new HashSet<>(set2);
        B_A.removeAll(set1);

        Set<T> result = new HashSet<>(A_B);
        result.addAll(B_A);
        return result;
    }
}
