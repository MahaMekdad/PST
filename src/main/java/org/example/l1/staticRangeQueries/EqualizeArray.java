package org.example.l1.staticRangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EqualizeArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for(int el : a){
            if(map.containsKey(el)) map.put(el, map.get(el)+1);
            else map.put(el, 1);
        }
        var max = map.entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(n - max.get().getValue());
    }
}
