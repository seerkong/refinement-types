package link.symtable.refinementtypes.validators.array;

import java.util.ArrayList;
import java.util.List;

import link.symtable.refinementtypes.errors.ArrayValidateErrorItem;
import link.symtable.refinementtypes.errors.InvalidArrayError;
import link.symtable.refinementtypes.errors.NotArrayError;
import link.symtable.refinementtypes.errors.NotExistError;
import link.symtable.refinementtypes.results.AnyResult;
import link.symtable.refinementtypes.validators.AnyValidator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * 描述一个map中，有哪些字段
 */
public class ArrayValidatorMaker {
    public static AnyValidator make(List<AnyValidator> validators) {
        return input -> {
            if (!input.isArray()) {
                return new ArrayOutput(null, new NotArrayError());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode sanitizedValue = objectMapper.createArrayNode();
            List<ArrayValidateErrorItem> errors = new ArrayList<>();
            for (int i = 0; i < validators.size(); i++) {
                AnyValidator validator = validators.get(i);
                if (i > input.size()) {
                    errors.add(new ArrayValidateErrorItem(new NotExistError(), i));
                    continue;
                }
                JsonNode inputArrItem = input.get(i);
                AnyResult validateResult = validator.validate(inputArrItem);
                if (validateResult.isError()) {
                    errors.add(new ArrayValidateErrorItem(validateResult.getError(), i));
                    sanitizedValue.add(objectMapper.nullNode());
                } else if (validateResult.getData() != null) {
                    sanitizedValue.add(inputArrItem);
                }
            }

            if (errors.size() > 0) {
                return new ArrayOutput(null, new InvalidArrayError(errors));
            } else {
                return new ArrayOutput(sanitizedValue, null);
            }
        };
    }
}
