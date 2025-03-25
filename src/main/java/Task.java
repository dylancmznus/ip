public abstract class Task {
    protected String description;
    protected boolean done;

    /**
     * Initialize a task with a given description.
     * @param description The task description.
     */
    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Checks if the task is marked as done.
     * @return True if done, if not false.
     */
    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }

    public void unmarkDone() {
        this.done = false;
    }

    public String getIcon() {
        return (done ? "[X]" : "[ ]");
    }

    @Override
    public abstract String toString();

}
