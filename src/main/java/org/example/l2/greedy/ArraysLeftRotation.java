package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraysLeftRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] sizeAndRotationsNo = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] items = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rotations = sizeAndRotationsNo[1];
        StringBuilder res = new StringBuilder();
        if(rotations == items.length) {
            for (int i = 1; i < items.length; i++) {
                res.append(items[i]).append(" ");
            }
            res.append(items[0]);
        } else if(rotations > items.length) {
            int start = Math.abs(rotations-items.length);
            for(int i = start; i < items.length; i++) {
                res.append(items[i]).append(" ");
            }
            for(int i = 0; i < start; i++) {
                res.append(items[i]).append(" ");
            }
        } else {
            for(int i = rotations; i < items.length; i++) {
                res.append(items[i]).append(" ");
            }
            for(int i = 0; i < rotations; i++) {
                res.append(items[i]).append(" ");
            }
        }
        System.out.println(res);
    }
}
