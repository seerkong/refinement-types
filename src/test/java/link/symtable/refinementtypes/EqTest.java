package link.symtable.refinementtypes;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import link.symtable.refinementtypes.errors.EqualityError;
import link.symtable.refinementtypes.errors.ErrorType;
import link.symtable.refinementtypes.results.Result;
import link.symtable.refinementtypes.validators.AnyValidator;
import link.symtable.refinementtypes.validators.eq.EqValidatorMaker;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class EqTest {
    @Test
    public void defaultValidator() {
        AnyValidator v = EqValidatorMaker.make(new IntNode(1), null);
        Result r1 = v.validate(new IntNode(1));
        Assertions.assertTrue(r1.getData().equals(new IntNode(1)));
        Result r2 = v.validate(new TextNode("1"));
        Assertions.assertTrue(r2.getError() instanceof EqualityError);
        Assertions.assertTrue(((EqualityError)(r2.getError())).getErrorType() == ErrorType.EqualityError);
    }
}
