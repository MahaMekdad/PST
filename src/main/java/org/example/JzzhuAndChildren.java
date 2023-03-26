package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JzzhuAndChildren {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = a[0], m = a[1];
        int[] kids = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int res = 0;
        int max = 0;

        for (int i = 0; i < kids.length; i++) {
            int rounds = howManyTimesTillReachesZero(m, kids[i]);
            if(rounds >= max){
                max = rounds;
                res = i+1;
            }
        }
        System.out.println(res);
    }

    public static int howManyTimesTillReachesZero(int m, int el){
        int count = 0;
        while(el > 0){
            count++;
            el -= m;
        }
        return count;
    }
}
