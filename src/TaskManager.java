import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskManager {
//method to add tasks by optional choice
    public static void addTask(Map<String, Task> tasks, String userName) {
//        printing choices for choosing task type in switch cases
        System.out.println("1) Basic task");
        System.out.println("2) Limited task");
        System.out.println("3) Repeatable task");
        System.out.println("4) exit");
        System.out.print("Enter action number: ");
//        Initialising instance of scanner
        Scanner sc = new Scanner(System.in);
//         Read user input to determine the action to perform
        int choice = sc.nextInt();
// Ensure the input buffer is cleared
        sc.nextLine();
        switch (choice) {
            // Adding a basic task
            case 1: {
                System.out.print("Enter task name: ");
                String taskName = sc.nextLine();
                // Check if task name already exists
                if (tasks.containsKey(taskName)) {
                    System.out.println("Task already exists");
                    return;
                }
                System.out.print("Enter task description: ");
                String taskDescription = sc.nextLine();
           //    Put Basic Task to the Map
                tasks.put(taskName, new Task(taskName, taskDescription, userName));
                return;
            }
            case 2: {
                // Adding a limited time task
                try {
                    System.out.print("Enter task name: ");
                    String taskName = sc.nextLine();
                    // Check if task name already exists
                    if (tasks.containsKey(taskName)) {
                        System.out.println("Task already exists");
                        return;
                    }
                    System.out.print("Enter task description: ");
                    String taskDescription = sc.nextLine();


                    System.out.print("Enter task description(format: dd-MM-yyyy HH:mm): ");
               // Adding date and time input
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    String dateTimeString = sc.nextLine();
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
                         // Create and store the LimitedTimeTask task
                    tasks.put(taskName, new LimitedTimeTask(taskName, taskDescription, userName, dateTime));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                return;
            }
            case 3:
                // Adding a repeatable task
                try {
                    System.out.print("Enter task name: ");
                    String taskName = sc.nextLine();

                    // Check if taskName already exists
                    if (tasks.containsKey(taskName)) {
                        System.out.println("Task already exists");
                        return;
                    }

                    System.out.print("Enter task description: ");
                    String taskDescription = sc.nextLine();

                    // Prompt user for deadline
                    System.out.print("Enter task deadline (format: dd-MM-yyyy HH:mm): ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    String dateTimeString = sc.nextLine();
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

                    // Prompt user for repeat number
                    System.out.print("Enter task repeat number: ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    // Create and store the repeatable task
                    tasks.put(taskName, new RepeatableTask(taskName, taskDescription, dateTime, userName, num));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                return;

            case 4:
                // Exit option selected
                return;

            default:
                // Invalid choice
                System.out.println("Invalid choice");
        }
// Close the scanner
        sc.close();
    }

    /**
     * Prints all tasks stored in the given map.
     * @param tasks The map containing tasks, where keys are task names and values are Task objects.
     */
    public static void getAllTasks(Map<String, Task> tasks, String userName) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nAll tasks:");
        for (Map.Entry<String, Task> entry : tasks.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    /**
     * Updates the deadline and description of a task if it exists and is a LimitedTimeTask.
     * @param tasks The map containing tasks, where keys are task names and values are Task objects.
     * @param name The name associated with the tasks (not used in this method).
     */
    public static void updateTask(Map<String, Task> tasks, String name) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter task name to update deadline and description : ");
            String taskName = sc.nextLine();


            // Retrieve the task from the map based on its name
            Task taskToUpdate = tasks.get(taskName);
            if (taskToUpdate == null) {
                System.out.println("Task not found.");
                return;
            }

            // Check if the task is an instance of LimitedTimeTask for specific updates
            if (!(taskToUpdate instanceof LimitedTimeTask)) {
                System.out.println("Task is not a Limited Time Task. Does not require updating deadline.");
                return;
            }

            // Prompt user for new deadline input
            System.out.print("Enter new deadline (format: dd-MM-yyyy HH:mm): ");
            String dateTimeString = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime newDeadline = LocalDateTime.parse(dateTimeString, formatter);

            // Prompt user for new description input
            System.out.print("Enter new description: ");
            String newDescription = sc.nextLine();

            // Update the task's deadline and description
            LimitedTimeTask limitedTimeTask = (LimitedTimeTask) taskToUpdate;
            limitedTimeTask.setDeadline(newDeadline);
            limitedTimeTask.setTaskDescription(newDescription);

            System.out.println("Deadline and Description updated successfully.");
        } catch (Exception e) {
            System.err.println("Error updating deadline: " + e.getMessage());
        }
    }


    /**
     * Deletes a task from the tasks map based on the user input task name.
     * @param tasks The map containing tasks, where keys are task names and values are Task objects.
     * @param userName The name associated with the tasks (not used in this method).
     */
    public static void deleteTask(Map<String, Task> tasks, String userName) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter task name to delete: ");
            String taskName = sc.nextLine();

            // Attempt to remove the task from the map
            Task removedTask = tasks.remove(taskName);
            if (removedTask == null) {
                System.out.println("Task not found.");
            } else {
                System.out.println("Task deleted successfully: " + removedTask);
            }
        } catch (Exception e) {
            System.err.println("Error deleting task: " + e.getMessage());
        }
    }

    /**
     * Retrieves and prints a specific task from the tasks map based on the user input task name.
     * @param tasks The map containing tasks, where keys are task names and values are Task objects.
     * @param name The name associated with the tasks (not used in this method).
     */
    public static void getSpecificTask(Map<String, Task> tasks, String name) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter task name to search: ");
            String taskName = sc.nextLine();

            // Retrieve the task from the map based on its name
            Task task = tasks.get(taskName);
            if (task == null) {
                System.out.println("Task not found.");
            } else {
                System.out.println("Task found: " + task);
            }
        } catch (Exception e) {
            System.err.println("Error searching for task: " + e.getMessage());
        }
    }

}


