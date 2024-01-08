package org.example.l1.contestLevel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CatsAndAMouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            int[] positions = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if(Math.abs(positions[2] - positions[0]) == Math.abs(positions[2] - positions[1])){
                System.out.println("Mouse C");
            }
            else if(Math.abs(positions[2] - positions[0]) < Math.abs(positions[2] - positions[1])){
                System.out.println("Cat A");
            } else{
                System.out.println("Cat B");
            }
        }
    }
}
