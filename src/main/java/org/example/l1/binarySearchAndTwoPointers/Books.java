package org.example.l1.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Books {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long nBooks = a[0];
        int totalFreeMins = a[1];
        int[] minsToReadEachBook = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long beg = 0, end = nBooks, mid = 0, res = 0;
        while(beg <= end){
            mid = beg + ((end - beg)/2);
            if(ok(minsToReadEachBook, mid, totalFreeMins)){
                beg = mid + 1;
                res = mid;
            }
            else end = mid - 1;
        }
        System.out.println(res);
    }

    public static boolean ok(int[] minsToReadEachBook, long target, int totalFreeMins){
        int i = 0;
        for(int minBook : minsToReadEachBook){
            totalFreeMins -= minBook;
            if(totalFreeMins >= 0) target--;
            else {
                totalFreeMins += minsToReadEachBook[i];
                i++;
            }
        }
        return target <= 0;
    }
}
