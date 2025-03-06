public class Parser {

    //split parts of input to find command
    public String parseCommand(String input) {
        String[] parts = input.split(" ", 2);
        return parts[0].toLowerCase();
    }

    //obtain task index number
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

    public String extractDescription(String input) {
        return input.substring(5).trim();
    }

    public String[] extractDeadlineDetails(String input) {
        String[] parts = input.substring(9).split(" /by ", 2);
        return parts;
    }

    public String[] extractEventDetails(String input) {
        return input.substring(6).split(" /from | /to ", 3);
    }

    public String extractKeyword(String input) {
        return input.substring(5).trim(); //find keyword
    }
}
