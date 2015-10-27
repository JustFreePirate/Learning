package ru.spbu.math.pk.java.avl;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.xml.ws.Holder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.function.Consumer;

/**
 * Created by Дмитрий on 27.10.2015.
 */
public class AvlTree<T extends Comparable<T>> {
    private Node<T> root;

    public AvlTree() {
        root = null;
    }

    /**
     * private section
     */

    private static <T extends Comparable<T>>
    Node<T> remove(Node<T> root, T key, Holder<Boolean> removeFlag) {
        if (root == null) {
            removeFlag.value = new Boolean(false);
            return null;
        }

        if (less(key, root.key)) {
            root.left = remove(root.left, key, removeFlag);
        } else if (greater(key, root.key)) {
            root.right = remove(root.right, key, removeFlag);
        } else { //if equals
            removeFlag.value = new Boolean(true);
            if (root.right == null) {
                return root.left;
            }
            Node<T> min = findMin(root.right);
            min.right = removeMin(root.right);
            min.left = root.left;
            return balance(min);
        }

        return balance(root);
    }
    //TODO another constructors

    private static <T extends Comparable<T>>
    Node<T> findMin(Node<T> root) {
        return (root.left != null) ? findMin(root.left) : root;
    }

    private static <T extends Comparable<T>>
    Node<T> removeMin(Node<T> root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = removeMin(root.left);
        return balance(root);
    }

    //Левосторонний обход дерева по рекурсии
    private static <T extends Comparable<T>>
    void forEachRight(Node<T> root, Consumer<? super T> consumer) {
        if (root != null) {
            forEachRight(root.right, consumer);
            consumer.accept(root.key);
            forEachRight(root.left, consumer);
        }
    }

    //Левосторонний обход дерева по рекурсии
    private static <T extends Comparable<T>>
    void forEachLeft(Node<T> root, Consumer<? super T> consumer) {
        if (root != null) {
            forEachLeft(root.left, consumer);
            consumer.accept(root.key);
            forEachLeft(root.right, consumer);
        }
    }

    /* Рекурсивно добавляет в дерево с корнем node новый ключ key.
     * Возвращает сбалансированное дерево*/
    private static <T extends Comparable<T>>
    Node<T> add(Node<T> node, T key) {
        if (node == null) {
            return new Node<T>(key);
        }

        if (less(key, node.key)) {
            node.left = add(node.left, key);
        } else {
            node.right = add(node.right, key);
        }

        return balance(node);
    }

    //TODO balance method
    private static <T extends Comparable<T>>
    Node<T> balance(Node<T> node) {
        node.fixHeight();
        if (node.balanceFactor() == +2) {
            if (node.right.balanceFactor() < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        if (node.balanceFactor() == -2) {
            if (node.left.balanceFactor() > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        return node; //балансировка не нужна
    }

    //rotate right
    private static <T extends Comparable<T>>
    Node<T> rotateRight(Node<T> p) {
        Node<T> q = p.left;
        p.left = q.right;
        q.right = p;
        p.fixHeight();
        q.fixHeight();
        return q;
    }

    //rotate left
    private static <T extends Comparable<T>>
    Node<T> rotateLeft(Node<T> q) {
        Node<T> p = q.right;
        q.right = p.left;
        p.left = q;
        q.fixHeight();
        p.fixHeight();
        return p;
    }

    private static <T extends Comparable<T>>
    boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    private static <T extends Comparable<T>>
    boolean greater(T a, T b) {
        return a.compareTo(b) > 0;
    }

    //TODO size method
    public int size() {
        return root != null ? root.height : 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T key) {
        if (key != null) {
            root = add(root, key);
        }
    }

    public boolean remove(T key) {
        if (key != null) {
            Holder<Boolean> removeFlag = new Holder<>();
            root = remove(root, key, removeFlag);
            return removeFlag.value;
        }
        return false;
    }

    public void forEachLeft(Consumer<? super T> consumer) {
        forEachLeft(root, consumer);
    }

    public void forEachRight(Consumer<? super T> consumer) {
        forEachRight(root, consumer);
    }

    private static class Node<T extends Comparable<T>> {
        private final T key;
        private Node<T> left, right;
        private byte height;

        public Node(T key) {
            this.key = key;
            left = right = null;
            height = 1;
        }


        private static <T extends Comparable<T>>
        byte height(Node<T> node) {
            return (node != null) ? node.height : 0;
        }

        byte max(byte a, byte b) {
            return a > b ? a : b;
        }

        public byte balanceFactor() {
            return (byte) (height(right) - height(left));
        }

        public void fixHeight() {
            height = (byte) (max(height(left), height(right)) + 1);
        }
    }
}
