package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StreamIndicesUnitTest {

    @Test
    public void whenCalled_thenReturnListOfIndexedStrings() {
        String[] names = {"Afrim", "Bashkim", "Besim", "Lulzim", "Durim", "Shpetim"};
        List<String> expectedResult = Arrays.asList("Afrim", "Besim", "Durim");
        List<String> actualResult = StreamIndices.getEvenIndexedStrings(names);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void givenList_whenCalled_thenReturnOfOddIndexedStrings() {
        String[] names = {"Afrim", "Bashkim", "Besim", "Lulzim", "Durim", "Shpetim"};
        List<String> expectedResult = Arrays.asList("Bashkim", "Lulzim", "Shpetim");
        List<String> actualResult = StreamIndices.getOddIndexedStrings(names);
        assertEquals(expectedResult, actualResult);
    }

}
