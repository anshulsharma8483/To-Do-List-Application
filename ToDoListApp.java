import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {
    private List<Task> tasks;
    private Scanner scanner;

    public ToDoListApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    markAsCompleted();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== To-Do List Menu =====");
        System.out.println("1. Add a new task");
        System.out.println("2. Edit a task");
        System.out.println("3. Delete a task");
        System.out.println("4. List all tasks");
        System.out.println("5. Mark a task as completed");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added successfully.");
    }

    private void editTask() {
        listTasks();
        System.out.print("Enter task number to edit: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (isValidIndex(taskIndex)) {
            System.out.print("Enter new description: ");
            String newDescription = scanner.nextLine();
            tasks.get(taskIndex - 1).setDescription(newDescription);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void deleteTask() {
        listTasks();
        System.out.print("Enter task number to delete: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (isValidIndex(taskIndex)) {
            tasks.remove(taskIndex - 1);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void listTasks() {
        System.out.println("\n===== Tasks List =====");
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void markAsCompleted() {
        listTasks();
        System.out.print("Enter task number to mark as completed: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (isValidIndex(taskIndex)) {
            tasks.get(taskIndex - 1).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private boolean isValidIndex(int index) {
        return index > 0 && index <= tasks.size();
    }

    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        app.start();
    }
}
