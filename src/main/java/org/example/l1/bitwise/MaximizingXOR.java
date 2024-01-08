package org.example.l1.bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximizingXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        int res = 0;
        for(int i = l; i <= r; i++){
            for(int j = l; j <= r; j++){
                res = Math.max(i ^ j, res);
            }
        }
        System.out.println(res);
    }
}


/*
    public static int maximizingXor(int l, int r) {
        int or=l;int and=l;
        for(int i=l+1;i<=r;i++)
        {
            or|=i;
            and&=i;
        }
        return or^and;
    }
*/
