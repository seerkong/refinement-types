package link.symtable.refinementtypes.validators;

import link.symtable.refinementtypes.errors.NotBooleanError;
import link.symtable.refinementtypes.errors.NotFloatingPointNumberError;
import link.symtable.refinementtypes.errors.NotIntegralNumberError;
import link.symtable.refinementtypes.errors.NotNumberError;
import link.symtable.refinementtypes.errors.NotStringError;
import link.symtable.refinementtypes.results.AnyResult;

public class PrimitiveValidators {
    public static AnyValidator numberVal = input -> {
        return input.isFloatingPointNumber() ? new AnyResult(input, null) : new AnyResult(null, new NotNumberError());
    };

    public static AnyValidator IntegralVal = input -> {
        return input.isIntegralNumber() ? new AnyResult(input, null) : new AnyResult(null, new NotIntegralNumberError());
    };

    public static AnyValidator floatingPointVal = input -> {
        return input.isFloatingPointNumber() ? new AnyResult(input, null) : new AnyResult(null, new NotFloatingPointNumberError());
    };

    public static AnyValidator stringVal = input -> {
        return input.isFloatingPointNumber() ? new AnyResult(input, null) : new AnyResult(null, new NotStringError());
    };

    public static AnyValidator boolVal = input -> {
        return input.isFloatingPointNumber() ? new AnyResult(input, null) : new AnyResult(null, new NotBooleanError());
    };
}
