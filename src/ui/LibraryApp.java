package ui;

import model.Book;
import model.Loan;
import model.Member;
import service.LibraryService;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Console-based UI for the Library Management System.
 */
public class LibraryApp {

    private final LibraryService libraryService;
    private final Scanner scanner;

    public LibraryApp() {
        this.libraryService = new LibraryService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }

    private void run() {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int choice = readInt("Enter choice: ");
            switch (choice) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> searchBooks();
                case 4 -> addMember();
                case 5 -> listMembers();
                case 6 -> issueBook();
                case 7 -> returnBook();
                case 8 -> listLoans();
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        System.out.println("Exiting Library Management System. Goodbye!");
    }

    private void printMainMenu() {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Add Book");
        System.out.println("2. List Books");
        System.out.println("3. Search Books by Title");
        System.out.println("4. Add Member");
        System.out.println("5. List Members");
        System.out.println("6. Issue Book");
        System.out.println("7. Return Book");
        System.out.println("8. List Loans");
        System.out.println("0. Exit");
    }

    // --------- Menu handlers ---------
    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine().trim();

        Book book = libraryService.addBook(title, author);
        System.out.println("Book added: " + book);
    }

    private void listBooks() {
        Collection<Book> books = libraryService.listBooks();
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("---- Books ----");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void searchBooks() {
        System.out.print("Enter keyword in title: ");
        String keyword = scanner.nextLine().trim();
        List<Book> books = libraryService.searchBooksByTitle(keyword);
        if (books.isEmpty()) {
            System.out.println("No books matched your search.");
            return;
        }
        System.out.println("Search results:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter member email: ");
        String email = scanner.nextLine().trim();

        Member member = libraryService.addMember(name, email);
        System.out.println("Member added: " + member);
    }

    private void listMembers() {
        Collection<Member> members = libraryService.listMembers();
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("---- Members ----");
        for (Member m : members) {
            System.out.println(m);
        }
    }

    private void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String bookId = scanner.nextLine().trim();
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine().trim();

        var loan = libraryService.issueBook(bookId, memberId);
        if (loan == null) {
            System.out.println("Cannot issue book. Check IDs or availability.");
        } else {
            System.out.println("Book issued: " + loan);
        }
    }

    private void returnBook() {
        System.out.print("Enter Loan ID to return: ");
        String loanId = scanner.nextLine().trim();
        boolean ok = libraryService.returnBook(loanId);
        if (ok) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid loan ID or book already returned.");
        }
    }

    private void listLoans() {
        Collection<Loan> loans = libraryService.listLoans();
        if (loans.isEmpty()) {
            System.out.println("No loans recorded.");
            return;
        }
        System.out.println("---- Loans ----");
        for (Loan l : loans) {
            System.out.println(l);
        }
    }

    // --------- Input helpers ---------
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
    }
}
