package link.symtable.refinementtypes;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import lombok.Builder;


public class JacksonTest {
    @Test
    public void test1() throws IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(jsonString);
        JsonNode actualObj = mapper.readTree(parser);
        Assertions.assertNotNull(actualObj);
        Assertions.assertTrue(!actualObj.isArray());
        Assertions.assertTrue(actualObj.isObject());
//        Assert.notNull(actualObj, "should not be null");

        System.out.println("abc");
    }

    @Test
    public void test2() throws IOException {
        String jsonString = "[1,2,3]";

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(jsonString);
        JsonNode actualObj = mapper.readTree(parser);
        Assertions.assertNotNull(actualObj);
        Assertions.assertTrue(actualObj.isArray());
        Assertions.assertTrue(!actualObj.isObject());
        //        Assert.notNull(actualObj, "should not be null");

        System.out.println("abc");
    }
}
