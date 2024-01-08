package org.example.l1.complexityAnalysis;

import java.util.Scanner;

public class PalindromeWithLeadingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        System.out.println(isPalindrome(n) ? "Yes" : "No");
    }

    public static boolean isPalindrome(String n){
        if((Integer.parseInt(n)) == 0) return true;
        boolean flag = true;
        StringBuilder s = new StringBuilder(n);
        StringBuilder zeros = new StringBuilder();
        for(int j = 0; j < n.length(); j++) {
            if (n.charAt(j) == '0' && n.charAt(n.length()-j-1) == '0'){
                s.replace(s.length()-1, s.length(), "");
                s.replace(0, 1, "");
            }
            else break;
        }
        if(s.charAt(s.length()-1) == '0'){
            for(int j = s.length()-1; j >= 0; j--)
                if(s.charAt(j) == '0') zeros.append("0");
            if(zeros.length() > 0) n = zeros+n;
        } else if(s.charAt(0) == '0') {
            for(int j = 0; j < s.length(); j++)
                if(s.charAt(j) == '0') zeros.append("0");
            if(zeros.length() > 0) n = n+zeros;
        }

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != n.charAt(n.length()-i-1)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
