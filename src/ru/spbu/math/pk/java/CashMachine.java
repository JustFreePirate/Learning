package ru.spbu.math.pk.java;

import java.util.*;

/**
 * Created by cat on 08.09.15.
 */
public class CashMachine {
    public static void main(String[] args) {
        int sum = 10;
        int coins[] = {5, 2, 1};
        /* Input */
        /* ParseInt */
        /* Try catch */
        /* sort */
        List<int[]> options = new LinkedList<int[]>();
        int[] countOfEach = {0, 0, 0};
        getOptionsToChange(sum, options, countOfEach, coins, 1);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(Arrays.toString(options.get(i)));
        }
    }

    private static void getOptionsToChange(int sum, List<int[]> options, int[] countOfEach, int[] coins, int numOfCurrentCoin) {
        if (numOfCurrentCoin <= coins.length) {
            getOptionsToChange(sum, options, countOfEach, coins, numOfCurrentCoin + 1);
            while (sum >= coins[numOfCurrentCoin - 1]) {
                sum -= coins[numOfCurrentCoin - 1];
                countOfEach[numOfCurrentCoin - 1]++;
                getOptionsToChange(sum, options, countOfEach, coins, numOfCurrentCoin);
            }
            if (sum == 0) {
                options.add(countOfEach.clone());
            }
            countOfEach[numOfCurrentCoin - 1] = 0;
        }
    }
}
