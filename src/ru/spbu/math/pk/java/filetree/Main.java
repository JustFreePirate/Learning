package ru.spbu.math.pk.java.filetree;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dima on 21.11.15.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        FileTree<Integer> fileTree = new FileTree<>();
        fileTree.mkdir("new");
        fileTree.mkdir("2");
        fileTree.mkdir("1");
        fileTree.mkdir(Paths.get("1"), "dir");
        fileTree.mkdir(Paths.get("1/dir"), "dir2");
        System.out.println(fileTree.getDirsSet(Paths.get("1/dir")));
    }
}
