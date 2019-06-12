package epi.server.java_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author huyvv92
 * 20/05/2019, 6:55 PM
 * contact me: huyvv92@gmail.com
 */

public class MainApp {
    private static final String AUTHOR_DATA = "data/authors.csv";
    private static final String BOOK_DATA = "data/books.csv";
    private static final String MAGAZINE_DATA = "data/magazines.csv";

    private List<Author> authors = new ArrayList<>();
    private List<PaperEntity> books = new ArrayList<>();
    private List<PaperEntity> magazines = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===== Epi Server Test: The book library =====");
        System.out.println("=============================================");

        MainApp app = new MainApp();
        app.authors = (List<Author>)(List<?>) Utils.readData(AUTHOR_DATA, Author.class);
        app.books = (List<PaperEntity>)(List<?>) Utils.readData(BOOK_DATA, Book.class);
        app.magazines = (List<PaperEntity>)(List<?>) Utils.readData(MAGAZINE_DATA, Magazine.class);

        Utils.convertAuthors(app.books, app.authors);
        Utils.convertAuthors(app.magazines, app.authors);

        System.out.println("1/ Print detail of Books and Magazines");
        System.out.println("Books");
        for(PaperEntity tmp : app.books){
            Book book = (Book) tmp;
            book.print();
        }
        System.out.println("Magazines");
        for(PaperEntity tmp : app.magazines){
            Magazine magazine = (Magazine) tmp;
            magazine.print();
        }
        System.out.println("=====================");

        System.out.println("2/ Find all of book or magazine with an ISBN (example \"5454-5587-3210\")");
        String isbn = "5454-5587-3210";
        List<PaperEntity> searchPaper = new ArrayList<>();
        List<PaperEntity> allPaper = new ArrayList<>();
        allPaper.addAll(app.books);
        allPaper.addAll(app.magazines);
        searchPaper = Utils.searchByIsbn(allPaper, isbn);
        for(PaperEntity entity: searchPaper){
            entity.print();
        }
        System.out.println("=====================");

        System.out.println("3/ Find all book or magazine for an author (example \"Paul\")");
        String nameAuthor = "Paul";
        searchPaper = new ArrayList<>();
        searchPaper = Utils.searchByAuthor(allPaper, nameAuthor);
        for(PaperEntity entity: searchPaper){
            entity.print();
        }
        System.out.println("=====================");

        System.out.println("4/ Sort all book or magazine by Title");
        Collections.sort(allPaper, Comparator.comparing(s -> s.getTitle()));
        for(PaperEntity entity: allPaper){
            System.out.println(entity.getTitle());
        }
    }
}
