package org.example.l1.dynamicMemory;

import org.example.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dragons {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int health = a[0], n = a[1];
        boolean flag = true;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();
        while(n-- > 0){
            int[] dragon = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Pair<>(dragon[0], dragon[1]));
        }
        while(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.poll();
            if(health <= p.getKey()){
                flag = false;
                break;
            } else {
                health += p.getValue();
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) return true;
            Integer[] arr = new Integer [set.size()]; set.toArray(arr);
            for (int j = 0; j < arr.length; j++) {
                if(j == 0 && arr.length > 1) if(arr[j++] - arr[j]  <= valueDiff) return true;
                else if(j == arr.length-1) if(arr[j--] - arr[j] <= valueDiff) return true;
                else if(arr[j++] - arr[j] <= valueDiff || arr[j] - arr[j-1] <= valueDiff) return true;
            }
            set.add(nums[i]);
            if(i >= indexDiff) set.remove(nums[i-indexDiff]);
        }
        return false;
    }
}
