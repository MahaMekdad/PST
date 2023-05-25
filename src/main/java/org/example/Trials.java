package org.example;

import java.util.Arrays;

public class Trials {
    public static void main(String[] args) {
        int[] arr = {8,9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int[] res = null;
        if(digits[0] == 9){
            res = new int[digits.length+1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i++) res[i+1] = digits[i];
        }
        int i = (res != null) ? res.length-1 : digits.length-1;
        int condition = (res != null) ? 1 : 0;
        return work((res!=null? res : digits), i, condition);
    }

    public static int[] work(int[] digits, int i, int condition){
        int carry = 0;
        for(; i >= condition; i--){
            if(carry != 0 && digits[i] == 9){
                digits[i] = 0;
            } else if(carry != 0 && digits[i] < 9){
                carry = 0;
                int n = digits[i]+1;
                if(n >= 9){
                    carry = 1;
                    digits[i] = 0;
                } else digits[i] = n;
            } else{
                if(digits[i] == 9) {
                    carry = 1;
                    digits[i] = 0;
                }
                else {
                    digits[i] = digits[i]+1;
                    break;
                }
            }
        }
        return digits;
    }
}
