package lambdas.functionalinterface;

@FunctionalInterface
public interface ShortToByteFunction {
    byte applyAsByte(short s);
}
