package com.codecool.ui;




public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        try {
            start.start();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong");
            System.exit(0);
        }
    }
}
