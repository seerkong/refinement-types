package link.symtable.refinementtypes.errors;

public class ShapeValidateErrorItem extends ContainerValidateErrorItem {
    // 校验失败的字段名称
    String field;

    public ShapeValidateErrorItem(ValidError error, String field) {
        this.field = field;
        this.error = error;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof ShapeValidateErrorItem) {
            return field.equals(((ShapeValidateErrorItem) o).field)
                    && error.equals(((ShapeValidateErrorItem) o).error);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return error.hashCode();
    }
}
