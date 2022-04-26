package link.symtable.refinementtypes.errors;

import java.util.ArrayList;
import java.util.List;

public class InvalidMapError extends ContainerValidateError {
    public InvalidMapError(List<MapValidateErrorItem> errors) {
        super(ErrorType.InvalidMapError);
        List<ContainerValidateErrorItem> containerErrors = new ArrayList<>();
        containerErrors.addAll(errors);
        setErrors(containerErrors);
    }
}
