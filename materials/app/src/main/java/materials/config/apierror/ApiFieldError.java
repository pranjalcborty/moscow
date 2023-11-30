package materials.config.apierror;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author pranjal
 * @date 2023-11-30
 */
@Data
@AllArgsConstructor
public class ApiFieldError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiFieldError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
