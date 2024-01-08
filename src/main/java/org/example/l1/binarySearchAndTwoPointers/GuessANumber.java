package org.example.l1.binarySearchAndTwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessANumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int beg = (int) -2e9; int end = (int) 2e9;
        while(n-- > 0){
            String[] k = br.readLine().split("\\s+");
            String op = k[0];
            int x = Integer.parseInt(k[1]);
            String ans = k[2];
            switch (op.charAt(0)){
                case '>':
                    if(ans.equals("Y")){
                        if(op.length() == 2) {
                            if(beg <= x) beg = x;
                        }
                        else if(op.length() == 1) {
                            if(beg <= x) beg = x + 1;
                        }
                    } else {
                        if(op.length() == 2) {
                            if(end >= x) end = x - 1;
                        }
                        else if(op.length() == 1){
                            if(end >= x) end = x;
                        }
                    }
                    break;
                case '<':
                    if(ans.equals("Y")){
                        if(op.length() == 2){
                            if(end >= x) end = x;
                        }
                        else if(op.length() == 1) {
                            if(end >= x) end = x - 1;
                        }
                    } else {
                        if(op.length() == 2) {
                            if(beg <= x) beg = x + 1;
                        }
                        else if(op.length() == 1){
                            if(beg <= x) beg = x;
                        }
                    }
                    break;
            }
        }
        System.out.println(beg > end ? "Impossible" : beg);
    }
}
