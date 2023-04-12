package org.example.staticRangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FrequencyArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            br.readLine();
            int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(containsDuplicates(nums));
        }
    }

    public static String containsDuplicates(int [] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)) return "ne krasivo";
        }
        return "prekrasnyy";
    }
}
