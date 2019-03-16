package com.codecool.ui;


import com.codecool.brain.Book;
import com.codecool.brain.Home;
import com.codecool.brain.Storage;

import java.util.*;

class Input {
    private static Scanner scanner = new Scanner(System.in);

    static int intInput(int n, int n2) {
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {

                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue < n || retValue > n2) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue;

    }

    static int quitMenuInput(int n, int n2) {
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue < n || retValue > n2) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue;

    }

    static String autorInPut() {
        System.out.println("Enter the autor : ");
        return scanner.next();
    }

    static String titleInPut() {
        System.out.println("Enter the title : ");
        return scanner.next();
    }

    static int pageInput() {
        System.out.println("Enter the number of pages : ");
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue <= 1) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue;
    }

    static String foodKindInPut() {
        System.out.println("Which kind of recipes are in the book? ");
        return scanner.next();
    }

    static String typeInput() {
        System.out.println("Enter the sub genre: ");
        return scanner.next();
    }

    static List<String> content() throws InputMismatchException {
        List<String> list = new ArrayList<>(Arrays.asList("teen", "adult", "child"));
        List<String> retList = new ArrayList<>();
        System.out.println("For who is this book?\n");
        while (list.size() > 0) {
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
            } else if (in < 3 && in > 0) {
                String string = list.remove(in - 1);
                retList.add(string);
            }
        }
        return retList;
    }

    static int kindInput() throws InputMismatchException {
        System.out.println("Press:" +
            "1.CITY kind of book" +
            "2.FAIRYTALE kind of book");
        return scanner.nextInt();
    }

    static int storageTypeInput() {
        OutPut.printBookchoice();
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue < 1 || retValue > 3) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue;

    }

    static int storageCapacityInput() {
        OutPut.printCapacity();
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue < 0) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue;

    }

    static int subMenuInput() {
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue < 1 || retValue > 3) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue;
    }

    static int rmBookFromList(List<Book> books) {
        OutPut.removeAddBook();
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue > books.size()) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue - 1;

    }

    static int addBookToStorage(List<Storage> storages) {
        OutPut.removeAddBook();
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue > storages.size()) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue - 1;
    }

    static int chooseStorage(Home home) {
        System.out.println("Enter the ID of the storage");
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue > home.getStorage().size()) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue - 1;
    }

    static int chooseBookInTheStorage(List<Book> books) {
        System.out.println("Enter the ID of the book");
        boolean success = false;
        int retValue = 0;
        while (!success) {
            try {
                //im not sure if its okay like this
                Scanner scannerInt = new Scanner(System.in);
                retValue = scannerInt.nextInt();
                if (retValue > books.size()) {
                    success = false;
                    throw new InputMismatchException();
                } else {
                    success = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wrong input try again");
            }
        }
        return retValue - 1;
    }
}





