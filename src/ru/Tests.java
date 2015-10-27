package ru;

import Jama.*;

import java.security.MessageDigest;
import java.util.Random;
import ru.spbu.math.pk.java.*;
import ru.spbu.math.pk.java.avl.AvlTree;

/**
 * Created by dima on 14.09.15.
 */
public class Tests {
    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
        int module = 127;
        for (int i = 0, d = 3, t = 1; i < module - 1; i++) {
            t = (t*d)%module;
            tree.add(t);
        }
        /*
        for (int i = 0, d = 5, t = 1; i < module - 1; i++) {
            t = (t*d)%module;
            System.out.println(tree.remove(t));
            //System.out.println(tree.remove(t));
        }
        */
        tree.forEachLeft(x -> System.out.println(x));
    }
}
