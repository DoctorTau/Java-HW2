package com.homework2;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentsGroup group = new StudentsGroup();
        String command = "";
        System.out.println("Type /h to see list of commands.");
        while (true && !command.equals("/q")) {
            command = scanner.nextLine();
            switch (command) {
                case "/r":
                    group.markRandom();
                    break;
                case "/l":
                    System.out.println(group);
                    break;
                case "/q":
                    System.out.println("Closing the application...");
                    break;
                case "/h":
                    printHelpInformationToConsole();
                    break;

                default:
                    System.out.println("Invalid Command.");
                    break;
            }
        }
    }

    private static void printHelpInformationToConsole() {
        System.out.println("Commands:");
        System.out.println("/r - mark random student");
        System.out.println("/l - list marked students");
        System.out.println("/h - show this message");
        System.out.println("/q - quit");
    }
}
