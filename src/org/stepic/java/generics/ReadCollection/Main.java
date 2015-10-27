package org.stepic.java.generics.ReadCollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * Created by ִלטענטי on 22.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        //Reader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\s");
        int i = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (i % 2 == 1) {
                    int num = scanner.nextInt();
                    stack.push(num);
                } else {
                    scanner.next();
                }
                i++;
            } else {
                scanner.next();
            }
        }

        int size = stack.size();
        for (int j = 0; j < size; j++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
