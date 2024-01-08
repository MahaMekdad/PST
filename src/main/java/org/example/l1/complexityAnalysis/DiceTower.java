package org.example.l1.complexityAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiceTower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] y = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            nums[i] = y;
        }
        System.out.println(x(nums, z) ? "YES" : "NO");
    }

    public static boolean x(int [][] nums, int z){
        for (int[] num : nums) {
            if (num[0] == z || num[0] == 7 - z || num[1] == z || num[1] == 7 - z)
                return false;
        }
        return true;
    }
}
