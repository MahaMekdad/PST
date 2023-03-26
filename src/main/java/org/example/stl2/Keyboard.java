package org.example.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Keyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String sequence = br.readLine();
        Map<Character, String> keyboard = getKeyboard("qwertyuiopasdfghjkl;zxcvbnm,./");
        StringBuilder res = new StringBuilder();
        for(char c : sequence.toCharArray()){
            String[] split = keyboard.get(c).split(":");
            if(n.equals("R")) res.append(split[0]);
            else res.append(split[1]);
        }
        System.out.println(res);
    }

    public static Map<Character, String> getKeyboard(String s){
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(i == 0) map.put(s.charAt(i), s.charAt(i)+":"+s.charAt(i+1));
            else if(i == s.length()-1) map.put(s.charAt(i), s.charAt(i-1)+":"+s.charAt(i));
            else map.put(s.charAt(i), s.charAt(i-1)+":"+s.charAt(i+1));
        }
        return map;
    }
}
