import java.util.Scanner;

public class Tester{

    public static void main(String [] args){
        System.out.println("Enter the word to guess");
        Scanner scan = new Scanner(System.in);
        String inputWord = scan.nextLine();

        String lettersGuessed= "";
        Board board = new Board(inputWord);

        String input;

        boolean correct = false;

        while (true){ /* FIX THIS WHILE LOOP CONDITION */

            int remaining_lives = board.getLives();
  
            if(){
                System.out.println(Hangman.base());
            } 
             
            /**
             *
             * ENTER YOUR CODE HERE
             * NUMBER OF LIVES REMAINING: board.getLives();
             * System.out.println(Hangman.strikeOne());
             * System.out.println(Hangman.strikeTwo());
             *
             */

            board.allLettersFilled()

            if(!board.getIncorrectGuesses().equals("\n")){
                System.out.println("Letters Guessed: " + board.getIncorrectGuesses());
            }

            System.out.println(board.toString());
            System.out.println("Enter your guess");

            input = scan.nextLine();
            input = input.substring(0,1);

            correct = board.setMove(input);
            board.updateNumberOfLives(correct);

            if(!correct){
                lettersGuessed += input + " ";
            }
        }

        if(!correct){
            System.out.println(Hangman.strikeSix());
        }
        else{
            System.out.println(board.toString());
            System.out.println("VICTORY!");
        }
       

    }
}
