package lambdas.functionalinterface;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfaceUnitTest {

    private static Logger LOGGER = LoggerFactory.getLogger(FunctionalInterfaceUnitTest.class);

    @Test
    public void whenPassingLambdaToComputeIfAbsent_thenTheValueGetsComputedAndPutIntoMap() {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);

        assertEquals(4, value.intValue());
    }
}
