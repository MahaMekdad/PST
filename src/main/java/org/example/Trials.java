package org.example;

import java.util.*;

public class Trials {
    public static void main(String[] args) {

        AB ab = new AB("aaa", 1);
        AB ab2 = new AB("bbb", 2);

        List<AB> abList = new ArrayList<>();
        abList.add(ab);
        abList.add(ab2);

        System.out.println(abList.toString());

        int[][] times = new int[3][2];
        times[0][0] = 3;
        times[0][1] = 10;
        times[1][0] = 1;
        times[1][1] = 5;
        times[2][0] = 2;
        times[2][1] = 6;
        System.out.println(smallestChair(times, 0));

//        System.out.println(Character.toUpperCase('P') == Character.toUpperCase('p'));
//        System.out.println(isPalindrome("0P"));
//        Map<Character,Integer> map = new HashMap<>();
//        map.put('s',5);
//        var set = map.entrySet();

//        int[] arr = {1,2,5,2,3,2};
//        int target = 2;
//        Arrays.sort(arr);
//        int index = binarySearch(arr, target);
//        if(index < 0) System.out.println("pew");
//        else{
//            List<Integer> res = new ArrayList<>();
//            for(int i = index; i < arr.length; i++){
//                if(arr[i] != target) break;
//                res.add(arr[i]);
//            }
//            res.forEach(System.out::print);
//        }
//        System.out.println(Arrays.toString(plusOne(arr)));
//        int[] arr2 = {-3,-2,-1,0,0,1,2};
//        System.out.println(findKthPositive(arr2, 9));
//        System.out.println(maximumCount(arr2));
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        Arrays.sort(times, Comparator.comparingDouble(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < times.length; i++) queue.add(i);
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 1;
        for(int i = 0; i < times.length; i++){
            for(var el : map.entrySet()){
                if(el.getKey() <= counter){
                    queue.add(el.getValue());
                    map.remove(el.getKey());
                }
            }
            counter++;
            int chair = queue.poll();
            if(i == targetFriend) return chair;
            map.put(times[i][1], chair);
        }
        return -1;
    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        StringBuilder stb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c >= 0 && c <= 9 || c <= 122 && c >= 97) stb.append(c);
        }
        System.out.println(stb);
        for(int i = 0; i < stb.length()/2; i++) {
            if(stb.charAt(i) != stb.charAt(stb.length()-(i+1))) return false;
        }
        return true;
    }

    public static int maximumCount(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int negEndIndex = binarySearch(nums, -1, set);
        set.add(negEndIndex);
        while(negEndIndex != -1){
            negEndIndex = binarySearch(nums, -1, set);
            set.add(negEndIndex);
        }
        negEndIndex = set.size();
        set.clear();
        int zeroEndIndex = binarySearch(nums, negEndIndex, set);
        set.add(zeroEndIndex);
        while(zeroEndIndex != -1){
            zeroEndIndex = binarySearch(nums, negEndIndex, set);
            set.add(zeroEndIndex);
        }
        negEndIndex = set.size();
        return Math.max(negEndIndex, Math.abs((negEndIndex + zeroEndIndex) - nums.length));
    }

    public static int binarySearch(int[] nums, int beg, Set<Integer> target){
        beg = beg == -1 ? 0: beg;
        int mid = nums.length/2;
        int end = nums.length-1;
        boolean flag = false;
        while(beg <= end){
            if(nums[mid] < 0 && !target.contains(mid)) return mid;
            else if(mid == 0 && nums[mid] < 0 && target.contains(mid)) {
                beg = mid +1;
                flag = true;
            }
            else if(flag || nums[mid] >= 0){
                end = mid -1;
            }
            mid = (beg + end)/2;
        }
        return -1;
    }

    public static int findKthPositive(int[] arr, int k) {
        boolean[] freqArr = new boolean[arr[arr.length-1] + 1];
        for(int i = 0; i < arr.length; i++) freqArr[arr[i]] = true;
        int j = 1;
        int count = 1;
        while(count <= k && j < freqArr.length){
            if(!freqArr[j] && count == k) return j;
            else if(!freqArr[j]) count++;
            j++;
        }
        if(count == 1) return (arr[arr.length-1] + k);
        return (arr[arr.length-1] + k) - count;
    }

    public static int[] plusOne(int[] digits) {
        int[] res = null;
        if(digits[0] == 9){
            res = new int[digits.length+1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i++) res[i+1] = digits[i];
        }
        int i = (res != null) ? res.length-1 : digits.length-1;
        int condition = (res != null) ? 1 : 0;
        return work((res!=null? res : digits), i, condition);
    }

    public static int[] work(int[] digits, int i, int condition){
        int carry = 0;
        for(; i >= condition; i--){
            if(carry != 0 && digits[i] == 9){
                digits[i] = 0;
            } else if(carry != 0 && digits[i] < 9){
                carry = 0;
                int n = digits[i]+1;
                if(n >= 9){
                    carry = 1;
                    digits[i] = 0;
                } else digits[i] = n;
            } else{
                if(digits[i] == 9) {
                    carry = 1;
                    digits[i] = 0;
                }
                else {
                    digits[i] = digits[i]+1;
                    break;
                }
            }
        }
        return digits;
    }
}
