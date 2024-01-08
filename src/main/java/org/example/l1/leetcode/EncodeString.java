package org.example.l1.leetcode;

import java.util.Stack;

public class EncodeString {
    public static void main(String[] args) {
        System.out.println(first("3[z]2[2[y]pq4[2[jk]e1[f]]]ef", 0, false));
//        System.out.println(helper("3[a]2[bc]", 0, new StringBuilder()));
    }

    public static String first(String s, int i, boolean nested){
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            if(Character.isDigit(s.charAt(j))){
                int k = s.charAt(j) - '0';
                if(Character.isDigit(s.charAt(j+1))){
                    k = Integer.parseInt((s.charAt(j) + String.valueOf(s.charAt(j+1))));
                    j++;
                }
                if(Character.isDigit(s.charAt(j+1))){
                    j--;
                    k = Integer.parseInt((s.charAt(j) + String.valueOf(s.charAt(j+1)) + s.charAt(j+2)));
                    j = j+2;
                }
                Stack<String> returnedStack = second(j+1, s);
                j = Integer.parseInt(returnedStack.lastElement());
                returnedStack.removeElement(returnedStack.lastElement());
                StringBuilder sb2 = new StringBuilder();
                while(!returnedStack.isEmpty()){
                    sb2.append(returnedStack.pop());
                }
                sb2.reverse();
                while(k-- > 0) sb.append(sb2);
            } else if(s.charAt(j) == ']' && nested) break;
            else if(s.charAt(j) != ']' && s.charAt(j) != '[') sb.append(s.charAt(j));
        }
        return sb.toString();
    }

    public static Stack<String> second(int beg, String s){
        Stack<String> stack = new Stack<>();
        while(beg < s.length()){
            if(Character.isDigit(s.charAt(beg))){
                String st = first(s, beg, true);
                for (int j = 0; j < st.length(); j++) {
                    stack.push(String.valueOf(st.charAt(j)));
                    beg++;
                }
                for(int k = beg; beg < s.length(); k++) {
                    if(s.charAt(k) != ']') break;
                    else beg++;
                }
                stack.push(String.valueOf(beg));
                return stack;
            } else if(s.charAt(beg) == '[') {
                beg++;
                continue;
            }
            else if(s.charAt(beg) == ']') {
                stack.push(String.valueOf(beg));
                return stack;
            }
            else stack.push(String.valueOf(s.charAt(beg)));
            beg++;
        }
        return stack;
    }

    public static StringBuilder helper(String s, int i, StringBuilder sb){
        if(i == s.length()-1 && s.charAt(i) != ']') return sb.append(s.charAt(i));
        if(i == s.length()-1 && s.charAt(i) == ']') return sb;
        if(s.charAt(i) == ']') return sb;
        if(Character.isDigit(s.charAt(i))){
            int k = s.charAt(i) - '0';
            int j = i+2;
            while(k-- > 0){
                sb.append(helper(s, j, sb));
            }
            return sb.append(helper(s, ++j, sb));
        } else return sb.append(s.charAt(i)).append(helper(s, ++i, sb));
    }
}
