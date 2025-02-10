import java.util.Scanner;

public class Friday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tasks = new String[100];
        int count = 0;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Friday");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            String input = scan.nextLine();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                // List all stored tasks
                for (int i = 0; i < count; i++) {
                    System.out.println(" " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            } else {
                // Add new task if there is room
                if (count < 100) {
                    tasks[count] = input;
                    count++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Sorry, the task list is full!");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        scan.close();
    }
}