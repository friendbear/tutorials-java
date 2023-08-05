package generics;


import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Rankable, Serializable {

    private String name;
    private double price;
    private int sales;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getRank() {
        return sales;
    }
}
