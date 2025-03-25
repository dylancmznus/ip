import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Ui class handles all user interactions, printing out messages and getting input.
 * Provides methods to display greetings, task lists, errors and messages.
 */
public class Ui {

    /**
     * Displays hello message when the run starts.
     */
    public void printHello() { //on startup, say hello
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Friday");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a goodbye message when the run ends.
     */
    public void printGoodbye() { //on closing say goodbye
        System.out.println("____________________________________________________________");
        System.out.println(" Goodbye!");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays the current list of tasks.
     *
     * @param tasks The TaskList object.
     */
    public void printTaskList(TaskList tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(" " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when new task is added.
     *
     * @param task  The task that was added.
     * @param tasks The updated task list.
     */
    public void printAddedTask(Task task, TaskList tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when task is deleted.
     *
     * @param task  The task that was deleted.
     * @param tasks The updated task list.
     */
    public void printDeletedTask(Task task, TaskList tasks) {
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've deleted this task:");
        System.out.println("   " + task);
        System.out.println(" Now you have " + (tasks.size() -1) + " tasks in the list.");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when a task is marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void printMarkedTask(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println(" Marked task as done:");
        System.out.println("   " + task);
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays a message when a task is unmarked (marked as not done).
     *
     * @param task The task that was unmarked.
     */
    public void printUnmarkedTask(Task task) {
        System.out.println("____________________________________________________________");
        System.out.println(" Marked task as not done yet:");
        System.out.println("   " + task);
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays tasks that match a search keyword.
     *
     * @param foundTasks The list of matching tasks.
     */
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

    /**
     * Displays confusion when the user enters unknown command.
     */
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

    /**
     * Reads and returns user input from the console.
     *
     * @return The user input as a string.
     */
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Displays an error if the system has a loading issue.
     */
    public void showLoadingError() {
        System.out.println("____________________________________________________________");
        System.out.println(" There's been a loading error. Please try again.");
        System.out.println("____________________________________________________________");
    }
}
