package link.symtable.refinementtypes.errors;

import java.util.List;

public abstract class ContainerValidateError extends ValidError {
    private List<ContainerValidateErrorItem> errors;

    public ContainerValidateError(ErrorType errorType) {
        super(errorType);
    }

    public ContainerValidateError(ErrorType errorType, List<ContainerValidateErrorItem> errors) {
        super(errorType);
        this.errors = errors;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof ContainerValidateError) {
            if (getErrorType() != ((ContainerValidateError) o).getErrorType()) {
                return false;
            }
            List<ContainerValidateErrorItem> thatErrors = ((ContainerValidateError) o).getErrors();
            if (errors.size() != thatErrors.size()) {
                return false;
            }
            for (int i = 0; i < errors.size(); i++) {
                ContainerValidateErrorItem thisError = errors.get(i);
                ContainerValidateErrorItem thatError = thatErrors.get(i);
                if (!thisError.equals(thatError)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return getErrorType().hashCode() + getErrors().hashCode();
    }

    public List<ContainerValidateErrorItem> getErrors() {
        return errors;
    }

    public void setErrors(List<ContainerValidateErrorItem> errors) {
        this.errors = errors;
    }
}
