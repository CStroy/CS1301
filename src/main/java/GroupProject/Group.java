package GroupProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by troy.hill on 10/11/16.
 */
public class Group {
    private static Map people = new HashMap();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    public static int displayOptionsAndGetSelection() {
        System.out.println("Please select an option from below: ");
        System.out.println("Option 1: Records peoples fines");
        System.out.println("Option 2: Sort people");
        System.out.println("Option 3: Display current data,");
        System.out.println("Option 4: ");
        System.out.println("Option 5: ");
        System.out.println("Option 6: ");
        System.out.println("Option 7: ");

        System.out.println("\nPlease enter 1 - 7 to select an option");
        Scanner input = new Scanner(System.in);
        int i =  input.nextInt();
        return i;
    }


    public static void makeSelection(int option){
        switch (option){
            case 1:
                option1();
                break;
            case 2:
                option1();
                break;
            case 3:
                option3();
                break;
            case 5:
                option5();
                break;
        }
    }

    public static void option1() {
        boolean done = false;
        while (!done){
            done = addPerson();
        }
        System.out.println("Ok, make a new selection");
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    public static void option3() {
        System.out.println(people);
        System.out.println("Ok, make a new selection");
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    /**
     * Sorts by person name
     */
    public static void option2() {
        //perform sort
    }

    public static void option5(){
        System.out.println(" Please enter the person you would like to modify ");
        String name = input.nextLine();
        if(people.containsKey(name)){
            System.out.println("Please enter the new fine type: ");
            String fineType = input.nextLine();
            System.out.println("Please enter the new fine amount: ");
            double fineAmount = Double.parseDouble(input.nextLine());
            replaceName(name, fineType, fineAmount);
        }
        System.out.println("Ok, make a new selection");
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }
    /**
     * replace fine and amount
     */
    public static void replaceName(String name, String newFineType, double newFineAmount){
        people.remove(name);
        PersonFine updatedPerson = new PersonFine(name, newFineType, newFineAmount);

    }
    /**
     * Returns true if person enters "Q" in first question
     * @return
     */
    public static boolean addPerson(){
        //Get Name
        System.out.println("Enter the Name: ");
        String name = input.nextLine();

        if(!name.equals("Q")){
            System.out.println("Enter the type: ");
            String type = input.nextLine();

            System.out.println("Enter the fine amount: ");
            double fineAmount = Double.parseDouble(input.nextLine());

            PersonFine person = new PersonFine(name, type, fineAmount);
            people.put(name, person.getValuesWithoutName());
            return false;
        }
        else {
            return true;
        }
    }
}
