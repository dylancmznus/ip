/**
 * The Parser class is in charge of handling all the relevant data from the user's input.
 * It extracts commands into structured parts to facilitate task management.
 */
public class Parser {

    /**
     * Extracts the command keyword from the user input.
     *
     * @param input The full user input string.
     * @return The command keyword in lowercase.
     */
    public String parseCommand(String input) {
        String[] parts = input.split(" ", 2);
        return parts[0].toLowerCase();
    }

    /**
     * Retrieves the task index from the user input.
     *
     * @param input    The user input.
     * @param listSize The number of tasks in the list.
     * @return The zero-based index of the task.
     * @throws FridayException If index is out of range or invalid.
     */
    public int getTaskIndex(String input, int listSize) throws FridayException {
        try {
            int index = Integer.parseInt(input.split(" ")[1]) - 1;
            if (index < 0 || index >= listSize) {
                throw new FridayException("Whoops, the index is out of bounds.");
            }
            return index;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new FridayException("Whoops, invalid task number.");
        }
    }

    /**
     * Extracts the task description from a todo command input.
     *
     * @param input The user input.
     * @return The task description.
     */
    public String extractDescription(String input) {
        return input.substring(5).trim();
    }

    /**
     * Extracts the task details and deadline from a deadline command input.
     *
     * @param input The user input.
     * @return A string with the task description and the deadline.
     */
    public String[] extractDeadlineDetails(String input) {
        String[] parts = input.substring(9).split(" /by ", 2);
        return parts;
    }

    /**
     * Extracts event details from an event command input.
     *
     * @param input The user input.
     * @return A string with the event description, the start time and the end time.
     */
    public String[] extractEventDetails(String input) {
        return input.substring(6).split(" /from | /to ", 3);
    }

    /**
     * Extracts the search keyword from a find command input.
     *
     * @param input The user input.
     * @return The extracted keyword.
     */
    public String extractKeyword(String input) {
        return input.substring(5).trim(); //find keyword
    }
}
