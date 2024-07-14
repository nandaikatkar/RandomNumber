//Task submitted for OasisInfobyte
// This Java program implements a number guessing game with a maximum of 3 rounds, 
// each allowing up to 10 attempts to guess a random number between 1 and 100. 
// The program generates a random number for each round and prompts the user to guess the number,
//  providing feedback on whether the guess is too high or too low. If the guess is correct, 
//  the user is awarded points based on the remaining attempts, and the total score is updated. 
//  After all rounds or attempts are completed, the total score is displayed, and the game ends.
//   The Scanner class is used for input, and the Random class generates the random numbers.

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("***NUMBER GUESSING GAME BY ENGINEER***\n");
        System.out.println("Total Number Of Rounds : 3");
        System.out.println("Attempts To Guess Number In Each Round : 10\n");
        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE,
                    MAX_ATTEMPTS);
            while (attempts < MAX_ATTEMPTS) {
                System.out.println("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = MAX_ATTEMPTS - attempts;
                    totalScore = totalScore + score;
                    System.out.printf("YEAHHHH! Number Guessed Successfully. Attempts = %d. Round Score = %d\n",
                            attempts, score);
                    break;
                }

                else if (guess_number < number) {
                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_number,
                            MAX_ATTEMPTS - attempts);
                }

                else if (guess_number > number) {
                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_number,
                            MAX_ATTEMPTS - attempts);
                }

            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }
        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}