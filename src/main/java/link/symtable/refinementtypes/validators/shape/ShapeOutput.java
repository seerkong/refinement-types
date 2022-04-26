package link.symtable.refinementtypes.validators.shape;

import link.symtable.refinementtypes.errors.ValidError;
import link.symtable.refinementtypes.results.AnyResult;

import com.fasterxml.jackson.databind.JsonNode;

public class ShapeOutput extends AnyResult {
    public ShapeOutput(JsonNode output, ValidError errorInfo) {
        super(output, errorInfo);
    }
}
