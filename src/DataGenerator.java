import java.util.ArrayList;
import java.util.Random;

public interface DataGenerator {

    static ArrayList<String> generateArray(int lengthOfArray, int maxLengthWord, int minLengthWord){

        ArrayList<String> generatedData = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < lengthOfArray; i++){
            int noOfCharacters = rand.nextInt(maxLengthWord - minLengthWord + 1) + minLengthWord; //generare numar random intre minLengthWord si maxLengthWord
            char[] auxCharArray = new char[noOfCharacters];
            for(int j = 0; j < noOfCharacters; j++){
                char character = (char)(rand.nextInt(26) + 'a'); //generare caracter random
                auxCharArray[j] = character;
            }
            generatedData.add(String.valueOf(auxCharArray));
        }

        return generatedData;
    }
}
