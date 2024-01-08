package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Worms {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int piles = Integer.parseInt(br.readLine());
        int[] worms = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int special = Integer.parseInt(br.readLine());
        int[] specialWorms = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[] ranges = new long [Arrays.stream(worms).sum()+1];
        int res = 1;
        for(int i = 0; i < worms.length; i++){
            if(i == 0)
                res = putTillIndex(ranges, i+1, res, worms[i]);
            else
                res = putTillIndex(ranges, i+1, res, (worms[i] + (res-1)));
        }
        for (int specialWorm : specialWorms) System.out.println(ranges[specialWorm]);
    }

    public static int putTillIndex(long[] ranges, int pileNum, int beg, int end){
        int res = beg;
        for (int i = beg; i <= end ; i++) {
            res++;
            ranges[i] = pileNum;
        }
        return res;
    }
}
