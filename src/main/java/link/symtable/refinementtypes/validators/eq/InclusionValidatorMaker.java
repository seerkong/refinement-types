package link.symtable.refinementtypes.validators.eq;

import java.util.Collection;
import java.util.Objects;

import link.symtable.refinementtypes.errors.InclusionError;
import link.symtable.refinementtypes.validators.AnyValidator;
import com.fasterxml.jackson.databind.JsonNode;


public class InclusionValidatorMaker {
    public static AnyValidator make(Collection<JsonNode> values, EqPredicate<JsonNode> predicate) {
        if (Objects.isNull(predicate)) {
            predicate = EqValidatorMaker.defaultPredicate;
        }
        EqPredicate<JsonNode> finalPredicate = predicate;
        return input -> {
            boolean anyPasswd = false;
            for (JsonNode value : values) {
                boolean validatePassed = finalPredicate.predicate(input, value);
                anyPasswd = anyPasswd || validatePassed;
            }
            return anyPasswd ? new InclusionOutput(input, null) : new InclusionOutput(null, new InclusionError());
        };
    }
}
