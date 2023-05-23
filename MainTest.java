package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testGetUserChoice(){
        Scanner scan = new Scanner(System.in);
        // Erzeuge eine Testeingabe
        String testInput = "3\n";

        // Leite die Testeingabe an den Scanner um
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        int maxChoice =3;
        int userChoice= Main.getUserChoice(scan,maxChoice);
        int expectedChoice = 3;
        assertEquals(expectedChoice, userChoice, "getUserChoice test failed.");
    }

    @Test
    public void testHandleBooksMenu(){
        // Create Scanner object with input
        Scanner scanner = new Scanner("1");

        // Create a ByteArrayOutputStream to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Redirect System.out to the ByteArrayOutputStream
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        // Call the method
        Main.handleBooksMenu(scanner);

        // Restore original System.out
        System.out.flush();
        System.setOut(originalOut);

        // Assert the output
        String expectedOutput = "Books Menu:\n" +
                "| 1: Search by ISBN | 2: Delete by ISBN | 3: Search by Title | 4: Delete by Title |\n" +
                "Enter your choice: \n"; // Update with expected output

        assertEquals(expectedOutput, outputStream.toString());
        // Example assertions:
        //assertEquals("Enter the ISBN: ", systemOutRule.getLog());
        //assertTrue(systemOutRule.getLog().contains("Book deleted successfully."));

    }

    @Test
    public void testHandleBookCopiesMenu(Scanner scan){

    }

    @Test
    public void testHandleCustomersMenu() {
        Scanner scan = new Scanner(System.in);
        // Erzeuge eine Testeingabe
        String testInput = "1\n";

        // Leite die Testeingabe an den Scanner um
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        // Rufe die handleCustomersMenu-Methode auf und überprüfe das Verhalten
        assertThrows(NumberFormatException.class, () -> Main.handleCustomersMenu(scan));


    }

    @Test
    public void testSearchBookByISBN(){

        String searchByISBN = "123";

        // Create test books
        Main.Book book1 = new Main.Book("978", "Das Lied von Eis und Feuer", "G.R.R.Martin", "Fantasy");
        Main.Book book2 = new Main.Book("123", "Harry Potter", "J.K.Rowling", "Fantasy");
        Main.Book book3 = new Main.Book("456", "Der Herr der Ringe", "Tolkien", "Fantasy");

        // Create list of books
        List<Main.Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Create Scanner object
        Scanner scanner = new Scanner(searchByISBN);

        // Call the method
        Main.searchBookByISBN(scanner);

        // Überprüfe die Suchergebnisse
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Erwartete Ausgabe für den Testfall, dass ein Buch mit der ISBN gefunden wird
        String expectedOutput = "Matching books:\n" +
                "Title: Harry Potter, Author: J.K.Rowling, ISBN: 123, Genre: Fantasy\n";


        // Verify the search
        assertEquals(expectedOutput,outputStream.toString());


    }

    /**
     *
     *
     */
    @Test
    public void testDeleteBookByISBN(){

        // Test input
        String isbnToDelete = "123";

        // Create test books
        Main.Book book1 = new Main.Book("978", "Das Lied von Eis und Feuer", "G.R.R.Martin", "Fantasy");
        Main.Book book2 = new Main.Book("123", "Harry Potter", "J.K.Rowling", "Fantasy");
        Main.Book book3 = new Main.Book("456", "Der Herr der Ringe", "Tolkien", "Fantasy");

        // Create list of books
        List<Main.Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Create Scanner object
        Scanner scanner = new Scanner(isbnToDelete);

        // Call the method
        Main.deleteBookByISBN(scanner);

        // Verify the deletion
        assertEquals(2, books.size());
        assertFalse(books.contains(book1));
        assertTrue(books.contains(book2));
        assertTrue(books.contains(book3));

    }

    @Test
    public void testSearchBookByTitle(Scanner scan){

    }

    /**
     *
     *
     */

    @Test
    public void testDeleteBookByTitle(){
        // Test input
        String titleToDelete = "978";

        // Create test books
        Main.Book book1 = new Main.Book("978", "Das Lied von Eis und Feuer", "G.R.R.Martin", "Fantasy");
        Main.Book book2 = new Main.Book("123", "Harry Potter", "J.K.Rowling", "Fantasy");
        Main.Book book3 = new Main.Book("456", "Der Herr der Ringe", "Tolkien", "Fantasy");

        // Create list of books
        List<Main.Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Create Scanner object
        Scanner scanner = new Scanner(titleToDelete);

        // Call the method
        Main.deleteBookByTitle(scanner);

        // Verify the deletion
        assertEquals(2, books.size());
        assertFalse(books.contains(book1));
        assertTrue(books.contains(book2));
        assertTrue(books.contains(book3));

    }

    @Test
    public void testSearchBookCopyByID(){

    }

    /**
     *
     *
     */
    @Test
    public void testDeleteBookCopyByID(){
        // Test input
        String idToDelete = "bc9";

        //Create books and list of books
        List<Main.Book> books = new ArrayList<>();
        books.add(new Main.Book("978", "Das Lied von Eis und Feuer", "G.R.R.Martin", "Fantasy"));
        books.add(new Main.Book("123", "Harry Potter", "J.K.Rowling", "Fantasy"));
        books.add(new Main.Book("456", "Der Herr der Ringe", "Tolkien", "Fantasy"));

        // Create test book copies
        Main.BookCopy copy1 = new Main.BookCopy("bc9", books.get(0));
        Main.BookCopy copy2 = new Main.BookCopy("bc10", books.get(1));
        Main.BookCopy copy3 = new Main.BookCopy("bc11", books.get(2));
        Main.BookCopy copy4 = new Main.BookCopy("bc11", books.get(2));

        // Create list of book copies
        List<Main.BookCopy> bookCopies = new ArrayList<>();
        bookCopies.add(copy1);
        bookCopies.add(copy2);
        bookCopies.add(copy3);

        // Create Scanner object
        Scanner scanner = new Scanner(idToDelete);

        // Call the method
        Main.deleteBookCopyByID(scanner);

        // Verify the deletion
        assertEquals(2, bookCopies.size());
        assertFalse(bookCopies.contains(copy1));
        assertTrue(bookCopies.contains(copy2));
        assertTrue(bookCopies.contains(copy3));

    }

    @Test
    public void testSearchCustomerByID(Scanner scan){

    }


    /**
     *
     */
    @Test
    public void testDeleteCustomerByID(){
        // Test input
        String idToDelete = "c6";

        // Create test customers
        Main.Customer customer1 = new Main.Customer("c6", "John");
        Main.Customer customer2 = new Main.Customer("c7", "Jane");
        Main.Customer customer3 = new Main.Customer("c8", "Bob");

        // Create list of customers
        List<Main.Customer> testCustomers = new ArrayList<>();
        testCustomers.add(customer1);
        testCustomers.add(customer2);
        testCustomers.add(customer3);

        // Create Scanner object
        Scanner scanner = new Scanner(idToDelete);

        // Call the method
        Main.deleteCustomerByID(scanner);

        // Verify the deletion
        assertEquals(2, testCustomers.size());
        assertFalse(testCustomers.contains(customer1));
        assertTrue(testCustomers.contains(customer2));
        assertTrue(testCustomers.contains(customer3));
    }


}
