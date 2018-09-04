package c_Guess_a_number_2_game;

import java.util.Scanner;

public class GuessNumberGame2 {
    public static void main(String[] args) {
        System.out.println("Dear user! Think a number between 0 and 1000 and " +
                "I will try to guess it in max 10 attempts. \n" +
                "If the number I guess is too small, please type \"too small\", " +
                "if it is too big, please type \"too big\"," +
                "if I guessed, please type \"Bingo!\".\n Type \"start\" if you are ready!");
        Scanner scan = new Scanner(System.in);
        String start = "start";
        int min = 0;
        int max = 1000;
        int counter = 0;
        String answer = "";
        int guess = ((max-min)/2)+min;
        String tooSmall = "too small";
        String tooBig = "too big";
        String bingo = "Bingo!";
        while (scan.hasNext()){
            if (scan.next().equals(start)){
                System.out.println("Attempt n."+(counter+1)+" The number you thought is: "+guess);
                counter++;
                break;
        }else System.out.println("Type \" start\" if you are ready");
        }
        do {
            if (counter>=1 && (answer.equals(tooBig)||answer.equals(tooSmall))){
                guess = ((max-min)/2)+min;
                System.out.println("Attempt n."+(counter+1)+" The number you thought is: "+guess);
                counter++;
            }
            while (scan.hasNextLine()){
                answer = scan.nextLine();
                if (answer.equals(tooBig)||answer.equals(tooSmall)||answer.equals(bingo)){
                    break;
                }else System.out.println("Please, type \"too small\", \"too big\" or \"Bingo!\"");
            }
            if (answer.equals(bingo)){
                System.out.println("I won!");
                break;
            }else if (answer.equals(tooBig)){
                max=guess;
               // System.out.println("Wartość counter to: "+counter);
            }else if (answer.equals(tooSmall)){
                min = guess;
               // System.out.println("Wartość counter to: "+counter);
            }
        }while (!(counter==10));

        System.out.println("Game over!");
    }
}
