package ru.spbu.math.pk.java;

import java.io.*;
import java.util.*;

/**
 * Created by cat on 08.09.15.
 */
public class CashMachine {
    public static void main(String[] args) throws NoSuchElementException{
        int sum;
        int countOfCoins;
        Integer coins[];
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            System.out.println("Input format: [Sum number_of_coins coin1 coin2 ... coinN]");
            sum = scanner.nextInt();
            countOfCoins = scanner.nextInt();
            coins = new Integer[countOfCoins];
            for (int i = 0; i < countOfCoins; i++) {
                coins[i] = scanner.nextInt();
            }
        } catch (InputMismatchException e ) {
            System.out.println("wrong input format");
            return;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        Arrays.sort(coins, Collections.reverseOrder());  /* sort */
        List<int[]> options = new LinkedList<int[]>(); //answers
        int[] countOfEach = new int[coins.length]; //is needed for answer
        getOptionsToChange(sum, options, countOfEach, coins, 1); //get answers

        for (ListIterator<int[]> it = options.listIterator(); it.hasNext();) { //go to list of answers
            int[] change = it.next();
            for (int i = 0; i < change.length; i++) {
                System.out.print(coins[i] + "x" + change[i] + "  ");
            }
            System.out.println();
        }
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
