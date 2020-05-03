/*
Создать программу, которая в последовательности от 0 до N,
находит все числа-палиндромы (зеркальное значение равно оригинальному).
Длина последовательности N вводится вручную и не должна превышать 100.
*/

package com.task5;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите верхнюю границу диапозона, который будет начинаться с 0, но не привышать 100 ");
        String num;
        int N;
        do{
            num = in.nextLine();
            N = Integer.valueOf(num);
            if (N>100){
                System.out.println("Число должно быть не больше 100. Попробуем еще!");
            }
        }
        while(N>100);
        String rez="Числа палиндромы: ";
        for (int i = 0; i <= N; i++) {
            rez += GetPalindrome(i) == 1 ? i+" " : "";
        }
        System.out.println(rez);
    }
    public static int GetPalindrome(int palind)
    {
        int next = 0;
        int pal = palind;

        while (pal != 0){
            next = (next * 10) + (pal % 10);
            pal /= 10;
        }

        if (palind == next){
            return 1;
        }
        else{
            return 0;
        }
    }

}