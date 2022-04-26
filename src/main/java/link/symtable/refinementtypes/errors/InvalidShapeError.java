package link.symtable.refinementtypes.errors;

import java.util.ArrayList;
import java.util.List;

public class InvalidShapeError extends ContainerValidateError {
    public InvalidShapeError(List<ShapeValidateErrorItem> errors) {
        super(ErrorType.InvalidShapeError);
        List<ContainerValidateErrorItem> containerErrors = new ArrayList<>();
        containerErrors.addAll(errors);
        setErrors(containerErrors);
    }
}
