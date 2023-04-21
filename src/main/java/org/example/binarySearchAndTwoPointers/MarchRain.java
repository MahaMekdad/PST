package org.example.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MarchRain {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int[] k = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int noOfHoles = k[0], strips = k[1];
            int[] holes = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int beg = 1, end = holes[holes.length-1], mid = 0, res = 0;
            while(beg <= end){
                mid = beg + ((end - beg)/2);
                if(!ok(holes, mid, strips)){
                    beg = mid + 1;
                }
                else {
                    end = mid - 1;
                    res = mid;
                }
            }
            System.out.println(res);
        }
    }

    public static boolean ok(int[] holes, int target, int strips){
        int lastNum = 0;
        for(int hole : holes){
            if(hole > lastNum && strips == 0) return false;
            else if(hole > lastNum){
                lastNum = (hole + target) - 1;
                strips--;
            }
        }
        return true;
    }
}
