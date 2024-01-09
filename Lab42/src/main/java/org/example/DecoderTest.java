package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class DecoderTest {

    @Test
    public void testDecodeVowels() {
        assertEquals("h2ll4", Decoder.decodeVowels("hello"));
        assertEquals("w4rld", Decoder.decodeVowels("world"));
        assertEquals("th2 q522n", Decoder.decodeVowels("the queen"));
    }

    @Test
    public void testDecodeConsonants() {
        assertEquals("jov", Decoder.decodeConsonants("hot"));
        assertEquals("iwz", Decoder.decodeConsonants("ivy"));
        assertEquals("qoq", Decoder.decodeConsonants("pop"));
    }

    @Test
    public void testDecodeMessage() {
        assertEquals("jemmo xosmf", Decoder.decodeMessage("hello world"));
        assertEquals("acd", Decoder.decodeMessage("abc"));
        assertEquals("vje rueep't dofe", Decoder.decodeMessage("the queen's code"));
    }
}

