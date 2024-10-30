package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int temp =  scanner.nextInt();
        while (temp!=0){
            if (temp> max )
                max = temp;
            temp = scanner.nextInt();
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(max());
    }
}
