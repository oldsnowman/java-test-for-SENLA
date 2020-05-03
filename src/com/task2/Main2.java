/*
Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.
 */

package com.task2;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String rez="";
        String num1;
        String num2;
        Boolean isInt1=true;
        Boolean isInt2=true;

        do{
            //String rez = "";
            System.out.print("Введите первое число ");
            num1 = in.nextLine().toString();
            System.out.print("Введите второе число ");
            num2 = in.nextLine().toString();

            isInt1 = num1.contains(".");
            isInt2 = num2.contains(".");
            if(isInt1==true && isInt2==true){
                System.out.printf("Внимание ОШИБКА! Одно из чисел дробное! Попробуем еще раз.");
            }
        }
        while (isInt1==true && isInt2==true);

        Long n1 = Long.valueOf(num1);
        Long n2 = Long.valueOf(num2);

        rez="Наибольший общий делитель = " + Long.toString(greatestCommonDivisor(n1,n2)) + "\n";
        rez+="Наименьшее общее кратное = " + Long.toString(leastCommonMultiple(n1,n2));

        System.out.println(rez);

        in.nextLine();

        in.close();
    }

    // Наибольший общий делитель
    public static long greatestCommonDivisor(long a,long b){
        return b == 0 ? a : greatestCommonDivisor(b,a % b);
    }

    // Наименьшее общее кратное
    public static long leastCommonMultiple(long a,long b){
        return a / greatestCommonDivisor(a,b) * b;
    }
}

