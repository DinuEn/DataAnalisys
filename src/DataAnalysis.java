import java.util.ArrayList;

public class DataAnalysis {
    public static void main(String[] args) {
        ArrayList<String> list= DataGenerator.generateArray(100, 10, 5);
    }

    public static void callSingleThreaded(int functionCode, ArrayList<String> list) {
        int result = 0;
        char resultChar = list.get(0).charAt(0);
        long start = System.currentTimeMillis();
        switch(functionCode) {
           case 0:
                result = DataUtilSingleThread.averageLength(list);
                System.out.println("Lungimea medie este" + result);
                break;
           case 1:
                result = DataUtilSingleThread.maxLength(list);
                System.out.println("Lungimea maxima este" + result);
                break;
           case 2:
                result = DataUtilSingleThread.minLength(list);
                System.out.println("Lungimea minima este" + result);
                break;
           case 3:
                resultChar = DataUtilSingleThread.mostFrequentChar(list);
                System.out.println("Cel mai intalnit caracter este" + resultChar);
                break;
       }
       long stop = System.currentTimeMillis();
       System.out.println("Operatia a durat " + (stop - start) + " ms");
    }
}
