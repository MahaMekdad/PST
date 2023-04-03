package org.example.stl1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCurrent {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        boolean flag = false;
        for (int i = 0; i < n.length()-1; i+=2) {
            if (n.charAt(i) == '-' && n.charAt(i + 1) == '-' ||
                    n.charAt(i) == '+' && n.charAt(i + 1) == '+') {
                flag = true;
                break;
            }
        }
        if(n.length() % 2 != 0 && flag) flag = false;
        System.out.println(flag ? "YES" : "NO");
    }
}
