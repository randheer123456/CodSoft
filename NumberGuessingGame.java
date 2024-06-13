import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 3;
        int totalScore = 0;

        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            int maxAttempts = 5;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + round + ": Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number in " + numberOfAttempts + " attempts.");
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've exhausted your attempts. The number was " + numberToGuess + ".");
            }

            // Scoring: 10 points for correct guess, minus 2 points for each wrong attempt
            int score = hasGuessedCorrectly ? 10 - (numberOfAttempts - 1) * 2 : 0;
            totalScore += score;
            System.out.println("Score for round " + round + ": " + score);
        }

        System.out.println("Game over. Your total score is: " + totalScore);
        scanner.close();
    }
}
