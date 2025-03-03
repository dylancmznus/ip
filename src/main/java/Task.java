public abstract class Task {
    protected String description;
    protected boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public String getDescription() {
        return description;
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
