import java.util.*;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        // Sample books
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
