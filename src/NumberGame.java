import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static HashMap<Integer,Integer> roundAndScore;

    public static int totalRounds;

    public static int totalScore;

    public static  int attempts;

    public static void main(String[] args) {
        playGame();

    }

    public static void playGame(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Guess the number between 1 and 100... you have 10 attempts");
        int theActualNumber=new Random().nextInt(100)+1;
        int guessedNumber=-1;
        int userAttempts=0;
        totalRounds++;
        attempts=10;
        while(userAttempts<attempts){
            try {
            	System.out.println("Attempt "+ (userAttempts+1)+" : ");
                guessedNumber=scanner.nextInt();
                userAttempts++;

                if (guessedNumber < 1 || guessedNumber > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }
                if (guessedNumber == theActualNumber) {
                    totalScore+=100;
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (guessedNumber < theActualNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }catch (Exception e){
                System.out.println("Please enter a valid number.");
                scanner.nextInt();
            }
            
            
        }

        
        Scanner sc = new Scanner(System.in);
        String anotherRound = "";
        
        while (true) {
            System.out.println("Game over !! Wanna play another round ? y/n");
            anotherRound = sc.nextLine().trim().toLowerCase();
            
            
            if (anotherRound.equals("y")) {
                playGame();
            }
            else if(anotherRound.equals("n")){
                displayScore();
            } else {
                System.out.println("Invalid input, please enter 'y' for yes or 'n' for no:");
            }
        }

    }


    public static void displayScore(){
        System.out.println("Rounds played==> "+totalRounds);
        System.out.println("Score won===> "+totalScore);
        System.exit(0);
    }
}
