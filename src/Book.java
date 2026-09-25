public class Book {
    private int id;
    private String title, author, category;
    private boolean available = true;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void display() {
        System.out.println(id + " | " + title + " | " + author +
                " | " + category + " | " +
                (available ? "Available" : "Borrowed"));
    }
}