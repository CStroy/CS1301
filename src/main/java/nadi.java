import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by troy.hill on 11/13/16.
 */
public class nadi {

    public static void main(String[] args) throws FileNotFoundException{
        // First do problem 1
        String home = System.getProperty("user.home");
        File miles = new File(home + File.separator + "Desktop" + File.separator + "words.txt");
        Scanner scanner = new Scanner(miles);
        printDuplicates(scanner);
        System.out.println();
    }

    public static void printDuplicates(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] word = line.split(" ");

            int wordCount = 0;
            String previousWord = word[0];
            String currentWord = null;

            for (String w:word) {
                if(w.equals(previousWord)){
                wordCount++;}
                else {
                    if(wordCount > 1) {
                        System.out.print(previousWord);
                        System.out.print("*");
                        System.out.print(wordCount);
                        System.out.print(" ");
                    }
                    previousWord = w;
                    wordCount = 1;
                }
            }
            if (wordCount > 1) {
                System.out.print(previousWord);
                System.out.print("*");
                System.out.print(wordCount);
                System.out.print(" ");
            }
        }


    }


    }
