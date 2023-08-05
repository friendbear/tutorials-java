package generics;

import java.io.Serializable;
import java.util.Optional;

public class GenericsEntry<T> {

    private T data;
    private int rank;

    public GenericsEntry(int rank) {
        this.rank = rank;
    }

    public GenericsEntry(T data, int rank) {
        this.data = data;
        this.rank = rank;
    }

    public <E extends Rankable & Serializable> GenericsEntry(E element) {
        this.data = (T) element;
        this.rank = element.getRank();
    }

    public GenericsEntry(Optional<? extends Rankable> optional) {
        if (optional.isPresent()) {
            this.data = (T) optional.get();
            this.rank = optional.get().getRank();
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
