/*
Создать программу, которая будет:
1 подсчитывать количество слов в предложении
2 выводить их в отсортированном виде
3 делать первую букву каждого слова заглавной.
Предложение вводится вручную. (Разделитель пробел (“ ”)).
 */

package com.task3;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите предложение");
        String line = in.nextLine();

        int count = 0;

        if(line.length() != 0){
            count++;
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == ' '){
                    count++;
                }
            }
        }

        System.out.println("В предложении " + count + " " + (count>1? (count>2? " слов":" слова") : " слово "));
        in.nextLine();

        in.close();
    }

}