package ua.com.foxminded.university.exceptions;

public class EntityNameExistsException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -5759554665599906924L;

    public EntityNameExistsException(String errorMessage) {
        super(errorMessage);
    }
}
