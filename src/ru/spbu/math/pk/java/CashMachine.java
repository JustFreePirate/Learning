package ru.spbu.math.pk.java;

import java.io.*;
import java.util.*;

/**
 * Created by cat on 08.09.15.
 */
public class CashMachine {
    public static void main(String[] args) {
        int sum;

        List<Integer> coins = new ArrayList<Integer>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("Input format: [Sum coin1 coin2 ... ]");
            String s;
            try {
                s = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("No such element exception!");
                return;
            }
            scanner.close();
            scanner = new Scanner(s);
            if (scanner.hasNext()) {
                sum = scanner.nextInt();
            } else {
                System.out.println("sum was not detected");
                return;
            }

            while (scanner.hasNext()) {
                coins.add(scanner.nextInt());
            }

        } catch (InputMismatchException e ) {
            System.out.println("wrong input format");
            return;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        /* sort */

        List<int[]> options = getOptionsToChange(sum, coins);

        for (ListIterator<int[]> it = options.listIterator(); it.hasNext();) { //go to list of answers
            int[] change = it.next();
            for (int i = 0; i < change.length; i++) {
                System.out.print(coins.get(i) + "x" + change[i] + "  ");
            }
            System.out.println();
        }
    }
    public static List<int[]> getOptionsToChange(int sum, List<Integer> coins) {
        List<int[]> options  = new ArrayList<int[]>();
        int[] countOfEach = new int[coins.size()];
        coins.sort(Comparator.<Integer>reverseOrder());
        getOptionsToChange(sum, options, countOfEach, coins,1);
        return options;
    }
    private static void getOptionsToChange(int sum, List<int[]> options, int[] countOfEach, List<Integer> coins, int numOfCurrentCoin) {
        if ((numOfCurrentCoin <= coins.size()) && (sum > 0)) {
            getOptionsToChange(sum, options, countOfEach, coins, numOfCurrentCoin + 1);
            while (sum >= coins.get(numOfCurrentCoin - 1)) {
                sum -= coins.get(numOfCurrentCoin - 1);
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
