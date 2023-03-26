package org.example.complexityAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReplacingElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0){
            int[] k = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int n = k[0];
            int d = k[1];
            int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            Integer min1 = null, min2 = null;
            for(int el : a){
                if(el > d) count++;
                if(min1 == null || el <= min1){
                    min2 = min1;
                    min1 = el;
                } else if(min2 == null || el < min2){
                    min2 = el;
                }
            }
            if(count == 0 || (min2 != null) && ((min1 + min2) <= d)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
