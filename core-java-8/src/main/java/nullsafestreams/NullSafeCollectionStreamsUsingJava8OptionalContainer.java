package nullsafestreams;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public class NullSafeCollectionStreamsUsingJava8OptionalContainer {

    public <T> Stream<T> collectionAsStream(Collection<T> collection) {
        return Optional.ofNullable(collection)
                .map(Collection::stream)
                .orElseGet(Stream::empty);
    }
}
