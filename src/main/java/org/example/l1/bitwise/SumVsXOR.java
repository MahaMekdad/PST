package org.example.l1.bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumVsXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if(n == 0){
            System.out.println(1);
            return;
        }
        String binary = Long.toBinaryString(n);
        long zeros = binary.length() - Long.bitCount(n);
        System.out.println(1L<<zeros);
    }
}
