public class Main {
    public static void main(String[] args) {
        System.out.println("sistema de gestion de biblioteca");
        System.out.println("aplicacion iniciada.\n");

        Library library = new Library("biblioteca central");

        Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Cien años de soledad", "978-84-376-0495-4", "Gabriel García Márquez", 1967);
        Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book book4 = new Book("El amor en los tiempos del cólera", "978-84-376-0497-8", "Gabriel García Márquez", 1985);

        Author author1 = new Author("Miguel de Cervantes", "Español", 1547);
        Author author2 = new Author("Gabriel García Márquez", "Colombiano", 1927);
        Author author3 = new Author("George Orwell", "Británico", 1903);

        System.out.println("agregando libros...");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("libros agregados");

        System.out.println("\nagregando autores...");
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        System.out.println("autores agregados");

        System.out.println("\ninformacion de la biblioteca:");
        System.out.println(library);
        System.out.println("\n" + library.getStatistics());

        System.out.println("\nbusqueda por titulo ('amor'):");
        LinkedList<Book> searchResults = library.findBooksByTitle("amor");
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println("  - " + searchResults.get(i));
        }

        System.out.println("\nbusqueda por autor ('García Márquez'):");
        LinkedList<Book> authorBooks = library.findBooksByAuthor("García Márquez");
        for (int i = 0; i < authorBooks.size(); i++) {
            System.out.println("  - " + authorBooks.get(i));
        }

        System.out.println("\nsimulando prestamos:");
        Book foundBook = library.findBookByIsbn("978-84-376-0494-7");
        if (foundBook != null && foundBook.lend()) {
            System.out.println("se presto: " + foundBook.getTitle());
        }

        foundBook = library.findBookByIsbn("978-84-376-0495-4");
        if (foundBook != null && foundBook.lend()) {
            System.out.println("se presto: " + foundBook.getTitle());
        }

        System.out.println("\nlibros disponibles:");
        LinkedList<Book> available = library.getAvailableBooks();
        for (int i = 0; i < available.size(); i++) {
            System.out.println("  - " + available.get(i));
        }

        System.out.println("\nlibros prestados:");
        LinkedList<Book> loaned = library.getLoanedBooks();
        for (int i = 0; i < loaned.size(); i++) {
            System.out.println("  - " + loaned.get(i));
        }

        System.out.println("\nestadisticas finales:");
        System.out.println(library.getStatistics());

        System.out.println("\ndemostracion completada.");
    }
}