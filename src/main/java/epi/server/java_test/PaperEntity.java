package epi.server.java_test;

import java.util.Set;

/**
 * @author huyvv92
 * 20/05/2019, 7:20 PM
 * contact me: huyvv92@gmail.com
 */
public class PaperEntity extends Entity{
    private String title;
    private String isbn;
    private String authorRaw;
    private Set<Author> authors;
    private String description;
    private String publicationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthorRaw() {
        return authorRaw;
    }

    public void setAuthorRaw(String authorRaw) {
        this.authorRaw = authorRaw;
    }

    public void print(){
        System.out.format("%30s %30s %30s", this.getTitle(), this.getIsbn(), this.getAuthorRaw());
        System.out.println();
    }
}
