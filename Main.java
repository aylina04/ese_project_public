import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Main class implements a menu-driven system for managing books and customers in a library.
 */
public class Main {
    private static ArrayList<Customer> customers; // List to store customers
    private static ArrayList<Book> books; // List to store books
    private static ArrayList<BookCopy> bookCopies; // List to store book copies

    public static void main(String[] args) {
        initializeSampleData(); // Initialize sample data for testing

        Scanner scan = new Scanner(System.in);

        System.out.println("Main Menu:");
        System.out.println("| 1: Books | 2: Book Copies | 3: Customers |");

        int choice = getUserChoice(scan, 3); // Get user's menu choice

        if (choice == 1) {
            handleBooksMenu(scan);
        } else if (choice == 2) {
            handleBookCopiesMenu(scan);
        } else if (choice == 3) {
            handleCustomersMenu(scan);
        }
    }

    /**
     * Retrieves the user's menu choice and validates it within the specified range.
     *
     * @param scan The Scanner object to read user input.
     * @param max  The maximum valid menu choice.
     * @return The user's valid menu choice.
     */
    private static int getUserChoice(Scanner scan, int max) {
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            if (choice < 1 || choice > max) {
                System.out.println("Invalid choice. Please enter a number between 1 and " + max + ".");
            }
        } while (choice < 1 || choice > max);
        return choice;
    }

    /**
     * Handles the choice selected from the Books menu.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void handleBooksMenu(Scanner scan) {
        System.out.println("Books Menu:");
        System.out.println("| 1: Search by ISBN | 2: Delete by ISBN | 3: Search by Title | 4: Delete by Title |");

        int choice = getUserChoice(scan, 4);

        switch (choice) {
            case 1:
                searchBookByISBN(scan);
                break;
            case 2:
                deleteBookByISBN(scan);
                break;
            case 3:
                searchBookByTitle(scan);
                break;
            case 4:
                deleteBookByTitle(scan);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Handles the choice selected from the Book Copies menu.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void handleBookCopiesMenu(Scanner scan) {
        System.out.println("Book Copies Menu:");
        System.out.println("| 1: Search by ID | 2: Delete by ID |");

        int choice = getUserChoice(scan, 2);

        switch (choice) {
            case 1:
                searchBookCopyByID(scan);
                break;
            case 2:
                deleteBookCopyByID(scan);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Handles the choice selected from the Customers menu.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void handleCustomersMenu(Scanner scan) {
        System.out.println("Customers Menu:");
        System.out.println("| 1: Search by ID | 2: Delete by ID |");

        int choice = getUserChoice(scan, 2);

        switch (choice) {
            case 1:
                searchCustomerByID(scan);
                break;
            case 2:
                deleteCustomerByID(scan);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Searches for a book by its ISBN number.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void searchBookByISBN(Scanner scan) {
        System.out.print("Enter the ISBN: ");
        String isbn = scan.next();

        ArrayList<Book> matchingBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                matchingBooks.add(book);
            }
        }

        if (matchingBooks.isEmpty()) {
            System.out.println("No books found with the given ISBN.");
        } else {
            System.out.println("Matching books:");
            for (Book book : matchingBooks) {
                System.out.println(book);
            }
        }
    }

    /**
     * Deletes a book by its ISBN number.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void deleteBookByISBN(Scanner scan) {
        System.out.print("Enter the ISBN: ");
        String isbn = scan.next();

        boolean deleted = false;

        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                books.remove(book);
                deleted = true;
                System.out.println("Book deleted successfully.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("No book found with the given ISBN.");
        }
    }

    /**
     * Searches for a book by its title.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void searchBookByTitle(Scanner scan) {
        System.out.print("Enter the title: ");
        String title = scan.next();

        ArrayList<Book> matchingBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                matchingBooks.add(book);
            }
        }

        if (matchingBooks.isEmpty()) {
            System.out.println("No books found with the given title.");
        } else {
            System.out.println("Matching books:");
            for (Book book : matchingBooks) {
                System.out.println(book);
            }
        }
    }

    /**
     * Deletes a book by its title.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void deleteBookByTitle(Scanner scan) {
        System.out.print("Enter the title: ");
        String title = scan.next();

        boolean deleted = false;

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                deleted = true;
                System.out.println("Book deleted successfully.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("No book found with the given title.");
        }
    }

    /**
     * Searches for a book copy by its ID.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void searchBookCopyByID(Scanner scan) {
        System.out.print("Enter the ID: ");
        String id = scan.next();

        ArrayList<BookCopy> matchingCopies = new ArrayList<>();

        for (BookCopy copy : bookCopies) {
            if (copy.getID().equals(id)) {
                matchingCopies.add(copy);
            }
        }

        if (matchingCopies.isEmpty()) {
            System.out.println("No book copies found with the given ID.");
        } else {
            System.out.println("Matching book copies:");
            for (BookCopy copy : matchingCopies) {
                System.out.println(copy);
            }
        }
    }

    /**
     * Deletes a book copy by its ID.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void deleteBookCopyByID(Scanner scan) {
        System.out.print("Enter the ID: ");
        String id = scan.next();

        boolean deleted = false;

        for (BookCopy copy : bookCopies) {
            if (copy.getID().equals(id)) {
                bookCopies.remove(copy);
                deleted = true;
                System.out.println("Book copy deleted successfully.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("No book copy found with the given ID.");
        }
    }

    /**
     * Searches for a customer by their ID.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void searchCustomerByID(Scanner scan) {
        System.out.print("Enter the ID: ");
        String id = scan.next();

        ArrayList<Customer> matchingCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                matchingCustomers.add(customer);
            }
        }

        if (matchingCustomers.isEmpty()) {
            System.out.println("No customers found with the given ID.");
        } else {
            System.out.println("Matching customers:");
            for (Customer customer : matchingCustomers) {
                System.out.println(customer);
            }
        }
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param scan The Scanner object to read user input.
     */
    private static void deleteCustomerByID(Scanner scan) {
        System.out.print("Enter the ID: ");
        String id = scan.next();

        boolean deleted = false;

        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                customers.remove(customer);
                deleted = true;
                System.out.println("Customer deleted successfully.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("No customer found with the given ID.");
        }
    }

    /**
     * Initializes the sample data for customers, books, and book copies.
     */
    private static void initializeSampleData() {
        customers = new ArrayList<>(); // Initialize customers list
        books = new ArrayList<>(); // Initialize books list
        bookCopies = new ArrayList<>(); // Initialize book copies list

        // Add sample customers
        customers.add(new Customer("c1", "John Doe"));
        customers.add(new Customer("c2", "Max Mustermann"));
        customers.add(new Customer("c3", "Jane Smith"));
        customers.add(new Customer("c4", "Emily Johnson"));
        customers.add(new Customer("c5", "Michael Brown"));

        books.add(new Book("978-3-7306-0000-9", "The Great Gatsby", "F. Scott Fitzgerald", "Novel"));
        books.add(new Book("978-0-8212-2312-3", "Im Westen nichts Neues", "Erich Maria Remarque", "Novel"));
        books.add(new Book("978-8-4397-0315-0", "Kujo", "Stephen King", "Horror"));
        books.add(new Book("978-0-8212-2312-3", "The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        books.add(new Book("978-0-3991-2896-7", "Dune", "Frank Herbert", "Science Fiction"));
        books.add(new Book("978-0-2978-5938-3", "Gone Girl", "Gillian Flynn", "Thriller"));
        books.add(new Book("978-0-3120-2282-2", "The Silence of the Lambs", "Thomas Harris", "Thriller"));

        // Add sample book copies
        bookCopies.add(new BookCopy("bc1", books.get(0)));
        bookCopies.add(new BookCopy("bc2", books.get(1)));
        bookCopies.add(new BookCopy("bc3", books.get(1)));
        bookCopies.add(new BookCopy("bc4", books.get(2)));
        bookCopies.add(new BookCopy("bc5", books.get(3)));
        bookCopies.add(new BookCopy("bc6", books.get(4)));
        bookCopies.add(new BookCopy("bc7", books.get(6)));
        bookCopies.add(new BookCopy("bc8", books.get(1)));
    }

    /**
     * Represents a Customer entity in the library.
     */
    private static class Customer {
        private String id;
        private String name;

        /**
         * Constructs a Customer object with the specified ID and name.
         *
         * @param id   The customer's ID.
         * @param name The customer's name.
         */
        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * Gets the customer's ID.
         *
         * @return The customer's ID.
         */
        public String getID() {
            return id;
        }

        @Override
        public String toString() {
            return "Customer [ID: " + id + ", Name: " + name + "]";
        }
    }

    /**
     * Represents a Book entity in the library.
     */
    private static class Book {
        private String isbn;
        private String title;
        private String author;
        private String genre;

        /**
         * Constructs a Book object with the specified ISBN, title, author, and genre.
         *
         * @param isbn   The book's ISBN.
         * @param title  The book's title.
         * @param author The book's author.
         * @param genre  The book's genre.
         */
        public Book(String isbn, String title, String author, String genre) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.genre = genre;
        }

        /**
         * Gets the book's ISBN.
         *
         * @return The book's ISBN.
         */
        public String getISBN() {
            return isbn;
        }

        /**
         * Gets the book's title.
         *
         * @return The book's title.
         */
        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Book [ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + "]";
        }
    }

    /**
     * Represents a BookCopy entity in the library.
     */
    private static class BookCopy {
        private String id;
        private Book book;

        /**
         * Constructs a BookCopy object with the specified ID and associated book.
         *
         * @param id   The book copy's ID.
         * @param book The associated book.
         */
        public BookCopy(String id, Book book) {
            this.id = id;
            this.book = book;
        }

        /**
         * Gets the book copy's ID.
         *
         * @return The book copy's ID.
         */
        public String getID() {
            return id;
        }

        @Override
        public String toString() {
            return "BookCopy [ID: " + id + ", Book: " + book.getTitle() + "]";
        }
    }
}
