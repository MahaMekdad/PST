package org.example.bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XORwice {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int[] no = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(no[0] ^ no[1]);
        }
    }
}
