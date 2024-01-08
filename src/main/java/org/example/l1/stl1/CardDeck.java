package org.example.l1.stl1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CardDeck {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            int k = Integer.parseInt(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] values = new int[nums.length+1];
            int[] index = new int[nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                index[nums[i]] = i+1;
                values[i+1] = nums[i];
            }
            StringBuilder res = new StringBuilder();
            Map<Integer, Boolean> visited = new HashMap<>();
            for (int j = index.length-1; j > 0 ; j--) {
                res.append(getCardDeck(visited, values, index[j]));
            }
            System.out.println(res);
        }
    }

    public static StringBuilder getCardDeck(Map<Integer, Boolean> visited, int[] values, int index){
        StringBuilder res = new StringBuilder();
        for (int i = index; i < values.length; i++) {
            if(visited.get(values[i]) == null) {
                res.append(values[i]).append(" ");
                visited.put(values[i], true);
            } else break;
        }
        return res;
    }
}
