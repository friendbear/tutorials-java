package generics;

public class Entry {
    private String data;
    private int rank;

    public Entry(String data, int rank) {
        this.data = data;
        this.rank = rank;
    }

    public <E extends Rankable> Entry(E element) {
        this.data = element.toString();
        this.rank = element.getRank();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
