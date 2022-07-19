package com.javarush.task.task19.task1927;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(oldOut);

        String s = byteArrayOutputStream.toString();
        String[] spl = s.split("\n");

        for(int i = 0; i < spl.length; i++) {
            if(i%2 == 0&& i != 0){
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(spl[i]);

            }else
            System.out.println(spl[i]);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
