package org.stepic.java.iosamples.endlines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ִלטענטי on 13.10.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        InputStream inputStream = System.in; //new ByteArrayInputStream(new byte[] {123, 0, 13, 10, 10, 13});
        int prevB = -1;
        int b = inputStream.read();
        while (b >= 0) {
            if (prevB == '\r' && b != '\n') {
                System.out.write('\r');
            }
            if (b != '\r') {
                System.out.write(b);
            }

            prevB = b;
            b = inputStream.read();
        }
        if (prevB == '\r') {
            System.out.write('\r');
        }
        System.out.flush();
    }
}
