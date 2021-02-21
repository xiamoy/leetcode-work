package com.example.learningnote.array;

import java.util.Stack;

/**
 * 队列结构:栈结构实现
 */
public class QueueOfStackImplementation {
    public static void main(String[] args) {
        QueueOfStackImpl queueOfStack = new QueueOfStackImpl();

        queueOfStack.push("1");
        if (!"1".equals(queueOfStack.pop())) {
            System.out.println("Oops");
        }
        queueOfStack.push("1");
        queueOfStack.push("5");
        queueOfStack.push("7");
        queueOfStack.push("8");
        queueOfStack.push("9");

        if (!"1".equals(queueOfStack.pop())) {
            System.out.println("Oops");
        }
        queueOfStack.push("13");
        if (!"5".equals(queueOfStack.pop())) {
            System.out.println("Oops");
        }
        if (!"7".equals(queueOfStack.pop())) {
            System.out.println("Oops");
        }
    }
}

class QueueOfStackImpl {
    Stack<String> in;
    Stack<String> out;
    int size = 0;

    QueueOfStackImpl() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(String item) {
        size++;
        in.push(item);
    }

    public String pop() {
        if (size == 0) {
            throw new IllegalArgumentException("no data");
        }
        if(out.isEmpty()){
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        size--;
        return out.pop();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
