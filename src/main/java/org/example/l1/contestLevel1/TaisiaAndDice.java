package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaisiaAndDice {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int max = nums[1] - nums[2];
            StringBuilder res = new StringBuilder();
            res.append(max).append(" ");
            int quotient = nums[2] / Math.abs(nums[0]-1);
            int remainder = nums[2] % Math.abs(nums[0]-1);
            for(int i = 0; i < Math.abs(nums[0]-1); i++){
                if(remainder > 0)
                    res.append(quotient+1).append(" ");
                else
                    res.append(quotient).append(" ");
                remainder--;
            }
            System.out.println(res);
        }
    }
}
