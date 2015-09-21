package ru.spbu.math.pk.java;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ִלטענטי on 11.09.2015.
 */
public class ForTests {
    public static void main(String[] args) {
        System.out.println(printTextPerRole(new String[]{"a"},new String[]{"b: sdsd","a:"}));
    }
    private static String printTextPerRole(String[] roles, String[] textLines) {
        List<String>[] list =  new ArrayList[roles.length];
        for (int i = 0; i < roles.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < textLines.length; i++) {
            for (int j = 0; j < roles.length; j++) {
                if (textLines[i].startsWith(roles[j])) {
                    list[j].add((i+1) + ")" + textLines[i].substring( roles[j].length() + 1 ) + "\n");
                    break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            res.append(roles[i] + ":\n");
            for (int j = 0; j < list[i].size(); j++) {
                res.append(list[i].get(j));
            }
            res.append("\n");
        }
        return res.toString();
    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
        final int len1 = a1.length;
        final int len2 = a2.length;
        final int len3 = len1 + len2;
        int[] a3 = new int[len3];
        int j = 0, k = 0;
        for (int i = 0; i < len3; i++) {
            if (j < len1 && k < len2) {
                a3[i] = (a1[j] < a2[k]) ? a1[j++] : a2[k++];
                continue;
            }
            if (j >= len1) {
                a3[i] = a2[k++]; continue;
            }
            if (k >= len2) {
                a3[i] = a1[j++]; continue;
            }
        }
        return a3; // your implementation here
    }
    public static BigInteger factorial(int N) {
        BigInteger res = new BigInteger("1");
        for (int i = 1; i <= N; i++) {
            res = res.multiply(new BigInteger(new Integer(i).toString()));
        }
        return res; // your implementation here
    }

    public static boolean isPalindrome(String text) {
        String pureText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String inversePureText = new StringBuffer(pureText).reverse().toString();
        return pureText.equals(inversePureText); // your implementation here
    }

    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        return (value != 0) && (value & (value - 1)) == 0; // you implementation here
    }

    public static int countTwoIntersectSets(int n) {
        int max = (int) Math.pow(2,n);
        int count = 0;
        for (int a = 0; a < max; a++) {
            for (int b = 0; b < max; b++) {
                if ((a & b) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
