package atmin;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class InvalidEmailException extends Exception {
    private final int eCode;

    public InvalidEmailException(String message, int eCode) {
        super(message);
        this.eCode = eCode;
    }

    public int geteCode() {
        return eCode;
    }


}
