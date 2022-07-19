package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldConsole = System.out;

        ByteArrayOutputStream byteArr = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArr);
        System.setOut(stream);
        testString.printSomething();
        String result = byteArr.toString().toUpperCase(Locale.ROOT);
        System.setOut(oldConsole);
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
