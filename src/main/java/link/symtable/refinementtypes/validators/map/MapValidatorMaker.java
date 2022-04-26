package link.symtable.refinementtypes.validators.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import link.symtable.refinementtypes.errors.InvalidMapError;
import link.symtable.refinementtypes.errors.MapValidateErrorItem;
import link.symtable.refinementtypes.errors.NotMapError;
import link.symtable.refinementtypes.results.AnyResult;
import link.symtable.refinementtypes.validators.AnyValidator;
import link.symtable.refinementtypes.validators.shape.Schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 校验一个map中，有哪些字段。如果没有约束，认为通过
 */
public class MapValidatorMaker {
    public static AnyValidator make(Schema schema) {
        return input -> {
            if (!input.isObject()) {
                return new MapOutput(null, new NotMapError());
            }
            // schema 可能会嵌套，要对schema和input 遍历进行验证
            List<MapValidateErrorItem> errors = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode sanitizedValue = objectMapper.createObjectNode();

            Iterator<Entry<String, JsonNode>> it = input.fields();
            Map<String, JsonNode> inputMap = new HashMap<>();
            while (it.hasNext()) {
                Entry<String, JsonNode> entry = it.next();
                inputMap.put(entry.getKey(), entry.getValue());
            }
            // 和shap校验的区别在于，以Input的key value为主，遍历input的key，而不是schema的key
            for (String field : inputMap.keySet()) {
                JsonNode inputFieldVal = inputMap.get(field);
                AnyValidator fieldValidator = schema.getOrDefault(field, null);
                // 如果 map中某个key的 validator不存在，认为校验成功
                if (Objects.isNull(fieldValidator)) {
                    sanitizedValue.put(field, inputFieldVal);
                }

                AnyResult validateResult = fieldValidator.validate(inputFieldVal);
                if (validateResult.isError()) {
                    errors.add(new MapValidateErrorItem(validateResult.getError(), field));
                } else if (validateResult.getData() != null) {
                    sanitizedValue.put(field, validateResult.getData());
                }
            }

            if (errors.size() > 0) {
                return new MapOutput(null, new InvalidMapError(errors));
            } else {
                return new MapOutput(sanitizedValue, null);
            }
        };
    }
}
