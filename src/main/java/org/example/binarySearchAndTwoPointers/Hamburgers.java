package org.example.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hamburgers {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String recipe = br.readLine();
        int[] owned = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] price = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long money = Long.parseLong(br.readLine());
        Map<Character, Integer> ingredientsMap = howManyOfEachIngredient(recipe);
        long beg = 0, end = (long) 1e13, mid = 0, res = 0;
        while(beg <= end){
            mid = beg + ((end - beg)/2);
            if(ok(owned, price, money, mid, ingredientsMap)){
                beg = mid + 1;
                res = mid;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static boolean ok(int[] owned, int[] price, long money, long target, Map<Character, Integer> ingredientsMap){
        int B = ingredientsMap.get('B') != null ? ingredientsMap.get('B') : 0;
        int S = ingredientsMap.get('S') != null ? ingredientsMap.get('S') : 0;
        int C = ingredientsMap.get('C') != null ? ingredientsMap.get('C') : 0;
        long neededB = Math.max(B != 0 ? ((B * target) - owned[0]) * price[0] : 0, 0);
        long neededS = Math.max(S != 0 ? ((S * target) - owned[1]) * price[1] : 0, 0);
        long neededC = Math.max(C != 0 ? ((C * target) - owned[2]) * price[2] : 0, 0);
        return money >= (neededB + neededS + neededC);
    }

    public static Map<Character, Integer> howManyOfEachIngredient(String recipe){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : recipe.toCharArray()){
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        return map;
    }
}
