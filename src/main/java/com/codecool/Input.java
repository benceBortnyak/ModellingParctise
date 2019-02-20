package com.codecool;

import java.util.Scanner;

class Input {
    static int menuIput(){
        UI.displayMenu();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        return n;
    }

    static int subMenuInput() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        return n;

    }
    static int subMenuInput2() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        return n;

    }

    static int subMenuInput3() {
        System.out.println("Enter the id: ");
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        return n;

    }
}
