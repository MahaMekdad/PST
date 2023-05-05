package org.example.bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            long num = Long.parseLong(br.readLine());
            System.out.println(((1L<<32)-1) ^ num);
        }
    }
}
