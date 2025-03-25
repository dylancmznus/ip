import java.util.ArrayList;

/**
 * Manages a list of tasks, allowing for addition, deletion, searching, and marking tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with existing tasks.
     * @param tasks A list of existing tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the task list.
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task get(int index) {
        return tasks.get(index); //get this certain task
    }


    public Task getLastTask() {
        return tasks.get(tasks.size() - 1); //get the last task of the list
    }

    /**
     * Adds a task to the list.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task at the specified index.
     * @param index The index of the task to remove.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    /**
     * Marks a task as done.
     * @param index The index of the task to mark as done.
     */
    public void markTaskAsDone(int index) {
        Task task = tasks.get(index);
        if (task.isDone()) { //check if already done
            System.out.println("Task is already marked as done.");
        } else {
            task.markDone();
        }
    }

    /**
     * Unmarks a task.
     * @param index The index of the task to unmark.
     */
    public void unmarkTask(int index) {
        Task task = tasks.get(index);
        if (!task.isDone()) {
            System.out.println("Task is already unmarked.");
        } else {
            task.unmarkDone();
        }
    }


    public int size() {
        return tasks.size(); //get size of the current list
    }

    /**
     * Finds tasks that contain a given keyword.
     * @param keyword The keyword.
     * @return A list of matching tasks.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }
}
