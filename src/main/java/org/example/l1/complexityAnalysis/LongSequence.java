package org.example.l1.complexityAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long x = Long.parseLong(br.readLine());
        long sum = 0;
        for(int k : a) sum+=k;
        long y = x/sum;
        long count = y * n;
        x-= y * sum;
        for (int j : a) {
            if (x < 0) break;
            x -= j;
            count++;
        }
        System.out.println(count);

    }
}
