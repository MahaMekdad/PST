package org.example.l1.staticRangeQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IlyaAndQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int [] arr = prefixSumArray(s);
        int n = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        while(n-- > 0){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            res.append(arr[n2-1] - arr[n1-1]).append("\n");
        }
        System.out.println(res);
    }

    public static int[] prefixSumArray(String s){
        int [] arr = new int [s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) arr[i] = 1 + arr[i - 1];
            else arr[i] = arr[i-1];
        }
        return arr;
    }
}
