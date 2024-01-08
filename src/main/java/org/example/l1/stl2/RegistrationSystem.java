package org.example.l1.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while(a-- > 0){
            String name = br.readLine();
            if(map.containsKey(name)){
                int count = map.get(name)+1;
                map.put(name, count);
                System.out.println(name+count);
            } else {
                map.put(name, 0);
                System.out.println("OK");
            }
        }
    }
}
