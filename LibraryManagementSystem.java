import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    @Override
    public String toString() {
        return id + ". " + title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        // Add some books
        books.add(new Book(1, "The Alchemist", "Paulo Coelho"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Show all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Book b : books) {
                        System.out.println(b);
                    }
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    for (Book b : books) {
                        if (b.getId() == borrowId) {
                            b.borrowBook();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    for (Book b : books) {
                        if (b.getId() == returnId) {
                            b.returnBook();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
