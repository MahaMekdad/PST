package org.example.l1.complexityAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HonestCoach {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0){
            int n = Integer.parseInt(br.readLine());
            int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(a);
            Integer min = null;
            for (int i = 1; i < a.length; i++) {
                if(min == null) min = a[i]-a[i-1];
                else min = Math.min(min, a[i]-a[i-1]);
            }
            System.out.println(min);
        }
    }
}
