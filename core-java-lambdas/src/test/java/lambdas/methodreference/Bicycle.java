package lambdas.methodreference;

import lombok.Data;

@Data
public class Bicycle {
    private String brand;
    private Integer frameSize;

    public Bicycle(String brand, Integer frameSize) {
        this.brand = brand;
        this.frameSize = frameSize;
    }

    public Bicycle(String brand) {
        this.brand = brand;
    }

}
