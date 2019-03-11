package com.codecool.ui;

import java.util.Scanner;

public class Input {
    protected static int menuInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    protected static int quitMenuInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
