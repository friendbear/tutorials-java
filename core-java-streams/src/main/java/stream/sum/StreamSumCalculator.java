package stream.sum;

import java.util.List;

public class StreamSumCalculator {

    public static Integer getSumUsingReduce(List<Integer> integers) {
        return integers.stream()
                .reduce(0, Integer::sum);
    }
}
