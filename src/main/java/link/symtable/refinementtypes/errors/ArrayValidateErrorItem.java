package link.symtable.refinementtypes.errors;

public class ArrayValidateErrorItem extends ContainerValidateErrorItem {
    private int index;

    public ArrayValidateErrorItem(ValidError error, int index) {
        this.index = index;
        this.error = error;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof ArrayValidateErrorItem) {
            return index == ((ArrayValidateErrorItem) o).index
                    && error.equals(((ArrayValidateErrorItem) o).error);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return error.hashCode();
    }
}
