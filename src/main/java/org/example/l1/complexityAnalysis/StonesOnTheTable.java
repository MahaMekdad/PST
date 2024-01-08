package org.example.l1.complexityAnalysis;

import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if((i + 1) < s.length()){
                if(s.charAt(i) == s.charAt(i+1)) count+=1;
            }
        }
        System.out.println(count);
    }
}
