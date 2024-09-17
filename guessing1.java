import java.util.Random;
import java.util.Scanner;
public class guessing1{
    private static final int ATTEMPTS = 5;
    private static final int LOWER=1;
    private static final int UPPER=100;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        boolean playAgain;
        int totalRounds = 0;
        int totalScore = 0;

        do{
            int numbertoGuess=generateRandomNumber(LOWER, UPPER);
            boolean correct=false;
            int attempts=0;

            System.out.println("Guess the number between "+LOWER+" and "+UPPER+":");
            
            while(attempts<ATTEMPTS)
            {
                attempts++;
                System.out.print("Attempt "+attempts+": ");
                int userGuess=scanner.nextInt();
                if (userGuess<LOWER||userGuess>UPPER)
                {
                    System.out.println("Please guess a number within the specified range.");
                }
                else if (userGuess==numbertoGuess)
                {
                    correct = true;
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    break;
                }
                else if (userGuess<numbertoGuess)
                {
                    System.out.println("Too low! Try again.");
                }
                else
                {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!correct)
            {
                System.out.println("Sorry, you've used all your attempts. The number was: "+numbertoGuess);
            }
            totalRounds++;
            int score = calculateScore(attempts,correct);
            totalScore+=score;
            System.out.println("Your score for this round: "+score);
            System.out.println("Total score: "+totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }while (playAgain);
        System.out.println("Thank you for playing! Final score: " + totalScore);
        scanner.close();
    }
    private static int generateRandomNumber(int lowerBound, int upperBound)
    {
        Random random = new Random();
        return random.nextInt(upperBound-lowerBound+1)+lowerBound;
    }
    private static int calculateScore(int attempts, boolean isCorrect)
    {
        if (isCorrect)
        {
            return Math.max(0, ATTEMPTS - attempts + 1);
        }
        else
        {
            return 0;
        }
    }
}



/*Output:-

 Guess the number between 1 and 100:
Attempt 1: 50
Too high! Try again.
Attempt 2: 30
Too high! Try again.
Attempt 3: 20
Too low! Try again.
Attempt 4: 25
Too high! Try again.
Attempt 5: 23
Too high! Try again.
Sorry, you've used all your attempts. The number was: 21
Your score for this round: 0
Total score: 0
Do you want to play another round? (yes/no): yes
Guess the number between 1 and 100:
Attempt 1: 50
Too high! Try again.
Attempt 2: 25
Too low! Try again.
Attempt 3: 40
Too high! Try again.
Attempt 4: 35
Too high! Try again.
Attempt 5: 30
Too low! Try again.
Sorry, you've used all your attempts. The number was: 34
Your score for this round: 0
Total score: 0
Do you want to play another round? (yes/no):
 */