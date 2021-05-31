import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

    static int noOfThreads = 12;
    static int functionCode = 2;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Introduceti numarul de threaduri:");
        noOfThreads = s.nextInt();
        System.out.println("Introduceti codul operatiei:");
        functionCode = s.nextInt();

        System.out.println("Precizati dimensiunile pentru generator in ordinea urmatoare: numarul de elemente, dimiensiunea maxima a unui element, apoi dimensiunea minima");
        int lengthOfArray = s.nextInt();
        int maxLengthWord = s.nextInt();
        int minLengthWord = s.nextInt();

        ArrayList<String> list= DataGenerator.generateArray(lengthOfArray, maxLengthWord, minLengthWord);
        callSingleThreaded(functionCode, list);
        ThreadManager mngr = new ThreadManager(noOfThreads, list, functionCode);
        long start = System.currentTimeMillis();
        mngr.runThreads();
        long stop = System.currentTimeMillis();
        System.out.println("[" + noOfThreads + " Threaduri" + "] Operatia a durat " + (stop - start) + " ms");
    }

    //apelarea functiei SingleThreaded
    public static void callSingleThreaded(int functionCode, ArrayList<String> list) {
        int result = 0;
        char resultChar = list.get(0).charAt(0);
        long start = System.currentTimeMillis();
        switch(functionCode) {
           case 0:
                result = DataUtilSingleThread.averageLength(list);
                System.out.println("Lungimea medie este " + result);
                break;
           case 1:
                result = DataUtilSingleThread.maxLength(list);
                System.out.println("Lungimea maxima este " + result);
                break;
           case 2:
                result = DataUtilSingleThread.minLength(list);
                System.out.println("Lungimea minima este " + result);
                break;
           case 3:
                DataUtilSingleThread.frequency(list);
                resultChar = DataUtilSingleThread.mostFrequentChar();
                System.out.println("Cel mai intalnit caracter este " + resultChar);
                break;
       }
       long stop = System.currentTimeMillis();
       System.out.println("[1 Thread] Operatia a durat " + (stop - start) + " ms");
    }
}
