package com.epicode.U5D2;

public class MathTest {
    static public int sum(int a, int b){
        return a + b;
    }

    static public int sum(int[] numbers){
        int sum = 0;
        for(int i = 0; i < numbers.length ; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
