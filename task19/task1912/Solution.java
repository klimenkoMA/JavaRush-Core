package com.javarush.task.task19.task1912;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Ридер
обертка 2
*/

public class Solution {
	public static TestString testString = new TestString();

	public static void main(String[] args) {

		PrintStream oldConsole = System.out;

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(byteArrayOutputStream);
		System.setOut(stream);
		testString.printSomething();
		String result = byteArrayOutputStream.toString().replaceAll("te", "??");
		System.setOut(oldConsole);
        System.out.println(result);
	}

	public static class TestString {
		public void printSomething() {
			System.out.println("it's a text for testing");
		}
	}
}
