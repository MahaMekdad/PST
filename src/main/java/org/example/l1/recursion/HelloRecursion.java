package org.example.l1.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HelloRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i = 1;
        while(t-- > 0){
            int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            arr[0] = 0;
            System.out.println("Case " + i + ": " + recursionSum(arr, arr.length-1));
            i++;
        }
    }

    public static int recursionSum(int[] arr, int pos){
        if(pos < 0) return 0;
        return arr[pos] + recursionSum(arr, pos-1);
    }
}
