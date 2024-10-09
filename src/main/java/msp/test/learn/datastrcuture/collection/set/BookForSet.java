package msp.test.learn.datastrcuture.collection.set;

import java.util.Objects;

public class BookForSet {

    public int id;
    public String title;
    public String author;
    public int price;


    public BookForSet(String title, int id, String author, int price) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookForSet{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookForSet that = (BookForSet) o;
        return id == that.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
