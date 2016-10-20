package GroupProject;

import java.util.ArrayList;

/**
 * Created by troy.hill on 10/11/16.
 */
public class PersonFine {

    String name;
    String type;
    double fine;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getFine() {
        return fine;
    }

    public PersonFine(String name, String type, double fine){
        this.name = name;
        this.type = type;
        this.fine = fine;
    }

    public ArrayList getValues(){
        ArrayList<String> values = new ArrayList<>();
        values.add(this.name);
        values.add (this.type);
        values.add(String.valueOf(this.fine));
        return values;
    }

    public ArrayList getValuesWithoutName(){
        ArrayList<String> values = new ArrayList<>();
        values.add (this.type);
        values.add(String.valueOf(this.fine));
        return values;
    }
}
