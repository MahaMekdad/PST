package org.example.l1.staticRangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CumulativeSumQuery {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int queries = Integer.parseInt(br.readLine());
        prefixSumArray(arr);
        while(queries-- > 0){
            int[] q = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(q[0] == q[1]) System.out.println(arr[q[1]] - arr[q[1]-1]);
            else if(q[0] == 0 && q[1] == arr.length-1) System.out.println(arr[arr.length-1]);
            else if(q[0]-1 < 0) System.out.println(arr[q[1]]);
            else System.out.println(arr[q[1]] - arr[Math.abs(q[0]-1)]);
        }
    }

    public static int[] prefixSumArray(int[] n){
        for (int i = 1; i < n.length; i++) {
            n[i] = n[i] + n[i - 1];
        }
        return n;
    }
}
