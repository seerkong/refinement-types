package link.symtable.refinementtypes.validators.eq;

import java.util.Objects;

import link.symtable.refinementtypes.errors.EqualityError;
import link.symtable.refinementtypes.validators.AnyValidator;
import com.fasterxml.jackson.databind.JsonNode;

public class EqValidatorMaker {
    public static EqPredicate<JsonNode> defaultPredicate = Objects::equals;

    public static AnyValidator make(JsonNode value, EqPredicate<JsonNode> predicate) {
        if (Objects.isNull(predicate)) {
            predicate = defaultPredicate;
        }
        EqPredicate<JsonNode> finalPredicate = predicate;
        return input -> {
            boolean validatePassed = finalPredicate.predicate(input, value);
            return validatePassed ? new EqOutput(input, null) : new EqOutput(null, new EqualityError());
        };
    }
}
