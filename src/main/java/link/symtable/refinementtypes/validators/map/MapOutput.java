package link.symtable.refinementtypes.validators.map;

import link.symtable.refinementtypes.errors.ValidError;
import link.symtable.refinementtypes.results.AnyResult;
import com.fasterxml.jackson.databind.JsonNode;

public class MapOutput extends AnyResult {
    public MapOutput(JsonNode output, ValidError errorInfo) {
        super(output, errorInfo);
    }
}
