package org.stepic.java.iosamples.summator;

import java.util.Scanner;

/**
 * Created by ִלטענטי on 15.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s");
        double sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf("%.6f", sum);
    }
}
