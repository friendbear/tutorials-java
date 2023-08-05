package nullsafestreams;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


class NullSafeCollectionStreamsUsingJava8OptionalContainerTest {

    private final NullSafeCollectionStreamsUsingJava8OptionalContainer instance = new NullSafeCollectionStreamsUsingJava8OptionalContainer();

    @Test
    public void whenCollectionIsNull_thenExpectAnEmptyStream() {
        Stream<String> expectedStream = Stream.empty();
        Collection<String> collection = null;
        Stream<String> result = instance.collectionAsStream(null);
        assertStreamEquals(expectedStream, result);
    }

    private static void assertStreamEquals(Stream<?> s1, Stream<?> s2) {
        Iterator<?> iter1 = s1.iterator(), iter2 = s2.iterator();
        while (iter1.hasNext() && iter2.hasNext())
            assertEquals(iter1.next(), iter2.next());
        assert !iter1.hasNext() && !iter2.hasNext();
    }
}