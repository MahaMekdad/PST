package org.example.l1.bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGreatXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        long q = Long.parseLong(br.readLine());
        while(q-- > 0){
            long n = Long.parseLong(br.readLine());
            long res = 0;
            for (int i = 0; (1L<<i) <= n ; i++)
                if(((n>>i) & 1) == 0) res += (1L<<i);
            System.out.println(res);
        }
    }
}

/*
 n=   101101
 x=      ?
      ------
 res=  res>n
      101100
      101101

      110000
      111000
      110100
      110010
      110001
      .
      .
      etc
 */
