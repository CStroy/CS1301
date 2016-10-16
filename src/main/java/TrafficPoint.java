import java.util.Scanner;

/**
 * Created by troy.hill on 10/4/16.
 */
public class TrafficPoint {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(printFine(getPoints()));
    }

    public static int getPoints() {
        System.out.println("Hello Officer\nEnter points: ");
        return input.nextInt();
    }

    public static String printFine(int points) {
        if (points >=5) {
            return "Go to Jail";
        }
        else if (points == 4) {
            return "Fine = 300";
        }
        else if (points == 3) {
            return "Fine = 200";
        }
        else if (points == 2) {
            return "Fine = 100";
        }
        else{
            return "No Fine!";
        }
    }


}
