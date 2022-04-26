package link.symtable.refinementtypes.validators.eq;

import link.symtable.refinementtypes.errors.EqualityError;
import link.symtable.refinementtypes.results.AnyResult;

import com.fasterxml.jackson.databind.JsonNode;

public class EqOutput extends AnyResult {
    public EqOutput(JsonNode output, EqualityError errorInfo) {
        super(output, errorInfo);
    }
}
