package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {

    public static class AgathaChristieBook extends Book{
        private String title;

        public AgathaChristieBook(String bookTitle) {

            super("Agatha Christie");
            this.title = bookTitle;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static class MarkTwainBook extends Book{

        private String title;

        public MarkTwainBook(String bookTitle) {
            super("Mark Twain");
            this.title = bookTitle;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            //Add your code here
            switch(author){
                case "Mark Twain":
                    output = markTwainOutput;
                    break;
                case "Agatha Christie":
                    output = agathaChristieOutput;
                    break;
            }

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }
}
