package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualizePricesAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int numOfGoods = Integer.parseInt(br.readLine());
            int[] prices = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            long total = totalPrices(prices);
            long beg = 0, end = total, mid = 0, res = Integer.MAX_VALUE;
            while(beg <= end){
                mid = beg + ((end - beg)/2);
                if((mid* numOfGoods) < total){
                    beg = mid + 1;
                }
                else{
                    end = mid - 1;
                    res = mid;
                }
            }
            System.out.println(res);
        }
    }

    public static long totalPrices(int[] prices){
        return Arrays.stream(prices).sum();
    }
}
