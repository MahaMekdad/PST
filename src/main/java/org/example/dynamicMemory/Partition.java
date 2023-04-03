package org.example.dynamicMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Partition {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bSum = 0, cSum = 0;
        for(int num : nums){
            if(num < 0) bSum += num;
            else cSum += num;
        }
        System.out.println(Math.abs(bSum - cSum));
    }
}
