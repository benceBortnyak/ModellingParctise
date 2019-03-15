package com.codecool.ui;


import java.util.*;

class Input {
    private static Scanner scanner = new Scanner(System.in);
    static int intInput(){
        return scanner.nextInt();
    }
    static int quitMenuInput(){
        return scanner.nextInt();
    }
    static String autorInPut(){
        System.out.println("Enter the autor : ");
            return scanner.next();
    }
    static String titleInPut(){
        System.out.println("Enter the title : ");
        return scanner.next();
    }
    static int pageInput(){
        int n;
        System.out.println("Enter the number of pages : ");
        try {
            n = scanner.nextInt();
        }catch (InputMismatchException e ){
            System.out.println("Wrong input try again");
            n = scanner.nextInt();
        }
        return n;
    }
    static String foodKindInPut(){
        System.out.println("Which kind of recipes are in the book? ");
        return scanner.next();
    }
    static String typeInput(){
        System.out.println("Enter the sub genre: ");
        return scanner.next();
    }
    static List<String> content() throws InputMismatchException{
        List<String> list = new ArrayList<>(Arrays.asList("teen","adult","child"));
        List<String> retList = new ArrayList<>();
        System.out.println("For who is this book?\n");
        while(list.size()>0) {
            System.out.println("If you added everything what you wanted press 0" +
                "  Press:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + list.get(i));

            }
            int in = scanner.nextInt();
            if (in > list.size()) {
                System.out.println("Wrong input");

            } else if (in == 0) {
                return retList;
            }
            else if(in<3 && in>0) {
                String string = list.remove(in-1);
                retList.add(string);
            }
        }
        return retList;
    }
    static int kindInput() throws InputMismatchException{
        System.out.println("Press:" +
            "1.CITY kind of book"+
            "2.FAIRYTALE kind of book");
        return scanner.nextInt();
    }
}

