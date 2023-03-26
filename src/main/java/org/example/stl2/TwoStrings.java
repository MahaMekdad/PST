package org.example.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Map<Character, Character> map = new HashMap<>();
        boolean flag = false;
        while(a-- > 0){
            String s1 = br.readLine();
            String s2 = br.readLine();
            for(char c : s1.toCharArray()){
                if(!map.containsKey(c)) map.put(c, c);
            }
            for(char c : s2.toCharArray()){
                if(map.containsKey(c)){
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");
            flag = false;
            map.clear();
        }
    }
}
