import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nNew round! Try to guess the secret number between 1 and 100.");
            while (!hasGuessedCorrectly && attempts < 10) { // Limiting attempts to 10
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/10): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the secret number " + secretNumber + " correctly!");
                    score += 10 - attempts; // Score based on remaining attempts
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + secretNumber);
            }

            System.out.print("Your current score: " + score);
            System.out.println("\nDo you want to play again? (yes/no)");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }

    
}
