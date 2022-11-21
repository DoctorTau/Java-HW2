import java.util.Scanner;

public class Program {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentsGroup group = new StudentsGroup();
        String command = "";
        while (true && !command.equals("/q")) {
            command = scanner.nextLine();
            switch (command) {
                case "/r":
                    group.MarkRandom();
                    break;
                case "/l":
                    System.out.println(group);
                    break;
                case "/q":
                    System.out.println("Closing the application...");
                    break;
                case "/h":
                    // Out the applications commands
                    System.out.println("Commands:");
                    System.out.println("/r - mark random student");
                    System.out.println("/l - list marked students");
                    System.out.println("/h - show this message");
                    System.out.println("/q - quit");
                    break;

                default:
                    System.out.println("Invalid Command.");
                    break;
            }
        }
    }
}
