package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DoNotBeDistracted {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            int days = Integer.parseInt(br.readLine());
            String tasks = br.readLine();
            Map<Character, Boolean> map = new HashMap<>();
            boolean res = true;
            for (int i = 0; i < tasks.length(); i++) {
                if(i == 0){
                    map.put(tasks.charAt(i), true);
                }
                else if(tasks.charAt(i) != tasks.charAt(i-1)){
                    if(map.containsKey(tasks.charAt(i))){
                        System.out.println("no");
                        res = false;
                        break;
                    } else {
                        map.put(tasks.charAt(i), true);
                    }
                } else {
                    map.put(tasks.charAt(i), true);
                }
            }
            if(res) System.out.println("yes");
        }
    }
}
