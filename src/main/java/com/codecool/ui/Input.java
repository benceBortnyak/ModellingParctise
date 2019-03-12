package com.codecool.ui;

import com.codecool.brain.Kind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {
    static int intInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    static int quitMenuInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    static String autorInPut(){
        System.out.println("Enter the autor : ");
        Scanner scanner = new Scanner(System.in);
            return scanner.next();
    }
    static String titleInPut(){
        System.out.println("Enter the title : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    static int pageInput(){
        System.out.println("Enter the number of pages : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    static String foodKindInPut(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    static String typeInput(){
        System.out.println("Enter the sub genre: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    static List<String> content(){
        List<String> ret = new ArrayList<>();
        System.out.println("For who is this book?\n" +
            "  Press: \n"
        );
        for (int i = 0; i < 3; i++) {
            System.out.println(
            "\t1.adult\n"+
                "\t2.child\n"+
                "\t3.teen\n");
            Scanner scanner = new Scanner(System.in);
            int in = scanner.nextInt();
            if(in == 1){
                ret.add("adult");
            }
            else if(in == 2 ){
                ret.add("child");
            }
            else if(in == 3){
                ret.add("teen");
            }
            else{
                System.out.println("Wrong input");
            }
        }
        return ret;
    }
    static int kindInput(){
        System.out.println("Press:" +
            "1.CITY kind of book"+
            "2.FAIRYTALE kind of book"
        );
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}

