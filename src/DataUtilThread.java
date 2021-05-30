import java.util.ArrayList;

public class DataUtilThread implements Runnable {
    private ArrayList<String> data;
    // opCode = 0 => averageLength()
    // opCode = 1 => maxLength()
    // opCode = 2 => minLength()
    // opCode = 3 => mostFrequentChar()
    private int opCode;
    private int result;
    private char resultChar;

    DataUtilThread(ArrayList<String> data) {
        this.data = data;
    }

    public void setFunctionCode(int opCode) {
        this.opCode = opCode;
    }

    public int getResult() {
        return result;
    }
     
    public char getResultChar() {
        return resultChar;
    }

    @Override
    public void run() {
       switch(opCode) {
           case 0:
                result = DataUtilSingleThread.averageLength(data);
           case 1:
                result = DataUtilSingleThread.maxLength(data);
           case 2:
                result = DataUtilSingleThread.minLength(data);
           case 3:
                resultChar = DataUtilSingleThread.mostFrequentChar(data);
       }
    }

    
}
