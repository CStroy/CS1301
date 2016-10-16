import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by troy.hill on 10/4/16.
 */
public class Class {

    public static void main(String[] args) {

        percentage(getGrade());
    }

    public static int getGrade(){
        System.out.println("What is your grade: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void percentage(int grade) {
        if (grade >= 90){
            if (grade > 100){
                System.out.println("YOUR LYING!");
            }
            else{
                System.out.println("Your grade is A");
            }
        }
        else if(grade >= 80){
            System.out.println("Your grade is B");
        }
        else if(grade >= 70){
            System.out.println("Your grade is C");
        }
        else if(grade >= 60){
            System.out.println("Your grade is D");
        }
        else if(grade < 60){
            System.out.println("Your grade is F");
        }
    }


}
