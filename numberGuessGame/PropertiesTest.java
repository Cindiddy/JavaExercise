package numberGuessGame;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties prop=new Properties();
        FileReader fr=new FileReader("numberGuessGame/game.txt");

        prop.load(fr);
        fr.close();

        //get the play times from properties
        String count = prop.getProperty("count");
        int number=Integer.parseInt(count);

        //check if the player already played 3 times
        if (number >=3){
            System.out.println("free game is over, if you want to continue playing," +
                    "you can go to www.cindy.com to add more game credits.");
        }else{
            //play game
            GuessNumber.start();

            //play game times need to be added by 1, and we need to store the times to the file
            number++;
            prop.setProperty("count",String.valueOf(number));
            FileWriter fw=new FileWriter("numberGuessGame/game.txt");
            prop.store(fw,null);
            fw.close();
        }
    }
}
