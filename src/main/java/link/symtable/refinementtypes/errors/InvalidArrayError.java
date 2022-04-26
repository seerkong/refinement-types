package link.symtable.refinementtypes.errors;

import java.util.ArrayList;
import java.util.List;

public class InvalidArrayError extends ContainerValidateError {
    public InvalidArrayError(List<ArrayValidateErrorItem> errors) {
        super(ErrorType.InvalidArrayError);
        List<ContainerValidateErrorItem> containerErrors = new ArrayList<>();
        containerErrors.addAll(errors);
        setErrors(containerErrors);
    }
}
