import java.util.ArrayList;
import java.util.Random;

public interface DataGenerator {

    static ArrayList<String> generateArray(int lengthOfArray, int maxLenghtWord){

        ArrayList<String> generatedData = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < lengthOfArray; i++){
            int noOfCharacters = rand.nextInt(maxLenghtWord + 1);
            char[] auxCharArray = new char[noOfCharacters];
            for(int j = 0; j < noOfCharacters; j++){
                char character = (char)(rand.nextInt(26) + 'a');
                auxCharArray[j] = character;
            }
            generatedData.add(auxCharArray.toString());
        }

        return generatedData;
    }
}
