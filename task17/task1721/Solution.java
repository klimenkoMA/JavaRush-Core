package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String firstFileName;
        String secondFileName;
        String s, ss;
        try(Scanner scanner = new Scanner(System.in)){
            firstFileName = scanner.nextLine();
            secondFileName = scanner.nextLine();
            try(FileReader fileReader1 = new FileReader(firstFileName);
            FileReader fileReader2 = new FileReader(secondFileName);
            BufferedReader firstReader = new BufferedReader(fileReader1);
            BufferedReader secondReader = new BufferedReader(fileReader2)){
                while((s = firstReader.readLine()) != null){
                    allLines.add(s);

                }
                while((ss = secondReader.readLine()) != null){
                    forRemoveLines.add(ss);

                }
                Solution sol = new Solution();
                sol.joinData();
            }catch(IOException e){/**/}
        }
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
