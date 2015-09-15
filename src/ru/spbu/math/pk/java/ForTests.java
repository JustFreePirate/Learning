package ru.spbu.math.pk.java;

/**
 * Created by ִלטענטי on 11.09.2015.
 */
public class ForTests {
    public static void main(String[] args) {
        int n = 12;
        int count = countTwoIntersectSets(n);
        System.out.println(count);
        System.out.println(Math.pow(4,n)-Math.pow(3,n));
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
