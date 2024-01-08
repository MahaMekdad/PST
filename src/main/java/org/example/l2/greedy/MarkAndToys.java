package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MarkAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] toysAndAmount = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] prices = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = toysAndAmount[1];
        Arrays.sort(prices);
        long total = 0;
        long res = 0;
        for (int price: prices) {
            if((total + price) > k) break;
            total += price;
            res++;
        }
        System.out.println(res);
    }
}
