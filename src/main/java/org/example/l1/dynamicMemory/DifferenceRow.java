package org.example.l1.dynamicMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DifferenceRow {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        int temp = a[0];
        a[0] = a[a.length-1];
        a[a.length-1] = temp;
        Arrays.stream(a).forEach(e -> System.out.print(e + " "));
    }
}
