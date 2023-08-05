package lambdas.function;

@FunctionalInterface
public interface ComputerPredicate {
    boolean filter(Computer c);
}
