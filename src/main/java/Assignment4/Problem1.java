package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by troy.hill on 10/27/16.
 */
public class Problem1 {

    public static void main(String[] args) throws FileNotFoundException{

        // First do problem 1
        String home = System.getProperty("user.home");
//        File miles = new File(home + File.separator + "Desktop" + File.separator + "miles.txt");
//        Scanner scanner = new Scanner(miles);
//        frequentFlier(scanner);
//        System.out.println();

        // Problem 2
        File words = new File(home + File.separator + "Desktop" + File.separator + "words.txt");
        Scanner scanner = new Scanner(words);
        printDuplicates(scanner);
        System.out.println();

        // Problem 3
        File coins = new File(home + File.separator + "Desktop" + File.separator + "coins.txt");
        scanner = new Scanner(coins);
        coinFlip(scanner);
        System.out.println();

        // Problem 4
        File lines = new File(home + File.separator + "Desktop" + File.separator + "lines.txt");
        scanner = new Scanner(lines);
        flipLines(scanner);
        System.out.println();

        // Problem 5
        File sum = new File(home + File.separator + "Desktop" + File.separator + "sum.txt");
        scanner = new Scanner(sum);
        runningSum(scanner);
        System.out.println();
    }

    public static void frequentFlier(Scanner scanner) {
        int totalMiles = 0;
        int miles = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] record = line.split(" ");
            miles = Integer.valueOf(record[1]);
            switch (record[0]){
                case "coach":
                    totalMiles = totalMiles + miles;
                    break;
                case "firstclass":
                    totalMiles = totalMiles + (miles * 2);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Frequent Flier Mileage: " + totalMiles);
    }

    public static void printDuplicates(Scanner scanner) {
        while (scanner.hasNextLine()) {

            // Create variables needed for the for loop
            String duplicateWord = null;
            int duplicateOccurrences = 1;
            String line = scanner.nextLine();
            String[] record = line.split(" ");
            boolean hadDup = false;

            // Check each word with the next word, mark it as a dup if it matches else move on to the next word
            for (int i = 1; i < record.length; i++) {
                    // Checking the prior word to the current word.If there is a match increment the duplicate occurrences and store the prior word.
                    if(record[i - 1].equals(record[i])){
                        duplicateOccurrences+=1;
                        duplicateWord = record[i - 1];
                        hadDup = true;
                    }
                    else{
                        if(hadDup) {
                            System.out.println("The word: " + duplicateWord + " Had " + duplicateOccurrences + " duplcate occurences");
                        }
                        hadDup = false;
                        duplicateOccurrences = 1;
                        duplicateWord = null;
                    }
            }
            if(hadDup){
                System.out.println("The word: " + duplicateWord + " Had " + duplicateOccurrences + " duplcate occurences");
            }
        }
    }

    public static void coinFlip(Scanner scanner) {
        // take in the scanner and add the heads and tails to a list
        double heads = 0;
        double tails = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] record = line.split(" ");
            for (String rec: record) {
                if(rec.equalsIgnoreCase("h")){
                    heads +=1;
                }
                else if(rec.equalsIgnoreCase("t")){
                    tails +=1;
                }
                else {
                    System.out.println("Something is wrong. you added the value: " + rec);
                }
            }
            System.out.println("Heads: " + ((int) heads) + " (" + (heads *10) + "%)");
            if ((heads / record.length) > .5){
                System.out.println("You Win!");
            }
        }
    }

    public static void flipLines(Scanner scanner) {
        ArrayList<String> lines = new ArrayList<>();
        int lastValueOfI = 0;
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        for (int i = 1; i < lines.size(); i+=2) {
            System.out.println(lines.get(i));
            System.out.println(lines.get(i - 1));
            lastValueOfI = i;
            }
        if(lines.size() % 2 != 0){
            System.out.println(lines.get(lastValueOfI + 1));
        }
    }

    public static void runningSum(Scanner scanner) {
        double maxSum = 0;
        double currentSum = 0;
        while (scanner.hasNextLine()) {
           String line = scanner.nextLine();
           String[] number = line.split(" ");
           for (String rec: number) {
               double currentValue = Double.parseDouble(rec);
               System.out.print(currentSum = currentSum + currentValue);
               System.out.print(" ");
               if(maxSum < currentSum ){
                   maxSum = currentSum;
               }
           }
           System.out.println(maxSum);
       }
    }
}
