public class Main {
    public static void main(String[] args) {
        System.out.println("iniciando pruebas...");

        Library bib = new Library("mi biblioteca");

        Author a1 = new Author("garcia marquez", "colombia", 1927);
        Book b1 = new Book("cien anios", "111", "garcia marquez", 1967);
        Book b2 = new Book("1984", "333", "orwell", 1949);

        bib.addAuthor(a1);
        bib.addBook(b1);
        bib.addBook(b2);

        System.out.println("libros cargados: " + bib.getBooks().size());

        System.out.println("\nbuscando 'amor':");
        LinkedList<Book> res = bib.findBooksByTitle("amor");
        if (res.isEmpty()) System.out.println("no se encontraron libros");

        System.out.println("\nvalidando historial de prestamos:");
        Book l = bib.findBookByIsbn("333");
        
        if (l != null) {
            l.lend("pepe");
            System.out.println("prestado a pepe. actual: " + l.getLastLoanUser());
            
            l.undoLastLoan();
            System.out.println("deshacer prestamo. disponible: " + l.getAvailable());
            
            l.lend("ana");
            System.out.println("prestado a ana. actual: " + l.getLastLoanUser());
        }

        bib.removeBook(b1);
        if (bib.findBookByIsbn("111") == null) {
            System.out.println("\nlibro eliminado correctamente");
        }

        bib.getBooks().clear();
        System.out.println("lista vaciada. size: " + bib.getBooks().size());
        
        System.out.println("\npruebas finalizadas.");
    }
}