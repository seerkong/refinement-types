package link.symtable.refinementtypes.errors;

import java.util.ArrayList;
import java.util.List;

public class SomeFailedError extends ContainerValidateError {
    public SomeFailedError(List<ArrayValidateErrorItem> errors) {
        super(ErrorType.AllFailedError);
        List<ContainerValidateErrorItem> containerErrors = new ArrayList<>();
        containerErrors.addAll(errors);
        setErrors(containerErrors);
    }
}
