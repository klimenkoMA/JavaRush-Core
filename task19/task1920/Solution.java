package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Самый
богатый
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String fileName = args[0];

		TreeMap<String, Double> persons = new TreeMap<>();
		try(FileReader fileReader = new FileReader(fileName);
		    BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String s;
			while((s = bufferedReader.readLine()) != null) {
				String[] splat = s.split(" ");
				String name = splat[0];
				double money = Double.parseDouble(splat[1]);
				if(!persons.containsKey(name)) {
					persons.put(name, money);
				} else {
					persons.replace(name, persons.get(name) + money);
				}
			}
			double max = Double.MIN_VALUE;

			StringBuilder result = new StringBuilder();
			for(Map.Entry<String, Double> pair : persons.entrySet()
			) {
				if(pair.getValue() > max) {
					max = pair.getValue();
				}
			}

			for(Map.Entry<String, Double> pair : persons.entrySet()
			) {
				if(pair.getValue() == max) {
					result.append(pair.getKey()).append(" ");
				}
			}
			System.out.println(result);
		}

	}
}
