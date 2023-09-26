import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Objects;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
     System.out.println("Welcome to MasterMind!");
    Scanner i = new Scanner (System.in);
Random r = new Random();

boolean mastermind = true;

  firstloop:  while (mastermind){
    
    System.out.println("Would you like to begin? 1 for yes, 2 for no");
    int decision = i.nextInt();

    if (decision == 1){
      mastermind = true;
    }
    else{
      mastermind = false;
    System.out.println("Have a good day!");
    }

    System.out.print("Enter the number of pegs <1 - 10>: ");
        int pegNum = i.nextInt();
        
        System.out.print("Enter the number of peg colors <1 - 9>: ");
        int pegColour = i.nextInt();

        Mastermind game = new Mastermind(pegNum, pegColour);
        
        // Initialize the secret code
        int[] secretCode = generateSecretCode(pegNum, pegColour);

        int maxAttempts = 10;
        int remainingAttempts = maxAttempts;
        int guessnum = 0;

        System.out.println("You have " + maxAttempts + " attempts to guess the secret code.");

        while (remainingAttempts > 0) {
            // Get user's guess
          guessnum ++;
          System.out.println("Guess: "+ guessnum);
            int[] guess = getGuessFromPlayer(pegNum, pegColour, i);

            // Check the guess against the secret code
            int[] result = compareCodes(secretCode, guess);

            // Display the result
          
            displayGuessResult(guess, result);

            // Check if the player has guessed the code
            if (Arrays.equals(secretCode, guess)) {
                System.out.println("Congratulations! You've cracked the code.");
                break;
            }

           // remainingAttempts--;
           // System.out.println("Remaining attempts: " + remainingAttempts);
        }

        if (remainingAttempts == 0) {
            System.out.println("Game over! You've used all your attempts. The secret code was " + Arrays.toString(secretCode) + ".");
        }

        i.close();

  }// end while
  }// end main

  private static void displayGuessResult(int[] guess, int[] result) {
    System.out.println("Result: ");
    for (int i : result) {
        if (i == 2) {
            System.out.println("Correct ");
        } else if (i == 1) {
            System.out.println("Misplaced ");
        } else {
            System.out.println( "Incorrect ");
        }
    }
    System.out.println();
  }

    private static int[] generateSecretCode(int pegNum, int pegColour) {
        Random random = new Random();
        int[] code = new int[pegNum];
        for (int i = 0; i < pegNum; i++) {
            code[i] = random.nextInt(pegColour) + 1;
        }
        return code;
    }

private static int[] getGuessFromPlayer(int pegNum, int pegColour, Scanner i) {
    int[] guess = new int[pegNum];
    System.out.println("Enter your guess:");
    for (int x = 0; x < pegNum; x++) {
        System.out.print("Color for peg " + (x + 1) + ": "); // This line has been added
        guess[x] = i.nextInt();
    }
    return guess;
}

    private static int[] compareCodes(int[] secretCode, int[] guess) {
    int[] result = new int[secretCode.length];

    for (int i = 0; i < secretCode.length; i++) {
      
        if (secretCode[i] == guess[i]) {
            result[i] = 2; // Digit in correct position
        } else if (containsDigit(secretCode, guess[i])) {
            result[i] = 1; // Digit in wrong position
        } else {
            result[i] = 0; // Digit not in code
        }
    }
    return result;
}

private static boolean containsDigit(int[] code, int digit) {
    for (int i : code) {
        if (i == digit) {
            return true;
        }
    }
    return false;
}

}// end class 
