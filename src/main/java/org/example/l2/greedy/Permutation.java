package org.example.l2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] elements = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freqArr = new int [n+1];
        int changesCounter = 0;
        int res = 0;
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] >= freqArr.length){
                changesCounter++;
                continue;
            }
            if(freqArr[elements[i]] >= 1) {
                changesCounter++;
            }
            freqArr[elements[i]] = freqArr[elements[i]]+1;
        }
        for (int i = 1; i < freqArr.length; i++) {
            if(freqArr[i] == 0) {
                changesCounter--;
                res++;
            }
        }
        System.out.println(res);
    }
}
