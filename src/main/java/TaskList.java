import java.util.ArrayList;

//Task list class for managing the list of tasks
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    //get this certain task
    public Task get(int index) {
        return tasks.get(index);
    }

    //get the last task
    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public void markTaskAsDone(int index) {
        tasks.get(index).markDone();
    }

    public void unmarkTask(int index) {
        tasks.get(index).unmarkDone();
    }

    //get size of the current list
    public int size() {
        return tasks.size();
    }

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
