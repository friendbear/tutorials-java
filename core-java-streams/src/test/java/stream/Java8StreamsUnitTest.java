package stream;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Java8StreamsUnitTest {

    private static Logger log = LoggerFactory.getLogger(Java8StreamsUnitTest.class);
    private List<String> list;
    private List<Product> productList;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");

        productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"), new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));

    }

    @Test
    public void checkStreamCount_whenCreating_givenDifferentSources() {
        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> streamArr = Arrays.stream(arr);
        assertEquals(streamArr.count(), 3);

        Stream<String> streamOf = Stream.of("a", "b", "c");
        assertEquals(streamOf.count(), 3);

        long count = list.stream().distinct().count();
        assertEquals(count, 9);
    }

    @Test
    public void checkStreamCount_whenOperationFilter_thanCorrect() {
        long count = list.stream().filter(v -> v.isEmpty()).count();
        assertEquals(count, 2);
    }

    @Test
    public void checkStreamCount_whenOperationMap_thanCorrect() {
        List<String> uris = new ArrayList<>();
        uris.add("./My.txt");
        Stream<Path> streamMap =  uris.stream().map(uri -> Paths.get(uri));
        assertEquals(streamMap.count(), 1);

        List<Detail> details = new ArrayList<>();
        details.add(new Detail());
        details.add(new Detail());
        Stream<String> streamFlatMap = details.stream().flatMap(detail->detail.getParts().stream());
        assertEquals(streamFlatMap.count(), 4);
    }

    @Test
    public void createStream_whenCreated_thenCorrect() {
        Collection<String> collection = List.of("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        assertEquals(3, streamOfCollection.count());

        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        assertEquals(3, streamOfArray.count());

        String[] arr = new String[] { "a", "b", "c" };
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        assertEquals(2, streamOfArrayPart.count());

        Stream<String> streamBuilder = Stream.<String> builder().add("a").add("b").add("c").build();
        assertEquals(3, streamBuilder.count());

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
//        streamGenerated.forEach(v -> {
//                    log.debug("generate {}", v);
//                });
        assertEquals(10, streamGenerated.count());

        Path path = getPath();
        Stream<String> streamOfStrings = null;
        try {
            streamOfStrings = Files.lines(path);
        } catch (IOException e) {
            log.error("Error creating streams from paths {}", path, e.getMessage(), e);
        }
        assertEquals("a", streamOfStrings.findFirst().get());
    }

    @Test
    public void collecting_whenAsExpected_thenCollect() {
        List<String> collectorCollection = productList.stream().map(Product::getName).toList();
        assertTrue(collectorCollection instanceof List);
        assertEquals(5, collectorCollection.size());

        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));
        assertTrue(listToString.contains(",") && listToString.contains("[") && listToString.contains("]"));

        double averagePrice = productList.stream().collect(Collectors.averagingInt(x -> x.getPrice()));
        assertEquals(17.2, averagePrice, 0.0);

        int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));
        summingPrice = productList.stream().mapToInt(p -> p.getPrice()).sum();
        assertEquals(86, summingPrice);

        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(p -> p.getPrice()));
        assertEquals(23, statistics.getMax());

        Map<String, List<Product>> collectorMapOfList = productList.stream().collect(Collectors.groupingBy(p -> p.getName()));
        assertEquals(5, collectorMapOfList.keySet().size());
    }
    private Path getPath() {
        Path path = null;
        try {
            path = Files.createTempFile(null, ".txt");
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("a\nb\nc");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return path;
    }
}
