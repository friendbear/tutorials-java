package lambdas.sort;

import lambdas.entity.Human;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class Java8SortUnitTest {

    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        final List<Human> humans = List.of(
                new Human("Sarah", 10), new Human("Jack", 12)
        );

        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        assertEquals(humans.get(0), new Human("Jack", 12));
    }

    @Test
    public void givenLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        final List<Human> humans = List.of(
                new Human("Sarah", 10),
                new Human("Jack", 12),
                new Human("Jack", 13),
                new Human("Jack", 9)
        );

        Collections.sort(humans, (h1, h2) -> {
            return h1.getName().compareTo(h2.getName());
        });
        Collections.sort(humans, Comparator.comparing(Human::getName));
        humans.sort(Comparator.comparing(Human::getName));
        humans.sort((c1, c2) -> {
            if (c1.getName().compareTo(c2.getName()) == 0) {
                return Integer.compare(c1.getAge(), c2.getAge());
            } else {
                return c1.getName().compareTo(c2.getName());
            }
        });
        assertEquals(humans.get(0), new Human("Jack", 9));
    }

    @Test
    public final void givenCompositionVerbose_whenSortingEntitiesByNameThenAgeReversed_thenCorrectlySorted() {
        final List<Human> humans = List.of(new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
        final Comparator<Human> byName = (h1, h2) -> h1.getName().compareTo(h2.getName());
        final Comparator<Human> byAge = (h1, h2) -> Integer.compare(h1.getAge(), h2.getAge());
        humans.sort(byName.thenComparing(byAge).reversed());
        assertThat(humans.get(0)).isEqualTo(new Human("Zack", 12));
    }

    @Test
    public void givenStreamNaturalOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<String> letters = List.of("B", "A", "C");
        List<String> reversed = letters.stream().sorted(Comparator.reverseOrder()).toList();
        assertThat(reversed.get(0)).isEqualTo("C");
    }

    @Test
    public void givenStreamComparatorOrdering_whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<Human> humans = List.of(new Human("Sarah",  10), new Human("Jack", 12));

        List<Human> reverseSortedHuman = humans
                .stream()
                .sorted(Comparator.comparing(Human::getName, Comparator.reverseOrder()))
                .toList();

        assertThat(reverseSortedHuman.get(0)).isEqualTo(new Human("Sarah", 10));
    }
}
