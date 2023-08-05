package lambdas.function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class ComputerUtilsUnitTest {

    @Before
    public void setup() {

    }
    @After
    public void tearDown() {

    }
    @Test
    public void testConstructorReference() {

        List<Computer> inventory = Arrays.asList(
                new Computer(2015, "white", 35),
                new Computer(2009, "black",  65),
                new Computer(2014, "black", 90)
        );
        List<Computer> computers = ComputerUtils.filter(inventory, ComputerUtils.after2010Predicate);
        assertThat(computers.size()).isEqualTo(2);

        computers = ComputerUtils.filter(inventory, ComputerUtils.blackPredicate);
        assertThat(computers.size()).isEqualTo(2);

        computers = ComputerUtils.filter(inventory, c -> (c.getHealty() == 100));
        assertThat(computers.size()).isEqualTo(0);

        inventory.forEach(ComputerUtils::repair);

        assertEquals(100, inventory.get(0).getHealty().intValue());

    }
}
