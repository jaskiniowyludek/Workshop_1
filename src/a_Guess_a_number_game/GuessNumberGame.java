package a_Guess_a_number_game;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {

        int number = getRandomNumber(100);
        int userNumber = 0;
        System.out.println("Type a number between 1 and 100");
        Scanner scan = new Scanner(System.in);
        do {
            while (!scan.hasNextInt()){
                scan.next();
                System.out.println("That is not a number! Try again!");
            }
            userNumber = scan.nextInt();
            if (userNumber<number){
                System.out.println("Your number is too small!");
            }else if (userNumber>number){
                System.out.println("Your number is too big!");
            }
        }while (userNumber!=number);
                System.out.println("That's right, you guessed it.");

    }
    static int getRandomNumber(int range){
        Random r = new Random();
        int number = r.nextInt(range)+1;
        return number;
    }

}
