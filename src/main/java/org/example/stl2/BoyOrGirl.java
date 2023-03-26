package org.example.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BoyOrGirl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        Map<Character, Character> map = new HashMap<>();
        int count = 0;
        for(char c : a.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, c);
                count++;
            }
        }
        System.out.println(count % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
    }
}
