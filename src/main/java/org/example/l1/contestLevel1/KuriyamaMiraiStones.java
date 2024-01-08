package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KuriyamaMiraiStones {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] stones = Arrays.stream(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        long[] prefixSum = new long[stones.length+1];
        long[] prefixSumSorted = new long[stones.length+1];
        for(int i = 1; i < prefixSum.length; i++){
            if(i == 1){
                prefixSum[i] = stones[i-1];
                continue;
            }
            prefixSum[i] = prefixSum[i-1] + stones[i-1];
        }
        Arrays.sort(stones);
        for(int i = 1; i < prefixSumSorted.length; i++){
            if(i == 1){
                prefixSumSorted[i] = stones[i-1];
                continue;
            }
            prefixSumSorted[i] = prefixSumSorted[i-1] + stones[i-1];
        }
        int questionsNumbers = Integer.parseInt(br.readLine());
        while(questionsNumbers-- > 0){
            int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(nums[0] == 1){
                System.out.println(prefixSum[nums[2]] - prefixSum[nums[1]-1]);
            } else {
                System.out.println(prefixSumSorted[nums[2]] - prefixSumSorted[nums[1]-1]);
            }
        }

    }
}
