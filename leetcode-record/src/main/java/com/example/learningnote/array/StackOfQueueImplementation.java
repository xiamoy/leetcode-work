package com.example.learningnote.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 栈结构:队列结构实现
 */
public class StackOfQueueImplementation {
    public static void main(String[] args) throws Exception {
        int capacity = 6;
//        Queue<String> stack = new ArrayBlockingQueue<>(capacity);
//        stack.add("1");
//        stack.add("3");
//        stack.add("3");
//        stack.add("5");
//        stack.add("9");
//        stack.add("13");
//        System.out.println(((ArrayBlockingQueue<String>) stack).take());
//        System.out.println(((ArrayBlockingQueue<String>) stack).remove());
//        System.out.println(((ArrayBlockingQueue<String>) stack).peek());
//        System.out.println(((ArrayBlockingQueue<String>) stack).poll());
//        System.out.println(((ArrayBlockingQueue<String>) stack).remainingCapacity());

        StackOfQueueImpl stackOfQueue = new StackOfQueueImpl();
        stackOfQueue.push("1");
        stackOfQueue.push("5");
        stackOfQueue.push("7");
        stackOfQueue.push("9");
        stackOfQueue.push("13");

        if (!"13".equals(stackOfQueue.pop())){
            System.out.println("Oops!");
        }
        if (!"9".equals(stackOfQueue.pop())){
            System.out.println("Oops!");
        }
        stackOfQueue.push("15");
        if (!"15".equals(stackOfQueue.pop())){
            System.out.println("Oops!");
        }
        if (!"7".equals(stackOfQueue.pop())){
            System.out.println("Oops!");
        }

        if (!"5".equals(stackOfQueue.pop())){
            System.out.println("Oops!");
        }
        if (!"1".equals(stackOfQueue.pop())){
            System.out.println("Oops!");
        }

    }
}

class StackOfQueueImpl {
    Queue<String> in;
    Queue<String> out;
    int size = 0;

    public StackOfQueueImpl() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void push(String item) {
        in.add(item);
        size++;
    }

    public String pop() {
        if (size == 0) {
            throw new IllegalArgumentException("no data");
        }

        while (in.size()>1) {
            out.add(in.poll());
        }

        String lastItem = in.poll();
        Queue<String> temp = out;
        out = in;
        in = temp;
        return lastItem;
    }
}
