import java.util.ArrayList;
import java.util.Scanner;

//main class
public class Friday {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Friday(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        tasks = new TaskList(storage.loadTasks());
    }

    public void run() {
        ui.printHello();
        boolean isRunning = true;
        while (isRunning) {
            String input = ui.getUserInput(); //get user input command
            String command = parser.parseCommand(input);
            isRunning = handleCommand(command, input);
        }
    }

    private boolean handleCommand(String command, String input) {
        try {
            switch (command) {
                case "bye":
                    ui.printGoodbye();
                    storage.saveTasks(tasks.getTasks()); //save txt file before closing
                    return false;
                case "list":
                    ui.printTaskList(tasks);
                    break;
                case "mark":
                    try {
                        int markIndex = parser.getTaskIndex(input, tasks.size());
                        tasks.markTaskAsDone(markIndex);
                        ui.printMarkedTask(tasks.get(markIndex));
                    } catch (FridayException e) {
                        ui.printError(e.getMessage());
                    }
                    break;
                case "unmark":
                    try {
                        int unmarkIndex = parser.getTaskIndex(input, tasks.size());
                        tasks.unmarkTask(unmarkIndex);
                        ui.printUnmarkedTask(tasks.get(unmarkIndex));
                    } catch (FridayException e) {
                        ui.printError(e.getMessage());
                    }
                    break;
                case "todo":
                    String todoDescription = parser.extractDescription(input);
                    if (todoDescription.isEmpty()) {
                        ui.printError("Whoops, it's empty.");
                    } else {
                        tasks.addTask(new Todo(todoDescription));
                        ui.printAddedTask(tasks.getLastTask(), tasks);
                    }
                    break;
                case "deadline":
                    String[] deadlineDetails = parser.extractDeadlineDetails(input);
                    if (deadlineDetails.length == 2) {
                        tasks.addTask(new Deadline(deadlineDetails[0], deadlineDetails[1]));
                        ui.printAddedTask(tasks.getLastTask(), tasks);
                    } else {
                        ui.printError("Whoops, no deadline added.");
                    }
                    break;
                case "event":
                    String[] eventDetails = parser.extractEventDetails(input);
                    if (eventDetails.length == 3) {
                        tasks.addTask(new Event(eventDetails[0], eventDetails[1], eventDetails[2]));
                        ui.printAddedTask(tasks.getLastTask(), tasks);
                    } else {
                        ui.printError("Whoops, no event date added.");
                    }
                    break;
                case "delete":
                    try {
                        int deleteIndex = parser.getTaskIndex(input, tasks.size());
                        tasks.deleteTask(deleteIndex);
                        ui.printDeletedTask(tasks.getLastDeletedTask(), tasks);
                    } catch (FridayException e) {
                        ui.printError(e.getMessage());
                    }
                    break;
                case "find":
                    String findKeyword = parser.extractKeyword(input);
                    ui.printFoundTasks(tasks.findTasks(findKeyword));
                    break;
                default:
                    ui.printUnknownCommand();
            }
        } catch (Exception e) {
            ui.printError("Something went wrong.");
        }

        return true;
    }

    public static void main(String[] args) {
        new Friday("tasks.txt").run(); //run program
    }
}

