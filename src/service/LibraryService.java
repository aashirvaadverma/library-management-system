package service;

import model.Book;
import model.Loan;
import model.Member;

import java.time.LocalDate;
import java.util.*;

/**
 * Core business logic for managing books, members, and loans.
 */
public class LibraryService {

    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final Map<String, Loan> loans = new HashMap<>();
    private int nextBookId = 1;
    private int nextMemberId = 1;
    private int nextLoanId = 1;

    public LibraryService() {
        seedSampleData();
    }

    // --------- Book operations ---------
    public Book addBook(String title, String author) {
        String id = String.format("B%03d", nextBookId++);
        Book book = new Book(id, title, author);
        books.put(id, book);
        return book;
    }

    public Collection<Book> listBooks() { return books.values(); }
    public Book findBookById(String id) { return books.get(id); }

    public List<Book> searchBooksByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books.values()) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    // --------- Member operations ---------
    public Member addMember(String name, String email) {
        String id = String.format("M%03d", nextMemberId++);
        Member member = new Member(id, name, email);
        members.put(id, member);
        return member;
    }

    public Collection<Member> listMembers() { return members.values(); }
    public Member findMemberById(String id) { return members.get(id); }

    // --------- Loan operations ---------
    public Loan issueBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) return null;
        if (!book.isAvailable()) return null;

        String id = String.format("L%03d", nextLoanId++);
        Loan loan = new Loan(id, book, member, LocalDate.now());
        loans.put(id, loan);
        book.setAvailable(false);
        return loan;
    }

    public boolean returnBook(String loanId) {
        Loan loan = loans.get(loanId);
        if (loan == null || loan.isReturned()) return false;
        loan.markReturned(LocalDate.now());
        loan.getBook().setAvailable(true);
        return true;
    }

    public Collection<Loan> listLoans() { return loans.values(); }

    // --------- Helper: initial data ---------
    private void seedSampleData() {
        addBook("Clean Code", "Robert C. Martin");
        addBook("Effective Java", "Joshua Bloch");
        addBook("Design Patterns", "Erich Gamma");
        addMember("Alice", "alice@example.com");
        addMember("Bob", "bob@example.com");
    }
}
