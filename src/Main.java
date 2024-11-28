
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Initializing a HashMap to store tasks with String keys and Task values
        Map<String, Task> tasks = new HashMap<>();
        // Start run application
        System.out.print("Enter your name: ");
        // Initializing Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Reading the user's name
        String userName = scanner.nextLine();

        // While loop to keep the application running until the user chooses to exit
        while (true) {
            try {
//           Calling printActions method
                printActions();
//         Read user input to determine the action to perform
                int choice = scanner.nextInt();
//                Switch case to execute code based on a choice
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        TaskManager.addTask(tasks, userName);

                        break;
                    case 2:
                        TaskManager.getAllTasks(tasks, userName);
                        break;
                    case 3:
                        TaskManager.updateTask(tasks, userName);
                        break;
                    case 4:
                        TaskManager.deleteTask(tasks,userName);
                        break;
                    case 5:
                        TaskManager.getSpecificTask(tasks, userName);
                        break;
                    case 6:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
            // Handling exceptions and displaying the error message
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printActions() {
        // Storing menu options in an array
        String[] actions = {
                "1) Add task",
                "2) Get all tasks",
                "3) Update task",
                "4) Delete task",
                "5) Get specific task",
                "6) Exit"
        };
        // Printing each action using a for-each loop
        System.out.println();
        for (String action : actions) {
            System.out.println(action);
        }
        System.out.print("Enter your actions number: ");
    }

}