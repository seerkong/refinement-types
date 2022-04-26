package link.symtable.refinementtypes.errors;


public class MapValidateErrorItem extends ContainerValidateErrorItem {
    // 校验失败的map key
    String key;

    public MapValidateErrorItem(ValidError error, String key) {
        this.key = key;
        this.error = error;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (o instanceof MapValidateErrorItem) {
            return key.equals(((MapValidateErrorItem) o).key)
                    && error.equals(((MapValidateErrorItem) o).error);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return error.hashCode();
    }
}
