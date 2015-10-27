package org.stepic.java.iosamples;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * Created by ִלטענטי on 13.10.2015.
 */
public class HashSumInputStream {
    public static int checkSumOfStream(InputStream inputStream) throws IOException{
        int sum = 0;
        int b = inputStream.read();
        while (b > 0) {
            sum = Integer.rotateLeft(sum, 1) ^ b;
            b = inputStream.read();
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01})));
    }
}
