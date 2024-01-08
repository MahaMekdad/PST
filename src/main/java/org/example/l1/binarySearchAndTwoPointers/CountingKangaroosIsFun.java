package org.example.l1.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountingKangaroosIsFun {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int i = 0;
        while(n-- > 0){
            arr[i] = Integer.parseInt(br.readLine());
            i++;
        }
        Arrays.sort(arr);
        n = arr.length;
        int beg = (n - 1) / 2;
        int end = n - 1;
        int added = 0;
        while(beg >= 0 && end > (n - 1) / 2){
            if(arr[end] >= arr[beg] * 2){
                beg--; end--; added++;
            } else beg--;
        }
        System.out.println(n-added);
    }
}
