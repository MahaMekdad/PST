package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HeapOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<String> res = new ArrayList<>();
        while(n-- > 0){
            String op = "";
            int num = -1;
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            op = stringTokenizer.nextToken();
            if(stringTokenizer.hasMoreTokens()) num = Integer.parseInt(stringTokenizer.nextToken());

            if(op.equals("insert")){
                pq.add(num);
                res.add("insert " + num);
            } else if(op.equals("removeMin")){
                Integer p = pq.poll();
                if(p != null){
                    res.add(op);
                } else if(res.size() == 0){
                    res.add("insert 0");
                    res.add(op);
                } else {
                    res.add(op);
                }
            } else {
                Integer p = pq.peek();
                if(p != null && p < num){
                    while(p != null && p < num) {
                        p = pq.poll();
                        if(p != null) res.add("removeMin");
                    }
                    res.add("insert " + num);
                    res.add("getMin " + num);
                } else if(p == null){
                    res.add("insert " + num);
                    res.add(op + " " + num);
                } else if(p == num){
                    res.add(op + " " + num);
                } else {
                    res.add("insert " + num);
                    res.add(op + " " + num);
                }
            }
        }
        System.out.println(res.size());
        res.forEach(System.out::println);
    }
}