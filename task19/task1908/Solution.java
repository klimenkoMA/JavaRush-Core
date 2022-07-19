package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String firstFile, secondFile;

		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			firstFile = bufferedReader.readLine();
			secondFile = bufferedReader.readLine();

			try(FileReader fileReader = new FileReader(firstFile);
			    BufferedReader reader = new BufferedReader(fileReader);
			    FileWriter fileWriter = new FileWriter(secondFile);
			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			    StringBuilder oldData = new StringBuilder();

				String s;

				while((s = reader.readLine()) != null){
					oldData.append(s);
				}

				String[] splat = oldData.toString().split(" ");
				for(String number: splat
				) {
					try{
						Integer.parseInt(number);
						bufferedWriter.write(number + " ");
					}catch(NumberFormatException e){/**/}
				}
			}

		}
	}
}
