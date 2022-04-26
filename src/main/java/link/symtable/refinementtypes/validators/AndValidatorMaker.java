package link.symtable.refinementtypes.validators;

import java.util.ArrayList;
import java.util.List;

import link.symtable.refinementtypes.errors.ArrayValidateErrorItem;
import link.symtable.refinementtypes.errors.NotExistError;
import link.symtable.refinementtypes.errors.SomeFailedError;
import link.symtable.refinementtypes.results.AnyResult;
import link.symtable.refinementtypes.validators.array.ArrayOutput;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * and关系，如果校验失败时，返回所有校验失败的元素
 */
public class AndValidatorMaker {
    public static AnyValidator make(AnyValidator... validators) {
        if (validators.length < 2) {
            throw new RuntimeException("Expected at least 2 arguments");
        }
        return input -> {
            List<ArrayValidateErrorItem> errors = new ArrayList<>();
            for (int i = 0; i < validators.length; i++) {
                AnyValidator validator = validators[i];
                if (i > input.size()) {
                    errors.add(new ArrayValidateErrorItem(new NotExistError(), i));
                    continue;
                }
                JsonNode inputArrItem = input.get(i);
                AnyResult validateResult = validator.validate(inputArrItem);
                if (validateResult.isError()) {
                    errors.add(new ArrayValidateErrorItem(validateResult.getError(), i));
                }
            }
            // 如果有一个失败则认为校验失败
            if (errors.size() > 0) {
                return new ArrayOutput(null, new SomeFailedError(errors));
            } else {
                return new ArrayOutput(input, null);
            }
        };
    }
}
