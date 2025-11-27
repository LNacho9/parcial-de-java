public class Book {
    private String title;
    private String isbn;
    private String author;
    private int publicationYear;
    private boolean available;
    private int timesLoaned;
    private LinkedList<String> historial;

    public Book(String title, String isbn, String author, int publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
        this.timesLoaned = 0;
        this.historial = new LinkedList<>();
    }

    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public boolean getAvailable() { return available; }
    public int getTimesLoaned() { return timesLoaned; }

    public void setTitle(String title) { this.title = title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setTimesLoaned(int timesLoaned) { this.timesLoaned = timesLoaned; }

    public boolean lend() {
        return lend("usuario generico");
    }

    public boolean lend(String usuario) {
        if (available) {
            available = false;
            timesLoaned++;
            historial.add(usuario);
            return true;
        }
        return false;
    }

    public boolean undoLastLoan() {
        if (!historial.isEmpty()) {
            historial.eliminarUltimo(); 
            available = true;
            if (timesLoaned > 0) timesLoaned--;
            return true;
        }
        return false;
    }

    public String getLastLoanUser() {
        if (!historial.isEmpty()) {
            return historial.obtenerUltimo(); 
        }
        return "nadie";
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        String estado = available ? "disponible" : "prestado";
        if (!available && !historial.isEmpty()) {
            estado += " a " + historial.obtenerUltimo();
        }
        return title + " (" + author + ") - " + estado;
    }
}