import java.util.ArrayList;
import java.util.Scanner;

public class Friday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Friday");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String input = scan.nextLine();

            try {
                if (input.equals("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Goodbye!");
                    System.out.println("____________________________________________________________");
                    break;
                } else if (input.equals("list")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(" " + (i + 1) + "." + tasks.get(i));
                    }
                    System.out.println("____________________________________________________________");
                } else if (input.startsWith("mark ")) {
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        if (index >= 0 && index < tasks.size()) {
                            tasks.get(index).markDone();
                            System.out.println("____________________________________________________________");
                            System.out.println(" Marked task as done:");
                            System.out.println("   " + tasks.get(index));
                            System.out.println("____________________________________________________________");
                        } else {
                            throw new FridayException(" Whoops, that number is out of range.");
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        throw new FridayException(" Whoops, invalid task number.");
                    }
                } else if (input.startsWith("unmark ")) {
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        if (index >= 0 && index < tasks.size()) {
                            tasks.get(index).unmarkDone();
                            System.out.println("____________________________________________________________");
                            System.out.println(" OK, I've marked this task as not done yet:");
                            System.out.println("   " + tasks.get(index));
                            System.out.println("____________________________________________________________");
                        } else {
                            throw new FridayException(" Whoops, that number is out of range.");
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        throw new FridayException(" Whoops, invalid task number.");
                    }
                } else if (input.startsWith("todo ")) {
                    String description = input.substring(5).trim();
                    if (description.isEmpty()) {
                        throw new FridayException(" Whoops, its empty.");
                    } else {
                        tasks.add(new Todo(description));
                        System.out.println("____________________________________________________________");
                        System.out.println(" Got it. I've added this task:");
                        System.out.println("   " + tasks.get(tasks.size() - 1));
                        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                    }
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ", 2);
                    if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                        throw new FridayException(" Whoops, no deadline added.");
                    } else {
                        tasks.add(new Deadline(parts[0], parts[1]));
                        System.out.println("____________________________________________________________");
                        System.out.println(" Got it. I've added this task:");
                        System.out.println("   " + tasks.get(tasks.size() - 1));
                        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                    }
                } else if (input.startsWith("event ")) {
                    String[] parts = input.substring(6).split(" /from | /to ", 3);
                    if (parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
                        throw new FridayException(" Whoops, no date added.");
                    } else {
                        tasks.add(new Event(parts[0], parts[1], parts[2]));
                        System.out.println("____________________________________________________________");
                        System.out.println(" Got it. I've added this task:");
                        System.out.println("   " + tasks.get(tasks.size() - 1));
                        System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println("____________________________________________________________");
                    }
                } else if (input.startsWith("delete ")) {
                    try {
                        int index = Integer.parseInt(input.split(" ")[1]) - 1;
                        System.out.println("____________________________________________________________");
                        System.out.println(" Got it. I've deleted this task:");
                        System.out.println("   " + tasks.get(index));
                        if (index >= 0 && index < tasks.size()) {
                            tasks.remove(index);
                            System.out.println(" Now you have " + tasks.size() + " tasks in the list.");
                            System.out.println("____________________________________________________________");
                        } else {
                            throw new FridayException(" Whoops, that number is out of range.");
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        throw new FridayException(" Whoops, invalid task number.");
                    }
                } else {
                    throw new FridayException("Say that again?");
                }
            } catch (FridayException e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
            }
        }
        scan.close();
    }
}
