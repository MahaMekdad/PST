package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ANDSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int k = Integer.parseInt(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Integer res = null;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != i) {
                    if(res == null) res = i;
                    else res = res & i;
                }
            }
            System.out.println(res);
        }
    }
}
