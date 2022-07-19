package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
	public static void main(String[] args) {
		// напишите тут ваш код
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		    FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
		    Scanner scanner = new Scanner(fileInputStream)) {

			ArrayList<Integer> evenList = new ArrayList<>();
			int a;
			while(scanner.hasNextInt()) {
				a = scanner.nextInt();
				if(a % 2 == 0) {
					evenList.add(a);
				}
			}
			evenList.stream().sorted().forEach(System.out::println);


		} catch(Exception e) {/**/}
	}
}
