package org.example;


public class PalindromeChecker {

    public static boolean isPalindrome(String word) {
        // Видалння зайвих пробілів і перевод усії символів в нижній регістр
        String cleanedWord = word.replaceAll("\\s+", "").toLowerCase();

        // Перевірка чи слово є паліндромом
        int length = cleanedWord.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedWord.charAt(i) != cleanedWord.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Приклад використання
        String inputWord = "radar";
        if (isPalindrome(inputWord)) {
            System.out.println(inputWord + " - це паліндром.");
        } else {
            System.out.println(inputWord + " - це не паліндром.");
        }
    }
}