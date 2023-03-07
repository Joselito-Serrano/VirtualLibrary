import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        forTesting();
//        userInput();
    }

    private static void forTesting(){
        myDatabase mydb = myDatabase.getInstance();

        System.out.println("mydb hashcode: " + mydb.hashCode());

        mydb.addBooks(0, "2105: Evolution");
        mydb.addBooks(1, "Claw of Blood");
        mydb.addBooks(2, "Death of Shrieking Viper");

        System.out.println(mydb.viewBooks());
        System.out.println("--------------");

        demoBooks();

        System.out.println("--------------");

        System.out.println("Removing book index 0 \n" + mydb.removeBooks(0));
        System.out.println(mydb.viewBooks());
    }

    private static void demoBooks() {
        Map<Integer, String> demobooks = new HashMap<>();
        demobooks.put(32, "Hand of Neptune");
        demobooks.put(12, "Avian Exile");
        demobooks.put(45, "2132: Sanctum");

        myDatabase mydb = myDatabase.getInstance();

        //check if same hashcode
        System.out.println("mydb hashcode: " + mydb.hashCode());

        System.out.println("Adding books\n" + mydb.addBooks(demobooks));

        System.out.println(mydb.viewBooks());
    }

    private static void userInput() {
        Scanner scanner = new Scanner(System.in);
        myDatabase mydb = myDatabase.getInstance();
        String input;
        boolean programisDone = false;
        boolean validInput = false;

        while (!programisDone) {
            System.out.println("To add a book type \"add\"");
            System.out.println("To view the books type \"view\"");
            System.out.println("To remove a books type \"remove\"");
            System.out.println("To stop the program type \"quit\"");
            input = scanner.nextLine().toLowerCase();

//            switch (input.toLowerCase()) {
//                case "add":
//                    System.out.println("To add book kindly follow the template \"<index>-<title>\"");
//                    break;
//                case "view":
//                    System.out.println(mydb.viewBooks());
//                    break;
//                case "remove":
//                    System.out.println("To remove book kindly follow the template \"<index>-<title>\" or \"<index>\"");
//                    break;
//                case "quit":
//                    programisDone = true;
//                    break;
//                default:
//                    break;
//            }
            if (input.equalsIgnoreCase("add")) {
                while (!validInput) {
                    System.out.println("To add book kindly follow the template \"<index>-<title>\"");
                    try {
                        input = scanner.nextLine();
                        mydb.addBooks(Integer.parseInt(input.split("-")[0]), input.split("-")[1]);
                        validInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                }
            } else if (input.equalsIgnoreCase("view")) {
                System.out.println(mydb.viewBooks());
            } else if (input.equalsIgnoreCase("remove")) {
                System.out.println("To remove book kindly follow the template \"<index>-<title>\" or \"<index>\"");
                while (!validInput) {
                    try {
                        input = scanner.nextLine();
                        if (input.contains("-")) {
                            mydb.removeBooks(Integer.parseInt(input.split("-")[0]), input.split("-")[1]);
                        } else {
                            mydb.removeBooks(Integer.parseInt(input.split("-")[0]));
                        }
                        validInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                }
            } else if (input.equalsIgnoreCase("quit")) {
                programisDone = true;
            } else {
                System.out.println("Invalid input!");
            }

            System.out.println("---------");
            validInput = false;
        }

        System.out.println("Exiting program");
        scanner.close();
    }
}