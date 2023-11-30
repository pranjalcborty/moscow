package materials.config.validation;

import org.springframework.validation.BindingResult;

/**
 * @author pranjal
 * @date 2023-11-30
 */
public class ValidationException extends Exception {

    private final BindingResult result;

    public ValidationException(String message, BindingResult result) {
        super(message);
        this.result = result;
    }

    public BindingResult getResult() {
        return result;
    }
}
