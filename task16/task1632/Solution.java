package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            while(true){

            }
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            try{
               Thread.sleep(5000);
            }catch(InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            while (!isInterrupted()) {
            }

        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }
    static class Thread5 extends Thread{
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            while (true) {
                try {
                    String str = reader.readLine();
                    if (str.equals("N"))
                        break;
                    sum += Integer.parseInt(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
            System.out.print(sum);
        }
    }
}