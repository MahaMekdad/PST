package org.example.l1.stl2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Potions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] portions = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long health = 0;
        for (int portion : portions) {
            queue.add(portion);
            health += portion;
            if (health < 0) {
                health -= queue.peek();
                queue.poll();
            }
        }
        System.out.println(queue.size());
    }
}
