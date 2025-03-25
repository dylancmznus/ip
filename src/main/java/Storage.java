import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the saving and loading of tasks from a file, ensuring persistence across program runs.
 */
public class Storage {
    private final String filePath;

    /**
     * Sets the file path for storage.
     *
     * @param filePath Path of the file to store tasks.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from txt file.
     *
     * @return List of tasks stored in the file.
     */
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
                    tasks.add(new Todo(line.substring(7)));  // Assuming description starts after "[T] "
                } else if (line.startsWith("[D]")) {
                    String[] parts = line.substring(7).split(" by: ", 2);
                    tasks.add(new Deadline(parts[0], parts[1]));
                    //System.out.println(line);
                } else if (line.startsWith("[E]")) {
                    String[] parts = line.substring(7).split(" from: | to: ", 3);
                    tasks.add(new Event(parts[0], parts[1], parts[2]));
                    //System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return tasks;
    }

    /**
     * Saves the current list of tasks to the txt file.
     *
     * @param tasks List of tasks to save.
     */
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