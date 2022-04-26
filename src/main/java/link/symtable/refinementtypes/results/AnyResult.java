package link.symtable.refinementtypes.results;

import link.symtable.refinementtypes.errors.ValidError;
import com.fasterxml.jackson.databind.JsonNode;

public class AnyResult extends Result<JsonNode, ValidError> {

    public AnyResult(JsonNode output, ValidError errorInfo) {
        super(output, errorInfo);
    }
}
