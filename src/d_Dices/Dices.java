package d_Dices;

import java.util.StringTokenizer;

public class Dices {
    public static void main(String[] args) {
        String test1 = "a3D100+10+";  //w głównej metody zrobić String diceCode toUpperCase!!
        char[] test1Arr = test1.toCharArray();
        System.out.println(getNumberOfThrows(test1Arr,getIndexOfD(test1Arr)));
        String type = getDiceType(test1Arr,getIndexOfD(test1Arr));
        System.out.println(type);
        System.out.println(getOperator(test1Arr));

      //  getDicesPoints("13D8-10");
    }
    static int getDicesPoints(String diceCode){
        int points = 0;
        int numberOfThrows = 0;
        String diceType = "";
        int lastNumber = 0;
        String[] dices = {"D3", "D4", "D6", "D8", "D10", "D12", "D20", "D100"};
            StringTokenizer st = new StringTokenizer(diceCode,"+-");
            diceType=st.nextToken();
        if (!(diceType.startsWith("D"))){
            int start = diceType.indexOf("D");
            numberOfThrows= Integer.parseInt(diceType.substring(0,start));
            diceType=diceType.substring(start);
        }

        System.out.println(diceType);
        System.out.println(numberOfThrows);
        char[] diceCodeParts = diceCode.toCharArray();

        return points;
    }

    static int getIndexOfD(char[] parts) {
        int indexOfD = 0;
        int counter = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == 'D') {
                counter++;
            }
        }
        if (counter < 1 || counter > 1) {
            System.out.println("The code you introduced is not correct!");
        } else {
            for (int i = 0; i < parts.length; i++) {
                if (parts[i] == 'D') {
                    indexOfD = i;
                }
            }
        }
        return indexOfD;
    }
    static String getDiceType(char[] parts, int index){

        index=getIndexOfD(parts);
        String diceType="";
      //  String[] dices = {"D3", "D4", "D6", "D8", "D10", "D12", "D20", "D100"};
            for (int i =index;i<parts.length;i++){
                diceType= diceType + String.valueOf(parts[i]);
            }
            StringTokenizer st = new StringTokenizer(diceType,"+-");
            diceType=st.nextToken();
            if (!(diceType.equals("D3")||diceType.equals("D4")||diceType.equals("D6")|| diceType.equals("D8")
            ||diceType.equals("D10")||diceType.equals("D12")||diceType.equals("D20")||diceType.equals("D100"))){
                diceType="";
                System.out.println("The code you introduced is not correct! Error in dice type!!");
                }


        return diceType;
    }
    static int getNumberOfThrows(char[] parts, int index){
        int numberOfThrows = 0;
        index=getIndexOfD(parts);
        String number = "";
        if (index>0){
            for (int i =0;i<index;i++){
                number=number+parts[i];
            }
            try {
                numberOfThrows=Integer.parseInt(number);
            }catch (Exception e){
                System.out.println("The code you introduced is not correct! Number of throws should be a number!");
                numberOfThrows=-1;
            }
        }

        return numberOfThrows;
    }
    static char getOperator(char[] parts){

        int index = getIndexOfOperator(parts);
        char operator = '0';
        if (index==-1){
            operator='0';
        }else operator=parts[index];

        return operator;
    }
    static int getIndexOfOperator(char[] parts){
        int indexOfOp = -1;
        int countOperators = 0;
        for (int i = 0; i<parts.length;i++){
            if (parts[i]=='+'){
                countOperators++;
                indexOfOp=i;
            }else if(parts[i]=='-'){
                countOperators++;
                indexOfOp=i;
            }
        }
        if (countOperators>1){
            System.out.println("The code you introduced is not correct! Too many \"+/-\"");
            indexOfOp=-1;
        }else if(countOperators==0){
            indexOfOp=parts.length;
        }
        return indexOfOp;
    }

    static int getLastNumber(char[] parts){
        int number = 0;
        int index = getIndexOfOperator(parts);
        String sameNumber ="";
        if (index==-1||index==parts.length){
            number=0;
        }else {
            for (int i =index+1;i<parts.length;i++){
                sameNumber=sameNumber+parts[i];
            }
            try {
                number = Integer.parseInt(sameNumber);
            }catch (Exception e){
                System.out.println("The code you introduced is not correct! " +
                        "Please, correct number of points to add/subtract!");
                number=0;
            }
        }
        return number;
    }
}
