package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим
 только
  цифры
*/

public class Solution {
	public static TestString testString = new TestString();

	public static void main(String[] args) {
		PrintStream print = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newPrint = new PrintStream(byteArrayOutputStream);
        System.setOut(newPrint);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        result = result.replaceAll("\\D", "");
        System.setOut(print);
        System.out.println(result);

	}

	public static class TestString {
		public void printSomething() {
			System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
		}
	}
}
