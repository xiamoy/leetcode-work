package com.example.learningnote.array;

/**
 * 栈结构:用数组实现
 */
public class StackOfArrayImplementation {

    public static void main(String[] args) {
        int size = 5;
        case2(size);
        case1(size);
    }

    public static void case1(int size) {
        ArrayStack arrayStack = new ArrayStack(size);
        arrayStack.push("1");
        arrayStack.push("5");
        arrayStack.push("7");
        arrayStack.push("8");
        arrayStack.push("9");
        //should throw exception
        arrayStack.push("10");
    }

    public static void case2(int size) {
        ArrayStack arrayStack = new ArrayStack(size);
        arrayStack.push("1");
        arrayStack.push("5");
        arrayStack.push("7");
        arrayStack.push("8");
        arrayStack.push("9");
        if (!"9".equals(arrayStack.pop())) {
            System.out.println("Oops pop not expected");
        }
        if (!"8".equals(arrayStack.pop())) {
            System.out.println("Oops pop not expected");
        }
        arrayStack.push("13");
        if (!"13".equals(arrayStack.pop())) {
            System.out.println("Oops pop not expected");
        }

    }
}

class ArrayStack {
    String[] arr;
    int size;


    ArrayStack(int size) {
        arr = new String[size];
    }

    public String pop() {
        if (size == 0) {
            throw new IllegalArgumentException("no data to pop");
        }

        return arr[--size];
    }

    public void push(String item) {
        if (size == arr.length) {
            throw new IllegalArgumentException("stack is full");
        }
        arr[size++] = item;
    }
}
