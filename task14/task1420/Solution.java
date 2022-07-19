package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int first = Integer.parseInt(reader.readLine());
            int second = Integer.parseInt(reader.readLine());
            if(first < 1 || second < 1){
                throw new IllegalArgumentException();
            }else{
                while (first != second) {
                    if (first > second) {
                        first -= second;
                    }
                    if (second > first) {
                        second -= first;
                    }
                }
                System.out.println(first);
            }
    }
}
