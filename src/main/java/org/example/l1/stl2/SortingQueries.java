package org.example.l1.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortingQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(q-- > 0) {
            int[] query = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (query[0]){
                case 1:
                    deque.addLast(query[1]);
                    break;
                case 2:
                    if(queue.isEmpty()){
                        queue.add(deque.peekFirst());
                        deque.removeFirst();
                    }
                    System.out.println(queue.poll());
                    break;
                case 3:
                    while(!deque.isEmpty()) queue.add(deque.remove());
                    break;
            }
        }
    }
}
