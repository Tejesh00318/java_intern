
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                displayMenu(taskList.size());
                int choice = readInt(scanner, "Select an option: ");

                switch (choice) {
                    case 1 -> {
                        String name = readNonEmptyLine(scanner, "Enter task name: ");
                        taskList.addTask(name);
                        System.out.println("Task added.");
                    }
                    case 2 -> {
                        if (taskList.isEmpty()) {
                            System.out.println("No tasks to remove.");
                            break;
                        }
                        taskList.listTasks();
                        int taskNumber = readInt(scanner, "Enter the task number to remove: ");
                        if (taskList.isValidTaskNumber(taskNumber)) {
                            taskList.removeTask(taskNumber);
                            System.out.println("Task removed.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    case 3 -> {
                        if (taskList.isEmpty()) {
                            System.out.println("No tasks to list.");
                        } else {
                            taskList.listTasks();
                        }
                    }
                    case 4 -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
                System.out.println(); // spacing
            }
        }
    }

    private static void displayMenu(int count) {
        System.out.println("=== Task List Application (" + count + " task" + (count == 1 ? "" : "s") + ") ===");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Quit");
    }

    // Safely read an int from a full line, reprompting on invalid input
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Read a non-empty full line (supports spaces in task names)
    private static String readNonEmptyLine(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input cannot be empty.");
        }
    }
}

class TaskList {
    private final ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(name);
    }

    public void removeTask(int taskNumber) {
        tasks.remove(taskNumber - 1); // convert from 1-based to 0-based
    }

    public void listTasks() {
        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }

    public int size() {
        return tasks.size();
    }
}
