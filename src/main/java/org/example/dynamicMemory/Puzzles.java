package org.example.dynamicMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Puzzles {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int students = nm[0], noOfPuzzles = nm[1];
        int[] puzzlePieces = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(puzzlePieces);
        int min = 1001, diff = 0;
        if(students == noOfPuzzles) System.out.println(puzzlePieces[puzzlePieces.length-1] - puzzlePieces[0]);
        else {
            for (int i = puzzlePieces.length-1; i >= 0; i--) {
                int index = (i - students) + 1;
                if(index < 0) break;
                else {
                    diff = puzzlePieces[i] - puzzlePieces[index];
                    if(diff < min) min = diff;
                }
            }
            System.out.println(min);
        }
    }
}
