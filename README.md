# Library Management System (Java)

A simple console-based Library Management System implemented in Java using object-oriented programming principles. This project automates core library operations such as managing books, members, and transactions for issuing and returning books.

---

## Features

- Add, list, and search books by title
- Register and view members
- Issue books to members with loan tracking
- Return books and update availability
- View loan history and current loans
- Basic validation for book availability and member existence
- Modular and well-documented codebase

---

## Technologies

- Java SE 8+
- Console-based user interface
- Collections Framework (HashMap, List)
- OOP design: entities (Book, Member, Loan), service layer, and UI layer

---

## Project Structure

library-management-system/
├── src/
│ ├── model/ # Domain entities like Book, Member, Loan
│ ├── service/ # Business logic layer (LibraryService)
│ └── ui/ # Console UI (LibraryApp)
└── README.md

---

## How to Compile and Run

1. **Open a terminal and navigate to the project root directory** (where `src` folder is located).

2. **Compile the source files:**

javac -d out src/model/.java src/service/.java src/ui/LibraryApp.java

3. **Run the application:**

java -cp out ui.LibraryApp

4. **Use the console menu to interact with the system.**

---

## Usage Example

- Add new books and members
- Issue a book by providing Book ID and Member ID
- Return a book by entering the Loan ID
- Search books by title keyword
- List all books, members, and loans

---

## Future Enhancements (Optional)

- Add persistent storage (e.g., database)
- Fine management for overdue books
- User authentication and roles
- Graphical user interface (GUI)
- Report generation and statistics

---

Thank you for exploring this Library Management System project!

