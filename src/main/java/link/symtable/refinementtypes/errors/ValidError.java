package link.symtable.refinementtypes.errors;

public abstract class ValidError {
    private ErrorType errorType;


    public ValidError(ErrorType errorType) {
        this.errorType = errorType;
    }



    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof ValidError) {
            return errorType == ((ValidError) o).errorType;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return errorType.hashCode();
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
