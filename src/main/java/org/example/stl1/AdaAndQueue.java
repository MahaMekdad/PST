package org.example.stl1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdaAndQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        boolean reversed = false;
        while(n-- > 0){
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            String op = s.nextToken();
            int num = -1;
            if(s.hasMoreTokens()) num = Integer.parseInt(s.nextToken());
            switch (op){
                case "back":
                    if(deque.isEmpty()) res.add("No job for Ada?");
                    else if(!reversed) res.add(deque.removeLast().toString());
                    else res.add(deque.removeFirst().toString());
                    break;
                case "front":
                    if(deque.isEmpty()) res.add("No job for Ada?");
                    else if(reversed) res.add(deque.removeLast().toString());
                    else res.add(deque.removeFirst().toString());
                    break;
                case "reverse":
                    reversed = !reversed;
                    break;
                case "push_back":
                    if(!reversed) deque.addLast(num);
                    else deque.addFirst(num);
                    break;
                case "toFront":
                    if(reversed) deque.addLast(num);
                    else deque.addFirst(num);
                    break;
            }
        }
        StringBuilder s = new StringBuilder();
        res.forEach(e -> s.append(e).append("\n"));
        System.out.println(s);
    }
}
