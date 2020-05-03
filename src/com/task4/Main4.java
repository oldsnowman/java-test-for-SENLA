/*
Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
Текст и слово вводится вручную.
 */

package com.task4;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите предложение");
        String yourline = in.nextLine();
        System.out.println("Введите искомое слово");
        String searchword = in.nextLine();
        System.out.println("В предложении слово найдено "+ countWord(yourline,searchword)+" раз");
    }

    public static int countWord(String line, String word) {
        line = line.toLowerCase();
        word = word.toLowerCase();
        int i = line.indexOf(word);
        int count = 0;
        while (i >= 0) {
            count++;
            i = line.indexOf(word, i + 1);
        }
        return count;
    }
}
