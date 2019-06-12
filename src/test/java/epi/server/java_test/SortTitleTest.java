package epi.server.java_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author huyvv92
 * 20/05/2019, 10:45 PM
 * contact me: huyvv92@gmail.com
 */
public class SortTitleTest {
    private static final String AUTHOR_DATA = "data/authors.csv";
    private static final String BOOK_DATA = "data/books.csv";
    private static final String MAGAZINE_DATA = "data/magazines.csv";

    @Test
    void Test1(){
        List<PaperEntity> books = new ArrayList<>();
        books = (List<PaperEntity>)(List<?>) Utils.readData(BOOK_DATA, Book.class);
        List<PaperEntity> magazines = new ArrayList<>();
        magazines = (List<PaperEntity>)(List<?>) Utils.readData(MAGAZINE_DATA, Magazine.class);
        List<PaperEntity> all = new ArrayList<>();
        all.addAll(books);
        all.addAll(magazines);
        Utils.sortPaperEntity(all);

        assertEquals("Das Perfekte Dinner. Die besten Rezepte", books.get(3).getTitle());
        assertEquals("Vinum", magazines.get(5).getTitle());
    }
}
