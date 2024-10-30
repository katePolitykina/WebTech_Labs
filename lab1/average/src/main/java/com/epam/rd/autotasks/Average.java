package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        int sum=0;
        int count = 0;
        while (nextInt != 0){
           sum += nextInt;
           count ++;
           nextInt = scanner.nextInt();
        }
        sum/=count;
        System.out.print(sum);
    }

}