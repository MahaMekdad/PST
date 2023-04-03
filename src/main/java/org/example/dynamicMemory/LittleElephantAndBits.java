package org.example.dynamicMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleElephantAndBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        Long min = null;
        String res = "";
        StringBuilder s;
        for (int i = num.length()-1; i >= 0; i--) {
            s = new StringBuilder(num);
            s.deleteCharAt(i);
            Long val = Long.parseLong(s.toString(), 2);
            if(min == null || min < val){
                min = val;
                res = s.toString();
            }
        }
        System.out.println(res);
    }
}
