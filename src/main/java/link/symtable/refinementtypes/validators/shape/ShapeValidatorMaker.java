package link.symtable.refinementtypes.validators.shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import link.symtable.refinementtypes.errors.InvalidShapeError;
import link.symtable.refinementtypes.errors.NotMapError;
import link.symtable.refinementtypes.errors.ShapeValidateErrorItem;
import link.symtable.refinementtypes.results.AnyResult;
import link.symtable.refinementtypes.validators.AnyValidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 描述一个map中，有哪些字段
 */
public class ShapeValidatorMaker {
    public static AnyValidator make(Schema schema) {
        return input -> {
            if (!input.isObject()) {
                return new ShapeOutput(null, new NotMapError());
            }
            // schema 可能会嵌套，要对schema和input 遍历进行验证
            List<ShapeValidateErrorItem> errors = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode sanitizedValue = objectMapper.createObjectNode();

            Iterator<Entry<String, JsonNode>> it = input.fields();
            Map<String, JsonNode> inputMap = new HashMap<>();
            while (it.hasNext()) {
                Entry<String, JsonNode> entry = it.next();
                inputMap.put(entry.getKey(), entry.getValue());
            }

            for (String field : schema.keySet()) {
                JsonNode inputFieldVal = inputMap.getOrDefault(field, null);
                AnyValidator fieldValidator = schema.get(field);
                AnyResult validateResult = fieldValidator.validate(inputFieldVal);
                if (validateResult.isError()) {
                    errors.add(new ShapeValidateErrorItem(validateResult.getError(), field));
                } else if (validateResult.getData() != null) {
                    sanitizedValue.put(field, validateResult.getData());
                }
            }


            if (errors.size() > 0) {
                return new ShapeOutput(null, new InvalidShapeError(errors));
            } else {
                return new ShapeOutput(sanitizedValue, null);
            }
        };
    }
}
