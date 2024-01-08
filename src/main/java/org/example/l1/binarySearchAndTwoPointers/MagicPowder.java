package org.example.l1.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MagicPowder {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int magicPowder = n[1];
        int[] needed = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] owned = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int beg = 0, end = (int) 2e9, mid = 0, res = 0;
        while(beg <= end){
            mid = beg + ((end - beg)/2);
            if(ok(owned, needed, magicPowder, mid)){
                beg = mid + 1;
                res = mid;
            }
            else end = mid - 1;
        }
        System.out.println(res);
    }

    public static boolean ok(int[] owned, int[] needed, int magicPowder, int target){
        long totalNeededGrams;
        for (int i = 0; i < needed.length; i++) {
            totalNeededGrams = ((long) needed[i] * target);
            if(totalNeededGrams > owned[i]){
                if(magicPowder >= totalNeededGrams - owned[i]) magicPowder -= totalNeededGrams - owned[i];
                else return false;
            }
        }
        return true;
    }
}
