package org.example.dynamicMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Slot {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        char c = n.charAt(0);
        boolean flag = true;
        for(char ch : n.toCharArray()){
            if(ch != c){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Won" : "Lost");
    }
}
