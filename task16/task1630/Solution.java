package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
	public static String firstFileName;
	public static String secondFileName;

	//add your code here - добавьте код тут
	static {
		try(Scanner scanner = new Scanner(System.in)) {
			firstFileName = scanner.nextLine();
			secondFileName = scanner.nextLine();
		}
	}

	public static class ReadFileThread extends Thread implements ReadFileInterface{

		private String filename;
		private StringBuilder builder = new StringBuilder();

		@Override
		public void setFileName(String fullFileName) {
			this.filename = fullFileName;
		}

		@Override
		public String getFileContent() {

			return builder.toString();
		}	

		@Override
		public void run() {
			try(FileReader fileReader = new FileReader(filename);
			    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
				String s = bufferedReader.readLine();
				while(s != null) {
					builder.append(s).append(" ");
					s = bufferedReader.readLine();
				}
			} catch(FileNotFoundException fileNotFoundException) {
				fileNotFoundException.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

		public static void main(String[] args) throws InterruptedException {
			systemOutPrintln(firstFileName);
			systemOutPrintln(secondFileName);
		}

		public static void systemOutPrintln(String fileName) throws InterruptedException {
			ReadFileInterface f = new ReadFileThread();
			f.setFileName(fileName);
			f.start();
			f.join();
			//add your code here - добавьте код тут
			System.out.println(f.getFileContent());
		}



		public interface ReadFileInterface {

			void setFileName(String fullFileName);

			String getFileContent();

			void join() throws InterruptedException;

			void start();
		}

		//add your code here - добавьте код тут
	}
