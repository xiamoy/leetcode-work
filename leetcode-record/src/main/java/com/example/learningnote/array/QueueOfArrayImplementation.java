package com.example.learningnote.array;


public class QueueOfArrayImplementation {

    public static void main(String[] args) {
        int size = 5;
        case1(size);
        case2(size);
    }

    public static void case1(int size) {
        ArrayQueue arrayQueue = new ArrayQueue(size);
        arrayQueue.push("1");
        arrayQueue.push("5");
        arrayQueue.push("7");
        arrayQueue.push("8");
        arrayQueue.push("9");
        //should throw exception
        arrayQueue.push("10");
    }

    public static void case2(int size) {
        ArrayQueue arrayQueue = new ArrayQueue(size);
        arrayQueue.push("1");
        arrayQueue.push("5");
        arrayQueue.push("7");
        arrayQueue.push("8");
        arrayQueue.push("9");
        String item = arrayQueue.pop();
        if (!item.equals("1")) {
            System.out.println("Oops first pop is not 1");
        }
        if (!arrayQueue.pop().equals("5")) {
            System.out.println("Oops first pop is not 1");
        }
        arrayQueue.push("12");
        arrayQueue.push("15");

    }


}

class ArrayQueue {

    String[] arr;
    int pushIndex;
    int popIndex = -1;
    int curLen;

    ArrayQueue(int size) {
        arr = new String[size];
    }

    public String pop() {
        if (curLen == 0) {
            throw new IllegalArgumentException("can't pop");
        }
        curLen--;
        popIndex = popIndex + 1 < arr.length ? popIndex + 1 : 0;
        return arr[popIndex];

    }

    public void push(String item) {
        if (curLen + 1 > arr.length) {
            throw new IllegalArgumentException("can't push");
        }
        curLen++;
        arr[pushIndex] = item;
        pushIndex = pushIndex + 1 < arr.length ? pushIndex + 1 : 0;
    }

    public boolean isEmpty() {
        return curLen == 0;
    }
}
