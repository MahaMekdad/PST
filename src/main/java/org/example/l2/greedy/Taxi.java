package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Taxi {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] groups = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freqArr = new int [5];
        for(int child : groups) {
            freqArr[child] = freqArr[child]+1;
        }
        int res = freqArr[4];
        res += freqArr[3];
        freqArr[1] = Math.max((freqArr[1] - freqArr[3]), 0);
        if(freqArr[2] % 2 == 0) res += freqArr[2] / 2;
        else {
            freqArr[2] = (freqArr[2] / 2) + 1;
            res += freqArr[2];
            freqArr[1] = Math.max((freqArr[1] - 2), 0);
        }
        res += Math.ceil(freqArr[1] / 4.0);
        System.out.println(res);
    }
}
