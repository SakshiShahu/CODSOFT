import java.util.*;
public class GuessTheNum {

    public static void main(String[] args) {
        // Create Scanner and Random objects
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Generate a random number between 1 and 100
        int numberToGuess = rand.nextInt(100) + 1;

        // Limit attempts
        int maxAttempts = 5;

        System.out.println("====Welcome to the Number Guessing Game!====");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("----You have " + maxAttempts + " attempts.----");

        // Use a for loop to give the user multiple attempts
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.print("Attempt " + i + ": Enter your guess: ");
            int userGuess = sc.nextInt();

            if (userGuess == numberToGuess) {
                System.out.println(" Correct! You guessed it in " + i + " attempts.");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            if (i == maxAttempts) {
                System.out.println(" You've used all your attempts. The correct number was: " + numberToGuess);
            }
        }
    }
}


