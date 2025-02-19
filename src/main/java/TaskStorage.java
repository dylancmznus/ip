import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskStorage {
    private final String filePath;

    public TaskStorage(String filePath) {
        this.filePath = filePath;
    }
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath);
        if (!f.exists()) {
            return tasks;
        }
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("[T]")) {
                    tasks.add(new Todo(line.substring(4)));  // Assuming description starts after "[T] "
                } else if (line.startsWith("[D]")) {
                    String[] parts = line.substring(4).split(" /by ");
                    tasks.add(new Deadline(parts[0], parts[1]));
                } else if (line.startsWith("[E]")) {
                    String[] parts = line.substring(4).split(" /from | /to ", 3);
                    tasks.add(new Event(parts[0], parts[1], parts[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return tasks;
    }
    public void saveTasks(ArrayList<Task> tasks) {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (Task task : tasks) {
                fw.write(task.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
