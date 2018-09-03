package b_Lottery;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryLotto {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(get6NumberOfUser()));
    }

    static int[] get6NumberOfUser() {
        int[] userNumbers = new int[6];
        int number = 0;
        int licznik = 0;
        int helper1 = 0;
        int helper2 = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Type your number between 1 and 49: ");
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("That is not a number! Try again!");
            }
            number = scan.nextInt();

            if (number < 1 || number > 49) {
                System.out.println("Error! Type a number between 1 and 49");
                              helper1=1;
                              helper2=0;
            } else
                helper1=0;
            helper2=0;
            for (int i = 0;i<userNumbers.length;i++){
                if (number==userNumbers[i]){
                    System.out.println("You have already type this number! Type anotherone!");
                    helper2=1;
                }
            }
            if (helper1==0&&helper2==0){
                userNumbers[licznik]=number;
                licznik++;
                System.out.println("Licznik to:"+licznik);
            }

        }
            while (userNumbers[5] == 0) ;
            return userNumbers;
        }
    }

