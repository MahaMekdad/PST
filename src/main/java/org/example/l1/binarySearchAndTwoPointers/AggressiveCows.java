package org.example.l1.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int[] no = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int stallsNum = no[0], cows = no[1], i = 0;
            int[] stalls = new int[stallsNum];
            while(stallsNum-- > 0){
                stalls[i] = Integer.parseInt(br.readLine());
                i++;
            }
            Arrays.sort(stalls);
            int beg = 1, end = stalls[i-1], mid = 0, res = 1;
            while(beg <= end){
                mid = beg + ((end - beg)/2);
                if(ok(stalls, mid, cows)){
                    beg = mid + 1;
                    res = mid;
                }
                else end = mid - 1;
            }
            System.out.println(res);
        }
    }

    public static boolean ok(int[] stalls, int target, int cows){
        int lastCoveredLocation = -1;
        for(int stall : stalls){
            if(stall > lastCoveredLocation){
                cows--;
                lastCoveredLocation = (target + stall) - 1;
            }
        }
        return cows <= 0;
    }
}
