package gr.accenture.team3.validators;

/**
 * Class for validating and managing a Greek AFM (Αριθμός Φορολογικού Μητρώου, Tax Identification Number).
 */
public class AFMValidator {

    // Variable to store the AFM number
    private final String afm;

    /**
     * Constructor for AFMValidator that initializes an AFM object after validation.
     * @param afm the AFM number as a String
     * @throws IllegalArgumentException if the input AFM is invalid
     */
    public AFMValidator(String afm) {
        if (!isValidAFM(afm)) {
            throw new IllegalArgumentException("Invalid AFM: AFM must be exactly 9 digits long.");
        }
        this.afm = afm;
    }

    /**
     * Getter method to retrieve the AFM number.
     * @return the AFM number
     */
    public String getAfm() {
        return afm;
    }

    /**
     * Validates that the AFM number is exactly 9 digits long.
     * @param afm the AFM number as a String
     * @return true if the AFM number is valid, false otherwise
     */
    private static boolean isValidAFM(String afm) {
        return afm != null && afm.matches("\\d{9}");
    }

    /**
     * Generates a string representation of the AFMValidator object.
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "validators.AFMValidator{" +
                "afm='" + afm + '\'' +
                '}';
    }

}