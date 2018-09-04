package d_Dices;

import java.util.StringTokenizer;

public class Dices {
    public static void main(String[] args) {

        getDicesPoints("D100-10");
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
}
