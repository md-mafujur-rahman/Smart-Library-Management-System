import java.util.*;
import java.io.*;

public class Library implements Borrowable {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added.");
    }

    public void registerMember(Member m) {
        members.add(m);
        System.out.println("Member registered.");
    }

    public void displayBooks() {
        for (Book b : books)
            if (b.isAvailable()) b.display();
    }

    public void searchBook(String title) {
        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.display();
                found = true;
            }
        }

        if (!found) System.out.println("Book not found.");
    }

    private Book findBook(int id) throws BookNotFoundException {
        for (Book b : books)
            if (b.getId() == id) return b;

        throw new BookNotFoundException("Book does not exist.");
    }

    public void borrowBook(int id) {
        try {
            Book b = findBook(id);

            if (!b.isAvailable())
                throw new BookUnavailableException(
                        "Book is already borrowed.");

            b.setAvailable(false);
            System.out.println("Book borrowed successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int id) {
        try {
            Book b = findBook(id);
            b.setAvailable(true);
            System.out.println("Book returned successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveData() {
        try {
            FileWriter f = new FileWriter("books.txt");

            for (Book b : books)
                f.write(b.getId() + "," + b.getTitle() + "," +
                        b.isAvailable() + "\n");

            f.close();
            System.out.println("Data saved.");

        } catch (IOException e) {
            System.out.println("File error.");
        }
    }

    public void loadData() {
        try {
            File file = new File("books.txt");

            if (!file.exists()) return;

            Scanner s = new Scanner(file);

            while (s.hasNextLine())
                System.out.println("Loaded: " + s.nextLine());

            s.close();

        } catch (Exception e) {
            System.out.println("File error.");
        }
    }
}