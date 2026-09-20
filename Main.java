
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Number=10;
        char choice;
        System.out.println(">>>>>>>>>>Welcome to The guessing Game<<<<<<<<<<");
        while (true) {
            System.out.print("Enter A Number: ");
            int Guess = scanner.nextInt();
            if(Guess<Number){
                System.out.println("Guess Higher");
                System.out.println("Try Again!!");
            }
            else if(Guess>Number){
                System.out.println("Guess Lower");
                System.out.println("Try Again!!");
            }
            else if(Guess==Number){
                System.out.println("Congratulations!! you guessed Right");
                System.out.println("Do you want to play again?");
                System.out.print("Choice(y/n): ");
                choice=scanner.next().charAt(0);

                if(choice=='n'){
                    break;
                }
                
            }

        }
        scanner.close();
    }
}
