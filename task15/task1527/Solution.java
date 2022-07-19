package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try(Scanner scanner = new Scanner(System.in)){
            String url = scanner.nextLine();
            String[] firstStep = url.split("\\?");
            String[] secondStep = firstStep[1].split("&");
            StringBuilder result = new StringBuilder();
            StringBuilder value = null;
            for(String s: secondStep
                ) {
                String[] finalStep = s.split("=");
                String param = finalStep[0];
                if(!param.equals("obj")) {
                    result.append(param).append(" ");
                }else{
                    result.append(param).append(" ");
                    value = new StringBuilder();
                    value.append(finalStep[1]);
                }
            }
            System.out.println(String.valueOf(result).trim());
            if(value != null) {
                try {
                    alert(Double.parseDouble(value.toString()));
                } catch(Exception e) {
                    alert(value.toString());
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
