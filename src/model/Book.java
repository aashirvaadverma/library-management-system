package model;

/**
 * Represents a single book in the library.
 */
public class Book {
    private final String id;      // e.g., B001
    private String title;
    private String author;
    private boolean available;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author +
                " (Available: " + available + ")";
    }
}
