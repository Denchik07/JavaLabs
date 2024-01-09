package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    public static String decodeVowels(String word) {
        return word.replaceAll("a", "1")
                .replaceAll("e", "2")
                .replaceAll("i", "3")
                .replaceAll("o", "4")
                .replaceAll("u", "5");
    }

    public static String decodeConsonants(String word) {
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder result = new StringBuilder();

        for (char c : word.toCharArray()) {
            char decodedChar = c;
            for (int i = 0; i < consonants.length - 1; i++) {
                if (c == consonants[i]) {
                    decodedChar = consonants[i + 1];
                    break;
                }
            }
            result.append(decodedChar);
        }

        return result.toString();
    }

    public static String decodeMessage(String message) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = message.split("\\s+"); // Розділення за пробілами

        for (String word : words) {
            if (word.matches("^[aeiou]+$")) {
                decodedMessage.append(decodeVowels(word));
            } else {
                decodedMessage.append(decodeConsonants(word));
            }
            decodedMessage.append(" ");
        }

        return decodedMessage.toString().trim(); // Видалення останнього пробілу
    }

    public static void main(String[] args) {
        String encryptedMessage = "h3ll5 w4rld";

        String decodedMessage = decodeMessage(encryptedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}