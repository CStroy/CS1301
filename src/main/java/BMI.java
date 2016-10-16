import java.util.Scanner;

/**
 * Created by troy.hill on 10/4/16.
 */
public class BMI {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(calculateBmi(getHeight(),getWeight()));
    }

    public static double getHeight(){
        System.out.println("Enter your height: ");
        return scan.nextDouble();
    }

    public static double getWeight(){
        System.out.println("Enter your Weight: ");
        return scan.nextDouble();
    }

    public static String calculateBmi(double height, double weight) {
        double BMI = (weight * 703) / (height * height);

        if ((int)BMI >= 25) {
            return "Overweight";
        }
        else if ((int)BMI > 18 && (int)BMI < 24) {
            return "Normal";
        }
        else{
            return "Your dead";
        }
    }

}
