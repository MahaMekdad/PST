package org.example.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveIt {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] nx = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        removeIt(arr, arr.length - 1, nx[1], 0);
        Arrays.stream(arr).forEach(e -> {
            if(e != 0) System.out.print(e + " ");
        });
    }

    public static int[] removeIt(int[] arr, int pos, int x, int count){
        if(pos < 0) return arr;
        else if(arr[pos] == x) arr[pos] = 0;
        return removeIt(arr, pos-1, x, count);
    }
}
