package link.symtable.refinementtypes.validators;

import java.util.Objects;

import link.symtable.refinementtypes.results.AnyResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OptionalValidatorMaker {
    public static AnyValidator make(AnyValidator innerValidator) {
        return input -> {
            if (Objects.isNull(input) || input.isNull()) {
                ObjectMapper objectMapper = new ObjectMapper();
                // 将null 转换为JsonNode中的nullNode, 统一处理
                input = Objects.isNull(input) ? objectMapper.nullNode() : input;
                return new AnyResult(input, null);
            }
            return innerValidator.validate(input);
        };
    }
}
