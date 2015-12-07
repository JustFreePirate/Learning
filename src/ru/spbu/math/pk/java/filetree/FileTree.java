package ru.spbu.math.pk.java.filetree;

import ru.spbu.math.pk.java.filetree.exceptions.MyFileAlreadyExistsException;
import ru.spbu.math.pk.java.filetree.exceptions.MyFileNotFoundException;

//uses ONLY to parse String <-> path in FileTree
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;


/**
 * Created by dima on 21.11.15.
 * Tree with random access to nodes, like structure in file system. (Without any access to file system)
 * All files have type generic E, and have to be named unique
 * All folders have to be named unique too. Files and folders may have the same names.
 *
 * @throws MyFileAlreadyExistsException if you try to add file or folder with name that already exist
 * @throws MyFileNotFoundException if you try get file or folder with name that doesn't exist
 */
public class FileTree<E> {
    private Path rootPath;
    private Directory<E> rootDirectory;
    private Path workingDirectoryPath;
    private Directory<E> workingDirectory;

    public FileTree() {
        rootPath = Paths.get("/");
        rootDirectory = new Directory<E>();
        workingDirectoryPath = rootPath;
        workingDirectory = rootDirectory;
    }

    private Directory<E> getDirectory(Path dirPath) throws MyFileNotFoundException {
        dirPath = dirPath.normalize();
        Directory<E> current;
        if (dirPath.isAbsolute()) {
            current = rootDirectory;
        } else {
            current = workingDirectory;
        }
        for (Path dir : dirPath) {
            current = current.getDir(dir.toString());
        }
        return current;
    }

    public void print() {
        rootDirectory.recursivePrint(rootPath);
    }

    //put file in working directory
    public void put(String fileName, E file) throws MyFileAlreadyExistsException {
        workingDirectory.put(fileName, file);
    }

    //put file in directory
    public void put(Path dirPath, String fileName, E file) throws MyFileNotFoundException, MyFileAlreadyExistsException {
        Directory<E> dir = getDirectory(dirPath);
        dir.put(fileName, file);
    }

    //remove file from working directory
    public void remove(String fileName) throws MyFileNotFoundException {
        workingDirectory.remove(fileName);
    }

    //remove file from directory
    public void remove(Path dirPath, String fileName) throws MyFileNotFoundException {
        Directory<?> dir = getDirectory(dirPath);
        dir.remove(fileName);
    }

    //get file in working directory with filename
    public E get(String fileName) throws MyFileNotFoundException {
        return workingDirectory.getFile(fileName);
    }

    //get file in with filename
    public E get(Path dirPath, String fileName) throws MyFileNotFoundException {
        Directory<E> dir = getDirectory(dirPath);
        return dir.getFile(fileName);
    }

    //make new directory in working directory
    public void mkdir(String dirName) throws MyFileAlreadyExistsException {
        workingDirectory.mkdir(dirName);
    }

    //make new directory with name in directory
    public void mkdir(Path dirPath, String dirName) throws MyFileNotFoundException, MyFileAlreadyExistsException {
        Directory<?> dir = getDirectory(dirPath);
        dir.mkdir(dirName);
    }

    //list of files in working directory
    public Set<String> getFilesSet() {
        return getFilesSet(workingDirectoryPath);
    }

    //list of files in directory
    public Set<String> getFilesSet(Path dirPath) {
        try {
            Directory<?> dir = getDirectory(dirPath);
            return dir.getFilesSet();
        } catch (MyFileNotFoundException e) {
            return Collections.emptySet();
        }
    }

    public Set<String> getDirsSet() {
        return getDirsSet(workingDirectoryPath);
    }

    public Set<String> getDirsSet(Path dirPath) {
        try {
            Directory<?> dir = getDirectory(dirPath);
            return dir.getDirsSet();
        } catch (MyFileNotFoundException e) {
            return Collections.emptySet();
        }
    }

    //get working directory
    public Path getWorkingDirectoryPath() {
        return workingDirectoryPath;
    }

    //change working directory
    public void changeDir(String dirName) throws MyFileNotFoundException {
        workingDirectory = workingDirectory.getDir(dirName);
        workingDirectoryPath = workingDirectoryPath.resolve(dirName);
    }

    //change working directory
    public void changeDir(Path dirPath) throws MyFileNotFoundException {
        workingDirectory = getDirectory(dirPath);
        workingDirectoryPath = workingDirectoryPath.resolve(dirPath);
    }


    /** inner  */
    static private class Directory<E> {
        private Map<String, Directory<E>> directories;
        private Map<String, E> files;

        public Directory() {
            directories = new HashMap<>();
            files = new HashMap<>();
        }

        public void recursivePrint(Path prefix) {
            for (Map.Entry<String, Directory<E>> entry : directories.entrySet()) {
                System.out.println("[FOLD]  " + prefix.resolve(entry.getKey()));
                entry.getValue().recursivePrint(prefix.resolve(entry.getKey()));
            }
            for (String s : files.keySet()) {
                System.out.println("[FILE]  " + prefix.resolve(s));
            }
        }

        public E getFile(String fileName) throws MyFileNotFoundException {
            E file = files.get(fileName);
            if (file != null) {
                return file;
            } else {
                throw new MyFileNotFoundException();
            }
        }

        public Directory<E> getDir(String dirName) throws MyFileNotFoundException {
            Directory<E> dir = directories.get(dirName);
            if (dir != null) {
                return dir;
            } else {
                throw new MyFileNotFoundException();
            }
        }

        public Set<String> getDirsSet() {
            return directories.keySet();
        }

        public Set<String> getFilesSet() {
            return files.keySet();
        }

        public void put(String fileName, E file) throws MyFileAlreadyExistsException {
            if (!files.containsKey(fileName)) {
                files.put(fileName, file);
            } else {
                throw new MyFileAlreadyExistsException(fileName);
            }
        }

        public void remove(String fileName) throws MyFileNotFoundException {
            if (files.containsKey(fileName)) {
                files.remove(fileName);
            } else {
                throw new MyFileNotFoundException();
            }
        }

        public void mkdir(String dirName) throws MyFileAlreadyExistsException {
            if (!directories.containsKey(dirName)) {
                directories.put(dirName, new Directory<E>());
            } else {
                throw new MyFileAlreadyExistsException(dirName);
            }
        }
    }

}
