package epi.server.java_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author huyvv92
 * 20/05/2019, 7:02 PM
 * contact me: huyvv92@gmail.com
 */
public class ReadDataTest {

    private static final String AUTHOR_DATA = "data/authors.csv";
    private static final String BOOK_DATA = "data/books.csv";
    private static final String MAGAZINE_DATA = "data/magazines.csv";

    @Test
    void Test1(){
        List<Author> authors = new ArrayList<>();
        authors = (List<Author>)(List<?>) Utils.readData(AUTHOR_DATA, Author.class);

        assertEquals("pr-walter@optivo.de", authors.get(0).getEmail());
        assertEquals("Paul", authors.get(0).getFirstName());
        assertEquals("Walter", authors.get(0).getLastName());

        assertEquals("pr-rabe@optivo.de", authors.get(5).getEmail());
        assertEquals("Harald", authors.get(5).getFirstName());
        assertEquals("Rabe", authors.get(5).getLastName());
    }

    @Test
    void Test2(){
        List<PaperEntity> books = new ArrayList<>();
        books = (List<PaperEntity>)(List<?>) Utils.readData(BOOK_DATA, Book.class);

        assertEquals("Das Perfekte Dinner. Die besten Rezepte",
                books.get(3).getTitle());
        assertEquals("2221-5548-8585", books.get(3).getIsbn());
        assertEquals("pr-lieblich@optivo.de", books.get(3).getAuthorRaw());

        assertEquals("Schuhbecks Kochschule. Kochen lernen mit Alfons Schuhbeck ",
                books.get(7).getTitle());
        assertEquals("1215-4545-5895", books.get(7).getIsbn());
        assertEquals("pr-walter@optivo.de", books.get(7).getAuthorRaw());
    }

    @Test
    void Test3(){
        List<PaperEntity> magazines = new ArrayList<>();
        magazines = (List<PaperEntity>)(List<?>) Utils.readData(MAGAZINE_DATA, Magazine.class);

        assertEquals("Meine Familie und ich",
                magazines.get(1).getTitle());
        assertEquals("4545-8541-2012", magazines.get(1).getIsbn());
        assertEquals("pr-mueller@optivo.de", magazines.get(1).getAuthorRaw());
        assertEquals("10.07.2006", magazines.get(1).getPublicationDate());

        assertEquals("Vinum",
                magazines.get(5).getTitle());
        assertEquals("1313-4545-8875", magazines.get(5).getIsbn());
        assertEquals("pr-gustafsson@optivo.de", magazines.get(5).getAuthorRaw());
        assertEquals("23.02.2004", magazines.get(5).getPublicationDate());
    }
}
