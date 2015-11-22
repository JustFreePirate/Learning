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
        fileTree.put("int1", 1);
        //System.out.println(fileTree.getDirsSet());
        fileTree.changeDir("1");
        fileTree.put("int2", 2);
        fileTree.put("int3", 3);

        fileTree.mkdir("dir");
        fileTree.mkdir("dir2");
        fileTree.print();
    }

}
