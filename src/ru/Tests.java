package ru;


import java.security.MessageDigest;
import java.util.Optional;
import java.util.Random;
import ru.spbu.math.pk.java.*;
import ru.spbu.math.pk.java.avl.AvlTree;

/**
 * Created by dima on 14.09.15.
 */
public class Tests {
    public static void main(String[] args) {
        int n = 0;
        long N = 10_000_000;
        double sum = 0;
        int a = 100;
        int b = 250;
        Random random = new Random();
        while (n < N) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            x = x*(b-a) + a;
            y = y*(b-a) + a;
            if (true) {
                n++;
                sum += Math.max(x, y);
            }
        }
        System.out.println("average x = " + sum/N);
        System.out.println("(2a+4b)/3 = " + (double)(a+2*b)/3);
    }
}
