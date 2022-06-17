package numberGuessGame;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private GuessNumber(){
    }

    public static void start() {
        //Firstly, we need a target number, we can generate a random number ranging from 1 to 100
        Random r = new Random();
        int i = r.nextInt(100) + 1;

        while (true){
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter the number you want to guess (form 1 to 100):");
            int guessNumber=sc.nextInt();

            if (guessNumber>i){
                System.out.println("The number you guessed is: "+guessNumber+" too large");
            }else if (guessNumber<i){
                System.out.println("The number you guessed is: "+guessNumber+" too small");
            }else{
                System.out.println("Congratulations, you guessed it!");
                break;
            }
        }

    }
}
