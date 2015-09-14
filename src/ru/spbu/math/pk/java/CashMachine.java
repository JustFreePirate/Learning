package ru.spbu.math.pk.java;

import java.util.*;

/**
 * Created by cat on 08.09.15.
 */
public class CashMachine {
    public static void main(String[] args) {
        int sum = 10000;
        Integer coins[] = {5, 2, 1};
        /* Input */
        /* ParseInt */
        /* Try catch */
        Arrays.sort(coins, Collections.reverseOrder());  /* sort */
        List<int[]> options = new LinkedList<int[]>();
        int[] countOfEach = new int[coins.length];
        getOptionsToChange(sum, options, countOfEach, coins, 1);
/*
        for (ListIterator<int[]> it = options.listIterator(); it.hasNext();) {
            //System.out.println(Arrays.toString(it.next()));
            int[] change = it.next();
            for (int i = 0; i < change.length; i++) {
                System.out.print(coins[i] + "x" + change[i] + "  ");
            }
            System.out.println();
        }
        */
        System.out.println(options.size());
    }

    private static void getOptionsToChange(int sum, List<int[]> options, int[] countOfEach, Integer[] coins, int numOfCurrentCoin) {
        if ((numOfCurrentCoin <= coins.length) && (sum > 0)) {
            getOptionsToChange(sum, options, countOfEach, coins, numOfCurrentCoin + 1);
            while (sum >= coins[numOfCurrentCoin - 1]) {
                sum -= coins[numOfCurrentCoin - 1];
                countOfEach[numOfCurrentCoin - 1]++;
                getOptionsToChange(sum, options, countOfEach, coins, numOfCurrentCoin + 1);
            }
            if (sum == 0) {
                options.add(countOfEach.clone());
            }
            countOfEach[numOfCurrentCoin - 1] = 0;
        }
    }
}
