package link.symtable.refinementtypes.errors;

import java.util.ArrayList;
import java.util.List;

public class AllFailedError extends ContainerValidateError {
    public AllFailedError(List<ArrayValidateErrorItem> errors) {
        super(ErrorType.AllFailedError);
        List<ContainerValidateErrorItem> containerErrors = new ArrayList<>();
        containerErrors.addAll(errors);
        setErrors(containerErrors);
    }
}
