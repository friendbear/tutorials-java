package generics;

import org.junit.Test;

import java.io.Serializable;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class GenericsConstructorUnitTest {

    @Test
    public void givenNonGenericConstructor_whenCreateNonGenericEntry_thenOK() {

        Entry entry = new Entry("sample", 1);

        assertEquals("sample", entry.getData());
        assertEquals(1, entry.getRank());
    }

    @Test
    public void givenGenericConstructor_whenCreateEntry_thenOK() {
        GenericsEntry<Product> productGenericsEntry = new GenericsEntry<>(
                new Product("pc", 10),
               5);

        assertEquals("pc", productGenericsEntry.getData().getName());
        assertEquals(5, productGenericsEntry.getRank());
    }

    @Test
    public void givenGenericConstructorWithWildCard_whenCreateGenericEntry_thenOK() {
        Product product = new Product("milk", 2.5);
        product.setSales(30);
        Optional<Product> optional = Optional.of(product);

        GenericsEntry<Serializable> entry = new GenericsEntry<Serializable>(optional);
        assertEquals(product, entry.getData());
        assertEquals(30, entry.getRank());
    }
}
