import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    public void printHello() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Friday");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public void printGoodbye() {
        System.out.println("____________________________________________________________");
        System.out.println(" Goodbye!");
        System.out.println("____________________________________________________________");
    }

    public void printTaskList(TaskList tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println("____________________________________________________________");
    }

    public void printAddedTask(Task task, TaskList tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }
    public void printDeletedTask(Task task, TaskList tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've deleted this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    public void printMarkedTask(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println(" Marked task as done:");
        System.out.println("   " + task);
        System.out.println("____________________________________________________________");
    }

    public void printUnmarkedTask(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println(" Marked task as not done yet:");
        System.out.println("   " + task);
        System.out.println("____________________________________________________________");
    }

    public void printFoundTasks(ArrayList<Task> foundTasks) {
        System.out.println("____________________________________________________________");
        if (foundTasks.isEmpty()) {
            System.out.println(" No matching tasks found.");
        } else {
            System.out.println(" Matches found in your list:");
            for (int i = 0; i < foundTasks.size(); i++) {
                System.out.println(" " + (i + 1) + "." + foundTasks.get(i));
            }
        }
        System.out.println("____________________________________________________________");
    }

    public void printUnknownCommand() {
        System.out.println("____________________________________________________________");
        System.out.println(" Say that again?");
        System.out.println("____________________________________________________________");
    }

    public void printError(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void showLoadingError() {
        System.out.println("____________________________________________________________");
        System.out.println(" There's been a loading error. Please try again.");
        System.out.println("____________________________________________________________");
    }
}
