package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyFlorist {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] noOfFlowersNCustomers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = noOfFlowersNCustomers[0];
        int k = noOfFlowersNCustomers[1];
        int[] flowerPrices = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(flowerPrices);
        long sum = 0;
        if(n == k || k > n) {
            for(int price : flowerPrices)
                sum += price;
            System.out.println(sum);
        } else {
            int i = flowerPrices.length-1;
            for (int c = 1; c <= k; c++) {
                sum += flowerPrices[i];
                i--;
            }
            int currPurchases = 1;
            int noOfCustomers = k;
            for(; i >= 0; i--) {
                if(noOfCustomers == 0) {
                    currPurchases++;
                    noOfCustomers = k;
                }
                sum += (long) (currPurchases + 1) * flowerPrices[i];
                noOfCustomers--;
            }
            System.out.println(sum);
        }

    }
}
