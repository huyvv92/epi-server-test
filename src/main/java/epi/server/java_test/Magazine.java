package epi.server.java_test;

/**
 * @author huyvv92
 * 20/05/2019, 7:34 PM
 * contact me: huyvv92@gmail.com
 */
public class Magazine extends PaperEntity{
    public void print(){
        System.out.format("%20s %50s %50s %100s",
                this.getTitle(), this.getIsbn(), this.getAuthorRaw(), this.getPublicationDate());
        System.out.println();
    }
}
