import java.util.*;

public class NumberGuessingGame {
    static ArrayList<Integer> PreviousScores = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame method = new NumberGuessingGame();
        method.menu(PreviousScores);
    }

    public void menu(ArrayList<Integer> PreviousScores) {
        NumberGuessingGame method = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number guessing game");
        System.out.println("1) Play the Game");
        System.out.println("2) Previous Scores");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int menu = input.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("\n" + "What would you like the range of the numbers to be? ");
                    int numberRange = input.nextInt();
                    int RandomNumber = method.RandomNumber(numberRange);
                    method.guessNumber(RandomNumber);
                    break;
                case 2:
                    method.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n" + "Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menu(PreviousScores);
        }
    }

    public int RandomNumber(int numberRange) {
        Random random = new Random();
        int RandomNumber = random.nextInt(numberRange) + 1;
        return RandomNumber;
    }

    public void guessNumber(int RandomNumber) {
        Scanner input = new Scanner(System.in);
        int Guess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            Guess = input.nextInt();
            guess++;
            if (Guess > RandomNumber) {
                System.out.println("Lower");
            } else if (Guess < RandomNumber) {
                System.out.println("Higher");
            }
        } while (RandomNumber != Guess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        PreviousScores.add(guess);
        System.out.println(" ");

        menu(PreviousScores);
    }

    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Previous Scores");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " + "\n");
        Collections.sort(PreviousScores);
        for (Integer scores : PreviousScores) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(PreviousScores);
    }
}