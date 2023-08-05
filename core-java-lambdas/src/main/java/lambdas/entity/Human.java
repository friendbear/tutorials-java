package lambdas.entity;

import lombok.Data;

@Data
public class Human {
    private String name;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int age;

    public static int compareByNameThenAge(final Human lhs, final Human rhs)  {
        if (lhs.getName().equals(rhs.getName())) {
            return Integer.compare(lhs.getAge(), rhs.getAge());
        } else {
            return lhs.getName().compareTo(rhs.getName());
        }
    }
}
