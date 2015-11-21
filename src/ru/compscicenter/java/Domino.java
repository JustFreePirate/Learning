package ru.compscicenter.java;

import java.util.*;

/**
 * Created by dima on 15.11.15.
 */
public class Domino {
    public static class Pair {
        private int a,b;

        Pair(int x, int y) {
            a = Math.min(x, y);
            b = Math.max(x, y);
        }

        public boolean match(Pair p2) {
            return p2.a == a || p2.b == a || p2.a == b || p2.b == b;
        }

        public boolean isDouble() {
            return a == b;
        }

        @Override
        public boolean equals(Object obj) {
            int x = ((Pair)obj).a;
            int y = ((Pair)obj).b;

            return x == a && y == b;
        }

        @Override
        public int hashCode() {
            return a+b*100;
        }
    }
    public static void main(String[] args) {
        Set<Pair> pairSet = new HashSet<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                pairSet.add(new Pair(i, j));
            }
        }
        Pair[] pairs = new Pair[pairSet.size()];
        pairSet.toArray(pairs);

        Random random = new Random(Calendar.getInstance().getTimeInMillis());
        int count = 100000000;
        int matchCount = 0;
        int count2 = 0;
        for (int i = 0; i < count; i++) {
            int i1 = random.nextInt(pairs.length);
            int i2 = random.nextInt(pairs.length);
            if (i1 != i2) {
                count2++;
                if (isMatch(pairs[i1], pairs[i2])) {
                    matchCount++;
                }
            } else {

            }
        }
        System.out.println("Probability = " + (double)matchCount/count2);
    }

    public static boolean isMatch(Pair p1, Pair p2) {
        return p1.match(p2);
    }

}
