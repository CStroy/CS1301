/**
 * Created by troy.hill on 10/4/16.
 */
public class PersonObject {

    private String firstName;
    private String lastName;
    private int age;


    public PersonObject(String first, String last, int age){
        this.firstName = first;
        this.lastName = last;
        this.age = age;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
