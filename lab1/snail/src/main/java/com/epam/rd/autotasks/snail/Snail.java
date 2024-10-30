package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();

        if ((a>b) || (a>=h)){
            int day = 1;
            int height =a;
            while (height<h){
                day++;
                height = height + a - b;
            }
            System.out.print(day);
        }else{
            System.out.print("Impossible");
        }

    }
}