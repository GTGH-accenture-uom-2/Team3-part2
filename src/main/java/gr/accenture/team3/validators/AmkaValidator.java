package gr.accenture.team3.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class for validating and managing a Greek AMKA (Αριθμός Μητρώου Κοινωνικών Ασφαλίσεων, Social Security Number).
 */
public class AmkaValidator {

    // Variable to store the AMKA number
    private final String amka;
    // Variable to store the birthdate associated with the AMKA
    private final LocalDate birthdate;

    /**
     * Constructor for AmkaValidator that initializes an AMKA object after validation.
     * @param amka the AMKA number as a String
     * @param birthdate the birthdate associated with the AMKA
     * @throws IllegalArgumentException if the input AMKA is invalid
     */
    public AmkaValidator(String amka, LocalDate birthdate) {
        if (!isValidAmka(amka, birthdate)) {
            throw new IllegalArgumentException("Invalid AMKA: AMKA must start with birthdate in ddMMyy format and be 11 digits long.");
        }
        this.amka = amka;
        this.birthdate = birthdate;
    }

    /**
     * Getter method to retrieve the AMKA number.
     * @return the AMKA number
     */
    public String getAmka() {
        return amka;
    }

    /**
     * Getter method to retrieve the birthdate.
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Validates the AMKA number based on the birthdate and its format.
     * AMKA should be 11 digits long and start with the birthdate in ddMMyy format.
     * @param amka the AMKA number as a String
     * @param birthdate the birthdate associated with the AMKA
     * @return true if the AMKA number is valid, false otherwise
     */
    public static boolean isValidAmka(String amka, LocalDate birthdate) {
        if (amka == null || amka.length() != 11) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String birthdateStr = birthdate.format(formatter);

        // Check if the first 6 digits of AMKA match the formatted birthdate
        if (!amka.startsWith(birthdateStr)) {
            return false;
        }

        // Check if the remaining digits are numeric
        for (int i = 6; i < amka.length(); i++) {
            if (!Character.isDigit(amka.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Generates a string representation of the AmkaValidator object.
     * @return string representation of the object
     */
    @Override
    public String toString() {
        return "validators.AmkaValidator{" +
                "amka='" + amka + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}