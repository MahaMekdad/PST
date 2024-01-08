package org.example.l1.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        boolean negFlag = false;
        int negNo = 0, posNo = 0, zeroNo = 0;
        StringBuilder neg = new StringBuilder();
        StringBuilder allNeg = new StringBuilder();
        StringBuilder pos = new StringBuilder();
        StringBuilder zero = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 && !negFlag){
                negFlag = true;
                neg.append(nums[i]).append(" ");
            } else if(nums[i] < 0 && negFlag){
                allNeg.append(nums[i]).append(" ");
                negNo++;
            } else if(nums[i] > 0){
                pos.append(nums[i]).append(" ");
                posNo++;
            } else {
                zero.append(nums[i]).append(" ");
                zeroNo++;
            }
        }
        if(pos.isEmpty()){
            String s =allNeg.toString();
            String[] a = s.split(" ");
            pos.append(a[0]).append(" ");
            pos.append(a[1]);
            s = s.replace(a[0], "");
            s = s.replace(a[1], "");
            zero.append(s);
            negNo = negNo - 2;
            posNo = posNo + 2;
        } else {
            zero.append(allNeg);
        }

        System.out.println("1 " + neg + "\n" + posNo + " " + pos + "\n" + Math.abs(negNo + zeroNo) + " " + zero);

    }
}
