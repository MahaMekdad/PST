package org.example.stl2;

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

            switch (op) {
                case "insert" -> {
                    pq.add(num);
                    res.add("insert " + num);
                }
                case "removeMin" -> {
                    if (pq.size() == 0) {
                        res.add("insert 1");
                        res.add(op);
                    } else {
                        pq.poll();
                        res.add(op);
                    }
                }
                case "getMin" -> {
                    while (pq.size() > 0 && pq.peek() < num) {
                        pq.poll();
                        res.add("removeMin");
                    }
                    if (pq.size() == 0 || pq.peek() > num) {
                        pq.add(num);
                        res.add("insert " + num);
                    }
                    res.add("getMin " + num);
                }
            }
        }
        System.out.println(res.size());
        StringBuilder stringBuilder = new StringBuilder();
        res.forEach(e -> stringBuilder.append(e).append("\n"));
        System.out.println(stringBuilder);
    }
}