package GroupProject;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by troy.hill on 10/11/16.
 */
public class Group {
    private static ArrayList<PersonFine> people = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static boolean option1Selected;

    public static void main(String[] args) {
        startup();
    }

    //************* OPTIONS **************//

    private static void option1() {
        System.out.println("Enter 'Q' when done");
        boolean done = false;
        while (!done){
            done = addPerson();
        }
        System.out.println("\n | Ok, make a new selection | \n");

        // Mark this option as selected
        option1Selected = true;

        // Get a new Option
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    private static void option2() {
        if(option1Selected) {
            String home = System.getProperty("user.home");
            String csvFile = home + File.separator + "Desktop" + File.separator + "people.csv";
            String line = "";
            String csvDelimiter = ",";
            ArrayList<String> unsortedList = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {
                    String[] person = line.split(csvDelimiter);
                    unsortedList.add(person[0]);
                }
                Collections.sort(unsortedList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                File file = new File(home + File.separator + "Desktop" + File.separator + "sorted.csv");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for (String s  : unsortedList) {
                    bw.write(s);
                    bw.newLine();
                }

                bw.close();

                System.out.println("Saving...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Get a new Option
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
        }

    private static void option3() {
        if (option1Selected) {
            String home = System.getProperty("user.home");
            String csvFile = home + File.separator + "Desktop" + File.separator + "people.csv";
            String line = "";
            String csvDelimiter = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] person = line.split(csvDelimiter);
                    System.out.println(person[0] + " | " + person[1] + " | " + person[2]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // Get a new Option
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    private static void option4() {
        boolean found = false;
            // Ask user to enter a search keyword
            System.out.println("Please enter a name to see if they are on the fine list");
            String searchName = input.nextLine();

            String home = System.getProperty("user.home");
            String csvFile = home + File.separator + "Desktop" + File.separator + "people.csv";
            String line = "";
            String csvDelimiter = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] fines = line.split(csvDelimiter);

                    if (fines[0].equals(searchName)) {
                        found = true;
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (found) {
                System.out.println("We found a match");
            } else {
                System.out.println("Sorry, no one matches that name");
            }
            // Get a new Option
            int option = displayOptionsAndGetSelection();
            makeSelection(option);
    }

    private static void option5() {
        String home = System.getProperty("user.home");
        String csvFile = home + File.separator + "Desktop" + File.separator + "people.csv";
        String line = "";
        String csvDelimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            ArrayList<String> peopleList = new ArrayList<>();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] fines = line.split(csvDelimiter);
                peopleList.add(fines[0]);
            }
            System.out.println(peopleList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Get a new Option
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    private static void option6() {
        System.out.println("Please enter the type of ticket you would like to change from the list below:");

        String home = System.getProperty("user.home");
        String csvFile = home + File.separator + "Desktop" + File.separator + "people.csv";
        String line = "";
        String csvDelimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            ArrayList<String> fineTypes = new ArrayList<>();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] types = line.split(csvDelimiter);
                fineTypes.add(types[1]);
            }

            if(fineTypes.isEmpty()){
                System.out.println("Sorry no fines have been entered yet.");
                displayOptionsAndGetSelection();
            }
            System.out.println(fineTypes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String replaceType = input.nextLine();
        // Need to check that input matches one of the types

        System.out.println("What is the new fine type?");
        String newType = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] types = line.split(csvDelimiter);
                if (types[1].equals(replaceType)) {
                    
                }
            }
        }catch (IOException f) {
            f.printStackTrace();
        }

        // Get a new Option
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    private static void option7() {

    }

    //*********** HELPERS *************//

    /**
     * This method lists all of the available options, gets the users input, handles invalid entries, and returns the option to the caller.
     * @return int Option number
     */
    private static int displayOptionsAndGetSelection() {
        System.out.println("\nPlease select an option from below: \n");
        System.out.println("Option 1: Record fines");
        System.out.println("Option 2: Create a sorted list of names");
        System.out.println("Option 3: Display all People, Fines, and Violation");
        System.out.println("Option 4: Search for someone in the Fine Database");
        System.out.println("Option 5: Display only People in the Fine Database");
        System.out.println("Option 6: Replace a ticket type");
        System.out.println("Option 7: ");

        System.out.println("\nPlease enter 1 - 7 to select an option:\r");
        int i;
        try{
            Scanner input = new Scanner(System.in);
            i =  input.nextInt();
            if(i < 1 || i > 7){
                displayOptionsAndGetSelection();
            }
        } catch (InputMismatchException e){
            System.out.println("You entered an invalid response. Please enter between 1 and 7");
            i = -1;
            displayOptionsAndGetSelection();

        }
        return i;
    }

    /**
     * Checks the option that was passed in and calls the proper option method. Passing in a -1 allows a reprompt of options.
     * @param option
     */
    private static void makeSelection(int option){
        switch (option){
            case -1:
                displayOptionsAndGetSelection();
                break;
            case 1:
                option1();
                break;
            case 2:
                option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                option4();
                break;
            case 5:
                option5();
                break;
            case 6:
                option6();
                break;
        }
    }


    /**
     * This method adds a person to a temporary list that then writes to a file once "Q" is typed.
     * @return
     */
    public static boolean addPerson(){
        double fineAmount = 0;
        //Get Name
        System.out.println("Enter the Name: ");
        String name = input.nextLine();

        if(!name.equalsIgnoreCase("Q")){
            System.out.println("Enter the type: ");
            String type = input.nextLine();

            System.out.println("Enter the fine amount: ");
            try{
                fineAmount = Double.parseDouble(input.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Please try again, enter a fine amount in numbers");
                addPerson();
            }


            PersonFine person = new PersonFine(name, type, fineAmount);
            people.add(person);

            System.out.println("Success!, Added " + name + " with a fine of $" + fineAmount + " for " + type + "\n");
            return false;
        }
        else {
            try {
                String home = System.getProperty("user.home");
                File file = new File(home + File.separator + "Desktop" + File.separator + "people.csv");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                for (PersonFine p  : people) {
                    bw.write(p.getName() + "," + p.getType() + "," + p.getFine());
                    bw.newLine();
                }

                bw.close();

                System.out.println("Saving...");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        }
        }

    /**
     * Some stupid startup to make it look like a program
     */
    public static void startup() {
        System.out.println("Welcome to Fine Entry");
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

}




