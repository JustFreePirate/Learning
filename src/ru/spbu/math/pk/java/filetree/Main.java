package ru.spbu.math.pk.java.filetree;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dima on 21.11.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileTree<Integer> fileTree = new FileTree<>();
        fileTree.mkdir("1");
        fileTree.changeDir("1");
        fileTree.mkdir("2");
        fileTree.changeDir("2");
        fileTree.mkdir("3");
        fileTree.changeDir("3");
        fileTree.mkdir("4");
        Path p = Paths.get("/1/2");
        fileTree.mkdir(Paths.get("/1/2"), "7");
        fileTree.mkdir(Paths.get("http://google.com"), "7");
        fileTree.put(Paths.get("/1"), "1", 1);
        fileTree.put(Paths.get("/1/2"), "2", 2);
        fileTree.put(Paths.get("kiyk"), "3", 3);
        FileSystem fs = p.getFileSystem();
        fileTree.print();
    }

}
