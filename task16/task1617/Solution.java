package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 5;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            StringBuilder stringBuilder = new StringBuilder();
            while(!isInterrupted()){
                if(numSeconds > 0) {
                    stringBuilder.append(numSeconds).
                            append(" ");
                    try {
                        Thread.sleep(1000);
                        numSeconds--;
                    } catch(InterruptedException e) {
                        stringBuilder.append("Прервано!");
                        System.out.println(stringBuilder);
                        this.interrupt();
                    }
                }else if(numSeconds == 0){
                    stringBuilder.append("Марш!");
                    System.out.println(stringBuilder);
                    this.interrupt();
                }


            }
        }
    }
}
