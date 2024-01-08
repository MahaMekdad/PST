package org.example.l1.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChatOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        while(n-- > 0){
            String s = br.readLine();
            deque.addLast(s);
        }
        while(!deque.isEmpty()){
            if(map.containsKey(deque.peekLast())) deque.removeLast();
            else {
                String s = deque.removeLast();
                map.put(s, 1);
                System.out.println(s);
            }
        }
    }
}
