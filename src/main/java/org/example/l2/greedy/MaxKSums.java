package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxKSums {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] noOfElementsNMaxKValue = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = noOfElementsNMaxKValue[1];
        int[] elements = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            int sumOfElements = 0;
            for (int j = i; j < elements.length; j++) {
                sumOfElements += elements[j];
                queue.add(sumOfElements);
            }
        }
        while(k-- > 0) {
            res.append(queue.poll()).append(" ");
        }
        System.out.println(res);
    }
}