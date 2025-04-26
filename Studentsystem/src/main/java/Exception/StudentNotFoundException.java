package Exception;

public class StudentNotFoundException extends RuntimeException {

    // Constructor accepting a custom error message
    public StudentNotFoundException(String message) {
        super(message);
    }
}
