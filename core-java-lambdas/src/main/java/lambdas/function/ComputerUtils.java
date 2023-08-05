package lambdas.function;

import java.util.ArrayList;
import java.util.List;

public class ComputerUtils {

    static final ComputerPredicate after2010Predicate = (c -> (c.getAge() > 2010));
    static final ComputerPredicate blackPredicate = (c) -> "black".equals(c.getColor());

    public static List<Computer> filter(final List<Computer> inventory, final ComputerPredicate p) {
        List<Computer> result = new ArrayList<>();
        inventory.stream().filter(c -> p.filter(c)).forEach(result::add);

        return result;
    }

    public static void repair(final Computer computer) {
        if (computer.getHealty() < 50) {
            computer.setHealty(100);
        }
    }
}
