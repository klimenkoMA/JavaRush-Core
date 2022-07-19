package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
//        args = new String[1];
        int id = Integer.parseInt(args[0]);
        ArrayList<String> dataList = new ArrayList<>();

        try(Scanner scanner = new Scanner(System.in)){
            fileName = scanner.nextLine();

            try(FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader)){
                String s;
                while((s = reader.readLine()) != null){
                    dataList.add(s);

                }

                for(String data: dataList
                    ) {
                    String[] splitData = data.split(" ");
                    if(id == Integer.parseInt(splitData[0])){
                        System.out.println(data);
                    }
                }

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
