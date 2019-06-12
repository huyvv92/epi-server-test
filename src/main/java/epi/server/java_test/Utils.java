package epi.server.java_test;

import java.io.*;
import java.util.*;

/**
 * @author huyvv92
 * 20/05/2019, 6:56 PM
 * contact me: huyvv92@gmail.com
 */
public class Utils {
    private static final String COMMA_DELIMITER = ",";
    private static final String SEMICOLON_DELIMITER = ";";

    //read raw data
    private static List<List<String>> readDataRaw(String pathFile){
        List<List<String>> records = new ArrayList<>();
        try{
            ClassLoader classLoader = new Utils().getClass().getClassLoader();
            File file = null;
            BufferedReader br = null;
            InputStream in = Utils.class.getClassLoader().getResourceAsStream(pathFile);
            br = new BufferedReader(new InputStreamReader(in, "Cp1252"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(SEMICOLON_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            System.err.println("FileNotFoundException when read file: " + pathFile);
        }catch (IOException ex){
            ex.printStackTrace();
            System.err.println("IOException when read file: " + pathFile);
        }

        if(records.size() > 0) records.remove(0);
        return records;
    }

    //return list of object book, author, magazine ...
    public static List<Entity> readData(String pathFile, Class<?> type){
        List<Entity> records = new ArrayList<>();
        List<List<String>> rawData = readDataRaw(pathFile);
        String className = type.getName();

        for(List<String> data : rawData) {
            if (Book.class.getName().equals(className)) {
                Book book = new Book();
                book.setTitle(data.get(0));
                book.setIsbn(data.get(1));
                book.setAuthorRaw(data.get(2));
                book.setDescription(data.get(3));
                records.add(book);
            } else if (Magazine.class.getName().equals(className)) {
                Magazine magazine = new Magazine();
                magazine.setTitle(data.get(0));
                magazine.setIsbn(data.get(1));
                magazine.setAuthorRaw(data.get(2));
                magazine.setPublicationDate(data.get(3));
                records.add(magazine);
            } else if (Author.class.getName().equals(className)) {
                Author author = new Author();
                author.setEmail(data.get(0));
                author.setFirstName(data.get(1));
                author.setLastName(data.get(2));
                records.add(author);
            }
        }
        return records;
    }

    //convert list of email author to list of Author
    public static void convertAuthors(List<PaperEntity> papers, List<Author> authors){
        Map<String, Author> map = new HashMap<>();
        for(Author author : authors){
            map.put(author.getEmail(), author);
        }

        for(PaperEntity paper : papers){
            Set<Author> setAuthor = new HashSet<>();
            String[] stringAuthors = paper.getAuthorRaw().split(COMMA_DELIMITER);
            for(String string: stringAuthors){
                Author author = map.get(string);
                if(author != null) setAuthor.add(author);
            }
            paper.setAuthors(setAuthor);
        }
    }

    public static List<PaperEntity> searchByIsbn(List<PaperEntity> allPaper, String isbn){
        List<PaperEntity> searchPaper = new ArrayList<>();
        for(PaperEntity entity: allPaper){
            if(entity.getIsbn().contains(isbn)){
                searchPaper.add(entity);
            }
        }
        return searchPaper;
    }

    public static List<PaperEntity> searchByAuthor(List<PaperEntity> allPaper, String nameAuthor){
        List<PaperEntity> searchPaper = new ArrayList<>();
        for(PaperEntity entity: allPaper){
            for(Author tmp : entity.getAuthors()) {
                if (tmp.getLastName().contains(nameAuthor) || tmp.getFirstName().contains(nameAuthor)) {
                    searchPaper.add(entity);
                    break;
                }
            }
        }
        return searchPaper;
    }

    public static void sortPaperEntity(List<PaperEntity> list){
        Collections.sort(list, Comparator.comparing(s -> s.getTitle()));
    }
}
