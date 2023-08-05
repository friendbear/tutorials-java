package stream;

import lombok.Data;

@Data
public class Product {
    private int price;
    private String name;
    private boolean utilize;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }
}
