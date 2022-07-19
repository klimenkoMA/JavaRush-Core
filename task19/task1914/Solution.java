package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream oldOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(oldOut);
        String[] splat = result.split(" ");
        StringBuilder resString = new StringBuilder();
        int firstNum, secondNum, resultNum;
        firstNum = Integer.parseInt(splat[0]);
        secondNum = Integer.parseInt(splat[2]);
        switch(splat[1]){
            case "+":
                resultNum = firstNum + secondNum;
                resString.append(firstNum).
                        append(" + ").append(secondNum).
                        append(" = ").append(resultNum);
                System.out.println(resString);
                break;
            case "-":
                resultNum = firstNum - secondNum;
                resString.append(firstNum).
                        append(" - ").append(secondNum).
                        append(" = ").append(resultNum);
                System.out.println(resString);
                break;
            case "*":
                resultNum = firstNum * secondNum;
                resString.append(firstNum).
                        append(" * ").append(secondNum).
                        append(" = ").append(resultNum);
                System.out.println(resString);
                break;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

