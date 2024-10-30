package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {

    public static void main(String[] args) {
        int secInHour = 3600;
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hours = seconds / secInHour;
        hours = hours % 24;
        seconds %= secInHour;
        int minuts = seconds/ 60;
        seconds %= 60;
        System.out.printf("%d:%02d:%02d", hours,minuts,seconds);
    }
}
