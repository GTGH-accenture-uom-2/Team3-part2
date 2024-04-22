package gr.accenture.team3.validators;

/**
 * A class to validate and manage an email address ensuring it adheres to a specific format.
 */
public class EmailValidator {

    // Variable to store the email address
    private String emailAddress;

    /**
     * Constructor that validates an email address upon instantiation.
     * @param emailAddress The email address to be validated.
     * @throws IllegalArgumentException If the provided email address does not meet the validation criteria.
     */
    public EmailValidator(String emailAddress) {
        if (!isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.emailAddress = emailAddress;
    }

    /**
     * Getter method to retrieve the email address.
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter method that sets the email address after validating it.
     * @param emailAddress The new email address to set.
     * @throws IllegalArgumentException If the new email address does not meet the validation criteria.
     */
    public void setEmailAddress(String emailAddress) {
        if (!isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.emailAddress = emailAddress;
    }

    /**
     * Validates an email address against a specified regex pattern.
     * @param email The email address to validate.
     * @return true if the email address is valid according to the regex, otherwise false.
     */
    private static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        // Define a regex pattern for validating email addresses.
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return email.matches(emailRegex);
    }

    /**
     * Generates a string representation of the EmailValidator object.
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "validators.EmailValidator{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}