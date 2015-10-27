package org.stepic.java.iosamples;

import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by ִלטענטי on 15.10.2015.
 */
public class Converter {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();
        int a = reader.read();
        while (a > 0) {
            stringBuilder.append((char)a);
            a = reader.read();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
