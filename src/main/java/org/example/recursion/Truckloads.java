package org.example.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Truckloads {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            System.out.println(truckLoads(Integer.parseInt((stringTokenizer.nextToken())),
                    Integer.parseInt(stringTokenizer.nextToken())));
        }
    }

    public static int truckLoads(int num, int cap){
        if(num <= cap) return 1;
        else if(num % 2 != 0) return truckLoads( (num/2)+1, cap) + truckLoads(num/2, cap);
        else return truckLoads(num/2, cap) + truckLoads(num/2, cap);
    }
}
