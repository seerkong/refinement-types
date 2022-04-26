package link.symtable.refinementtypes.results;

import java.util.Objects;

import link.symtable.refinementtypes.errors.ValidError;

public class Result<O, E extends ValidError> {
    private ResultKind kind = ResultKind.OK;
    private O data;
    private E error;

    public boolean isOk() {
        return kind == ResultKind.OK;
    }

    public boolean isError() {
        return kind == ResultKind.ERR;
    }


    public Result(O data, E errorInfo) {
        if (Objects.nonNull(errorInfo)) {
            kind = ResultKind.ERR;
            error = errorInfo;
        } else {
            kind = ResultKind.OK;
            this.data = data;
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof Result) {
            if (isOk()) {
                return data.equals(((Result<?, ?>) o).data);
            } else {
                return error.equals(((Result<?, ?>) o).error);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        if (isOk()) {
            return data.hashCode();
        } else {
            return error.hashCode();
        }
    }

    public ResultKind getKind() {
        return kind;
    }

    public O getData() {
        return data;
    }

    public ValidError getError() {
        return error;
    }
}
