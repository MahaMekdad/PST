package org.example.l1.complexityAnalysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+') continue;
            if(map.containsKey(s.charAt(i) - '0')){
                map.put(s.charAt(i) - '0', map.get(s.charAt(i) - '0') + 1);
            } else {
                map.put(s.charAt(i) - '0', 1);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= 3; i++){
            if(map.containsKey(i)){
                res.append((i+"+").repeat(Math.max(0, map.get(i))));
            }
        }
        if(res.charAt(res.length()-1) == '+') res.replace(res.length()-1, res.length(), "");
        System.out.println(res);
    }
}
