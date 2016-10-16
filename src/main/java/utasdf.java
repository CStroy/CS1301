import java.util.Scanner;

/**
 * Created by troy.hill on 10/4/16.
 */
public class utasdf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Whats your weight");
        double weight = scanner.nextDouble();
        System.out.println("Whats your height");
        double height = scanner.nextDouble();

        double bmi = (weight * 703)/ (height * height);

        if((int)bmi >= 25){
            System.out.println("Overweight");
        }
        else if ((int)bmi > 17 && (int)bmi < 25){
            System.out.println("Normal");
        }
        else{
            System.out.println("You dead");
        }
    }
}
