package epi.server.java_test;

/**
 * @author huyvv92
 * 20/05/2019, 7:20 PM
 * contact me: huyvv92@gmail.com
 */
public class Author extends Entity{
    private String email;
    private String firstName;
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void print(){
        System.out.format("%30s %30s %30s", this.getEmail(), this.getFirstName(), this.getLastName());
        System.out.println();
    }
}
