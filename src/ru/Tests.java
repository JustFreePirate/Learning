package ru;



import java.security.MessageDigest;
import java.util.Random;
import ru.spbu.math.pk.java.*;

/**
 * Created by dima on 14.09.15.
 */
public class Tests {
    public static void main(String[] args) {
        MyList<Integer> list = new MyLinkedList<Integer>();
        Printer<Integer> printer = new Printer<>();
        for (int i = 0; i < 10; i++) {
            list.add(i/2,i*10);
        }
        list.remove(9);
        list.map(printer);
    }

}
