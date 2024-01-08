package com.university.lab_4_1;

public class PalindromeChecker {

    public static boolean isPalindrome(String word) {
        // Прибираємо пробіли і переводимо рядок у нижній регістр
        word = word.replaceAll("\s", "").toLowerCase();

        // Індекси для перевірки паліндрому
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            // Якщо символи на лівому і правому кінцях не співпадають, то це не паліндром
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            // Перевіряємо наступну пару символів
            left++;
            right--;
        }

        // Якщо не виявлено відмінностей, слово є паліндромом
        return true;
    }

    public static void main(String[] args) {
        // Приклади тестів
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("radar")); // true
        System.out.println(isPalindrome("hello")); // false
    }
}