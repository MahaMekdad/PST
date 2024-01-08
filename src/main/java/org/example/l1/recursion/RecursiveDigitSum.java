package org.example.l1.recursion;

import java.util.Scanner;

public class RecursiveDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
        System.out.println(recursiveDigitSum(num, k));
    }

    public static String recursiveDigitSum(String num, int k){
        if(num.length() == 1) return num;
        else{
            long sum = 0;
            for(char c : num.toCharArray()) sum += c - '0';
            sum *= k;
            k = 1;
            return recursiveDigitSum(String.valueOf(sum), k);
        }
    }
}
