package org.stepic.java.iosamples;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by Дмитрий on 13.10.2015.
 */
public class GetCharBytes {
    public static void main(String[] args) {
        //InputStream inputStream = "?".getBytes(StandardCharsets.UTF_8);
        //Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        byte[] bytes = "ы".getBytes(StandardCharsets.UTF_8);

        System.out.println("ы");
    }
}
