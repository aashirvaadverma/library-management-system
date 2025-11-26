package model;

import java.time.LocalDate;

/**
 * Represents a book issue/return transaction.
 */
public class Loan {
    private final String loanId;     // e.g., L001
    private final Book book;
    private final Member member;
    private final LocalDate issueDate;
    private LocalDate returnDate;

    public Loan(String loanId, Book book, Member member, LocalDate issueDate) {
        this.loanId = loanId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
    }

    public String getLoanId() { return loanId; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void markReturned(LocalDate returnDate) { this.returnDate = returnDate; }
    public boolean isReturned() { return returnDate != null; }

    @Override
    public String toString() {
        return "Loan[" + loanId + "] Book=" + book.getId()
                + ", Member=" + member.getMemberId()
                + ", Issued=" + issueDate
                + ", Returned=" + (returnDate == null ? "NO" : returnDate);
    }
}
