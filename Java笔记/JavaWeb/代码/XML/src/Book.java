import java.math.BigDecimal;

public class Book {
    private String sn;
    private  String name;
    private String author;
    private double price;

    public Book() {
    }

    public Book(String sn, String name, String author, double price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
