package org.example.l1.stl2;

import org.example.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Berpizza {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        int customers = 0;
        int nextCustomer = 1;
        Set<Integer> served = new HashSet<>();
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Collections.reverseOrder());
        while(q-- > 0){
            int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(a[0] == 1){
                Pair<Integer, Integer> pair = new Pair<>(a[1], -(++customers));
                queue.add(pair);
            } else if (a[0] == 2){
                while(served.contains(nextCustomer)) nextCustomer++;
                System.out.println(nextCustomer);
                served.add(nextCustomer);
                nextCustomer++;
            } else {
                while(!queue.isEmpty() && served.contains(-(queue.peek().getValue()))) queue.poll();
                if(!queue.isEmpty()){
                    System.out.println(-(queue.peek().getValue()));
                    served.add(-(queue.peek().getValue()));
                    queue.poll();
                }
            }
        }
    }
}
