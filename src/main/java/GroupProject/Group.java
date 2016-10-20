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
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    public static int displayOptionsAndGetSelection() {
        System.out.println("\nPlease select an option from below: \n");
        System.out.println("Option 1: Record fines");
        System.out.println("Option 2: ");
        System.out.println("Option 3: ");
        System.out.println("Option 4: ");
        System.out.println("Option 5: ");
        System.out.println("Option 6: ");
        System.out.println("Option 7: ");

        System.out.println("\nPlease enter 1 - 7 to select an option:\r");
        Scanner input = new Scanner(System.in);
        int i =  input.nextInt();
        return i;
    }


    public static void makeSelection(int option){
        switch (option){
            case 1:
                option1();
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
        }
    }

    //************* OPTIONS **************//

    public static void option1() {
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

    public static void option3() {
        if (option1Selected) {
            String home = System.getProperty("user.home");
            String csvFile = home + File.separator + "Desktop" + File.separator + "people.csv";
            String line = "";
            String csvDelimiter = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] person = line.split(csvDelimiter);

                    System.out.println(person[0] + "," + person[1] + "," + person[2]);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // Get a new Option
        int option = displayOptionsAndGetSelection();
        makeSelection(option);
    }

    public static void option4() {
        boolean found = false;
            // Ask user to enter a search keyword
            System.out.println("Please enter a name to see if they are on the fine list");
            String searchName = input.next();

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

    public static void option5() {
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
    }

    //*********** HELPERS *************//

    /**
     * This method adds a person to a temporary list that then writes to a file once "Q" is typed.
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
        System.out.print("Please wait while the application loads");
        for (int i = 0; i < 3; i++) {
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print(".");
        }
    }
    }


