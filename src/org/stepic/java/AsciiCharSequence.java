package org.stepic.java;

import java.util.Arrays;

/**
 * Created by ִלטענטי on 30.09.2015.
 */
public class AsciiCharSequence implements CharSequence {
    String seq;
    public AsciiCharSequence(byte[] chars) {
        seq = new String(chars);
    }

    public AsciiCharSequence(String s) {
        seq = new String(s);
    }
    @Override
    public int length() {
        return seq.length();
    }

    @Override
    public char charAt(int index) {
        return seq.charAt(index);
    }

    @Override
    public String toString() {
        return seq;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(seq.substring(start,end));
    }
}
