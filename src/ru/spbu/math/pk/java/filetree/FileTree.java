package ru.spbu.math.pk.java.filetree;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by dima on 21.11.15.
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

    private Directory<E> getDirectory(Path dirPath) throws FileNotFoundException {
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
    public void put(String fileName, E file) throws FileAlreadyExistsException {
        workingDirectory.put(fileName, file);
    }

    //put file in directory
    public void put(Path dirPath, String fileName, E file) throws FileNotFoundException, FileAlreadyExistsException {
        Directory<E> dir = getDirectory(dirPath);
        dir.put(fileName, file);
    }

    //remove file from working directory
    public void remove(String fileName) throws FileNotFoundException {
        workingDirectory.remove(fileName);
    }

    //remove file from directory
    public void remove(Path dirPath, String fileName) throws FileNotFoundException {
        Directory<?> dir = getDirectory(dirPath);
        dir.remove(fileName);
    }

    //get file in working directory with filename
    public E get(String fileName) throws FileNotFoundException {
        return workingDirectory.getFile(fileName);
    }

    //get file in with filename
    public E get(Path dirPath, String fileName) throws FileNotFoundException {
        Directory<E> dir = getDirectory(dirPath);
        return dir.getFile(fileName);
    }

    //make new directory in working directory
    public void mkdir(String dirName) throws FileAlreadyExistsException {
        workingDirectory.mkdir(dirName);
    }

    //make new directory with name in directory
    public void mkdir(Path dirPath, String dirName) throws FileNotFoundException, FileAlreadyExistsException {
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
        } catch (FileNotFoundException e) {
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
        } catch (FileNotFoundException e) {
            return Collections.emptySet();
        }
    }

    //get working directory
    public Path getWorkingDirectoryPath() {
        return workingDirectoryPath;
    }

    //change working directory
    public void changeDir(String dirName) throws FileNotFoundException {
        workingDirectory = workingDirectory.getDir(dirName);
        workingDirectoryPath = workingDirectoryPath.resolve(dirName);
    }

    //change working directory
    public void changeDir(Path dirPath) throws FileNotFoundException {
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

        public E getFile(String fileName) throws FileNotFoundException {
            E file = files.get(fileName);
            if (file != null) {
                return file;
            } else {
                throw new FileNotFoundException();
            }
        }

        public Directory<E> getDir(String dirName) throws FileNotFoundException {
            Directory<E> dir = directories.get(dirName);
            if (dir != null) {
                return dir;
            } else {
                throw new FileNotFoundException();
            }
        }

        public Set<String> getDirsSet() {
            return directories.keySet();
        }

        public Set<String> getFilesSet() {
            return files.keySet();
        }

        public void put(String fileName, E file) throws FileAlreadyExistsException {
            if (!files.containsKey(fileName)) {
                files.put(fileName, file);
            } else {
                throw new FileAlreadyExistsException(fileName);
            }
        }

        public void remove(String fileName) throws FileNotFoundException {
            if (files.containsKey(fileName)) {
                files.remove(fileName);
            } else {
                throw new FileNotFoundException();
            }
        }

        public void mkdir(String dirName) throws FileAlreadyExistsException {
            if (!directories.containsKey(dirName)) {
                directories.put(dirName, new Directory<E>());
            } else {
                throw new FileAlreadyExistsException(dirName);
            }
        }
    }

}
