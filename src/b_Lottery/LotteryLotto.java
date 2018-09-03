package b_Lottery;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LotteryLotto {
    public static void main(String[] args) {

        int[] userNumbers = get6NumberOfUser();
        int[] lotteryNumbers = get6RandomNumbers();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i<userNumbers.length;i++){
            sb.append(userNumbers[i]).append(" ");
        }
        for (int i = 0; i<lotteryNumbers.length;i++){
            sb2.append(lotteryNumbers[i]).append(" ");
        }
        System.out.println("Your selected numbers: "+sb.toString());
        System.out.println("Lotto numbers are: "+sb2.toString());
        int counter = 0;
        for (int i =0; i<userNumbers.length; i++){
            for (int j = 0; j<lotteryNumbers.length;j++){
                if (userNumbers[i]==lotteryNumbers[j]){
                    counter++;
                }
            }
        }
        if (counter<3){
            System.out.println("Sorry! You haven't won anything. To win you have to guess at least 3 numbers! Try again and good luck!");
        }else System.out.println("Congrats! You guessed: "+counter+" numbers!");
    }

    static int[] get6NumberOfUser() {
        int[] userNumbers = new int[6];
        int number = 0;
        int counter = 0;
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
                userNumbers[counter]=number;
                counter++;
              //  System.out.println("Licznik to:"+licznik);
            }

        }
            while (userNumbers[5] == 0) ;
            Arrays.sort(userNumbers);
            return userNumbers;
        }

        static int[] get6RandomNumbers(){
        //Integer[]	arr	=	new	Integer[49];
            //for	(int	i	=	0;	i	<	arr.length;	i++)	{
            //		arr[i]	=	i	+	1;
            //}
            //System.out.println(Arrays.toString(arr));
            //Collections.shuffle(Arrays.asList(arr));
            //System.out.println(Arrays.toString(arr));
            int[] randomNumbers = new int[6];
            Random r = new Random();
            int number = 0;
            for (int i = 0; i<randomNumbers.length; i++){
                number =r.nextInt(49)+1;
                if (number==randomNumbers[i]){
                    i--;
                }else randomNumbers[i]=number;
            }
            Arrays.sort(randomNumbers);
            return randomNumbers;
        }
    }

