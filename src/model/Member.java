package model;

/**
 * Represents a library member (student or user).
 */
public class Member {
    private final String memberId;   // e.g., M001
    private String name;
    private String email;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "[" + memberId + "] " + name + " <" + email + ">";
    }
}
