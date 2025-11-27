
public class Library {
    private String name;
    private LinkedList<Book> books;
    private LinkedList<Author> authors;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
        this.authors = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addBook(Book book) {
        if (book != null) {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean addAuthor(Author author) {
        if (author != null) {
            authors.add(author);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public LinkedList<Book> findBookByDescription(String title) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().contains(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> availableBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> loanedBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (!book.getAvailable()) {
                loanedBooks.add(book);
            }
        }
        return loanedBooks;
    }

    public String getStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;
        int loanedBooks = 0;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAvailable()) {
                availableBooks++;
            } else {
                loanedBooks++;
            }
        }

        return String.format(
                "estadísticas de la biblioteca:\n" +
                        "- total de libros: %d\n" +
                        "- libros disponibles: %d\n" +
                        "- libros prestados: %d\n",
                totalBooks, availableBooks, loanedBooks);
    }

    @Override
    public String toString() {
        return "biblioteca: " + name + " (" + books.size() + " libros)";
    }
}