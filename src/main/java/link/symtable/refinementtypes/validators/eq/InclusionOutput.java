package link.symtable.refinementtypes.validators.eq;

import link.symtable.refinementtypes.errors.InclusionError;
import link.symtable.refinementtypes.results.AnyResult;
import com.fasterxml.jackson.databind.JsonNode;

public class InclusionOutput extends AnyResult {
    public InclusionOutput(JsonNode output, InclusionError errorInfo) {
        super(output, errorInfo);
    }
}
