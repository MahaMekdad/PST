package org.example.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnreadableString {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(unreadableString(s, s.length()-1) ? "Yes" : "No");
    }

    public static boolean unreadableString(String s, int pos){
        if(pos < 0) return true;
        else if((pos+1) % 2 == 0) return Character.isUpperCase(s.charAt(pos)) & unreadableString(s, pos-1);
        else return Character.isLowerCase(s.charAt(pos)) & unreadableString(s, pos-1);
    }
}
