import java.util.Scanner;

/**
 * Created by troy.hill on 10/4/16.
 */
public class Problesm {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(printFine(getNumSides()));
    }

    public static int getNumSides() {
        System.out.println("Hello\nEnter number of sides to see what shape it is: ");
        return input.nextInt();
    }

    public static String printFine(int sides) {
        if (sides == 3) {
            return "Triangle";
        }
        else if (sides == 4) {
            return "Square";
        }
        else if (sides == 5) {
            return "Polygon";
        }
        else if (sides > 5) {
            return "Unknown Shape";
        }
        else{
            return "Unknown Shape!";
        }
    }


}
