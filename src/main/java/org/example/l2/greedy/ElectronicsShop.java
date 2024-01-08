package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ElectronicsShop {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] budgetKeyDrives = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] drives = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] keyboards = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int b = budgetKeyDrives[0];
        int[] bigger, smaller;
        if(keyboards.length >= drives.length){
            bigger = keyboards;
            smaller = drives;
        } else {
            bigger = drives;
            smaller = keyboards;
        }
        int res = 0, sum = 0;
        for(int i = 0; i < bigger.length; i++){
            for(int j = 0; j < smaller.length; j++){
                sum = bigger[i] + smaller[j];
                if(sum <= b &&  sum > res) res = sum;
            }
        }
        System.out.println(res == 0 ? -1 : res);
    }
}
