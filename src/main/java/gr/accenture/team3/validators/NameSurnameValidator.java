package gr.accenture.team3.validators;

/**
 * A class to validate and manage a name or surname ensuring it only contains alphabetic characters and spaces.
 */
public class NameSurnameValidator {
    // Variable to store the validated name or surname
    private String nameOrSurname;

    /**
     * Constructor that validates a name or surname upon instantiation.
     * @param nameOrSurname The name or surname to be validated.
     * @throws IllegalArgumentException If the provided name or surname does not meet the validation criteria.
     */
    public NameSurnameValidator(String nameOrSurname) {
        if (!isValidNameOrSurname(nameOrSurname)) {
            throw new IllegalArgumentException("Invalid name or surname. Must contain only alphabetic characters and spaces, and cannot be null.");
        }
        this.nameOrSurname = nameOrSurname;
    }

    /**
     * Getter method to retrieve the validated name or surname.
     * @return the validated name or surname.
     */
    public String getNameOrSurname() {
        return nameOrSurname;
    }

    /**
     * Validates a name or surname ensuring it only contains alphabetic characters and spaces.
     * @param input The name or surname string to validate.
     * @return true if the input is valid, false otherwise.
     */
    private static boolean isValidNameOrSurname(String input) {
        // Regular expression pattern to ensure only alphabetic characters and spaces are included.
        return input != null && input.matches("[a-zA-Z\\s]+");
    }

    /**
     * Generates a string representation of the NameSurnameValidator object.
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return nameOrSurname;
    }
}
