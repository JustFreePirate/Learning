package ru.spbu.math.pk.java;

/**
 * Created by ִלטענטי on 11.09.2015.
 */
public class ForTests {
    public static void main(String[] args) {
        int count = 0;
        int n = 999;
        for (int i = 1; i <= 10; i++)
            for (int j = i; j <= 10; j++)
                for (int k = j; k <= 10; k++)
                    count++;
        System.out.println(count);
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
