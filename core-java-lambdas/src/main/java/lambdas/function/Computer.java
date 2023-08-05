package lambdas.function;

public class Computer {
    private Integer age;
    private String color;
    private Integer healty;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHealty() {
        return healty;
    }

    public void setHealty(Integer healty) {
        this.healty = healty;
    }

    public Computer(Integer age, String color, Integer healty) {
        this.age = age;
        this.color = color;
        this.healty = healty;
    }

    public Computer(Integer age, String color) {
        this.age = age;
        this.color = color;
    }

    public void turnOnPc() {
        System.out.println("Computer turned on");
    }

    public void turnOffPc() {
        System.out.println("Computer turned off");
    }

    public Double calculateValue(Double initialValue) {
        return initialValue / 1.50;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Computer computer = (Computer) o;

        return (age != null ? age.equals(computer.age) : computer.age == null) && (color != null ? color.equals(computer.color) : computer.color == null);
    }

    @Override
    public int hashCode() {
        int result = age != null  ? age.hashCode() : 0;
        result  =  31 * result + (color != null ? color.hashCode() : 31);
        return result;
    }

    @Override
    public String toString() {
        return """
                Computer{age=%d, color=%s, healty=%d
                """.formatted(age, color, healty);
    }
}
