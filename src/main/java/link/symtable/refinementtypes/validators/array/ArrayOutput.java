package link.symtable.refinementtypes.validators.array;

import link.symtable.refinementtypes.errors.ValidError;
import link.symtable.refinementtypes.results.AnyResult;
import com.fasterxml.jackson.databind.JsonNode;

public class ArrayOutput extends AnyResult {
    public ArrayOutput(JsonNode output, ValidError errorInfo) {
        super(output, errorInfo);
    }
}
