/*
Задание 1
Создать программу, которая будет сообщать, является ли целое число,
введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.
*/

package com.task1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Введите число: ");
        String rez = "Число ";
        Scanner in = new Scanner(System.in);
        String num = in.nextLine().toString();
        Boolean isFractional = num.contains(".");

        if (isFractional){
            System.out.printf("Внимание! Число дробное!");
        }
        else {
            Integer intVal = Integer.valueOf(num);

            rez += num;
            rez += " недробное,";

            if (intVal % 2 == 0) {
                rez += " четное,";
            }
            else {
                rez += " нечетное,";
            }

            Boolean isPrime=true;
            for (int i=2; i<=intVal/2; i++) {
                Integer temp = intVal % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                rez += " простое";
            }
            else { rez+=" составное"; }
        }

        System.out.print(rez.toString());

        in.nextLine();

        in.close();
    }
}
