import java.util.ArrayList;

public class DataAnalysis {

    static int noOfThreads = 4;
    static int functionCode = 3;
    public static void main(String[] args) {
        ArrayList<String> list= DataGenerator.generateArray(100000, 10000, 100);
        callSingleThreaded(functionCode, list);
        ThreadManager mngr = new ThreadManager(noOfThreads, list, functionCode);
        long start = System.currentTimeMillis();
        mngr.runThreads();
        long stop = System.currentTimeMillis();
        System.out.println("[" + noOfThreads + " Threaduri" + "] Operatia a durat " + (stop - start) + " ms");
    }

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
