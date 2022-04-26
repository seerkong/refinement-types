package link.symtable.refinementtypes.validators;

import link.symtable.refinementtypes.results.AnyResult;
import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface AnyValidator {
    AnyResult validate(JsonNode input);
}
