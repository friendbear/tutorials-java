package stream.primitivestreams;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimitiveStreamUnitTest {
    private PrimitiveStream streams = new PrimitiveStream();

    @Test
    public void givenAnArrayOfIntegersWhenMinIsCalledThenCorrectMinIsReturned() {
        int[] integers = new int[] { 20, 98, 12, 7, 35 };
        int min = streams.min(integers);

        assertEquals(7, min);
    }

    @Test
    public void givenAnArrayOfIntegersWhenAvgIsCalledThenCorrectAvgIsReturned() {
        double avg = streams.avg(20, 98, 12, 7, 35);

        assertTrue(34.4 == avg);
    }

    @Test
    public void givenARangeOfIntegersWhenIntStreamSumIsCalledThenCorrectSumIsReturned() {
        int sum = IntStream.range(1, 10).sum();

        assertEquals(45, sum);
    }

    @Test
    public void givenARangeClosedOfIntegersWhenIntStreamSumIsCalledThenCorrectSumIsReturned() {
        int sum = IntStream.rangeClosed(1, 10).sum();

        assertEquals(55, sum);
    }

    @Test
    public void givenAnArrayWhenSumIsCalledThenTheCorrectSumIsReturned() {
        int sum = Stream.of(33, 45).mapToInt(i -> i).sum();

        assertEquals(78, sum);
    }
}
