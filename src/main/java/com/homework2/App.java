package com.homework2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        String command = "";
        System.out.println("Type /h to see list of commands.");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        StudentsGroup group = mapper.readValue(readJsonFile("./src/Models/Students.json"), StudentsGroup.class);
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

    public static String readJsonFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        content = content.replaceAll("[\\t\\n]", "");
        return content;
    }

    private static void printHelpInformationToConsole() {
        System.out.println("Commands:");
        System.out.println("/r - mark random student");
        System.out.println("/l - list marked students");
        System.out.println("/h - show this message");
        System.out.println("/q - quit");
    }
}
