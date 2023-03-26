package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();
        while(n-- > 0){
            String s = br.readLine();
            String[] split = s.split("\\s");
            switch (split[0]){
                case "1":
                    queue.push(Integer.parseInt(split[1]));
                    break;
                case "2":
                    queue.pop();
                    break;
                case "3":
                    System.out.println(queue.peek());
                    break;
            }
        }
    }
}

class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(popStack.isEmpty()) moveToOtherStack();
        return popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()) moveToOtherStack();
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void moveToOtherStack(){
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }
}
