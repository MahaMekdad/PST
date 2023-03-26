package org.example.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class AntonAndLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letters = br.readLine();
        Set<Character> set = new HashSet<>();
        for(char c : letters.toCharArray()){
            if(c == '{' || c == '}' || c == ' ' || c == ',') continue;
            else set.add(c);
        }
        System.out.println(set.size());
    }
}
