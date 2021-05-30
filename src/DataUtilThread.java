import java.util.ArrayList;

public class DataUtilThread implements Runnable {
    private ArrayList<String> data;
    // functionCode = 0 => averageLength()
    // functionCode = 1 => maxLength()
    // functionCode = 2 => minLength()
    // functionCode = 3 => mostFrequentChar()
    private int functionCode;
    private int result;
    private char resultChar;

    DataUtilThread() {}

    DataUtilThread(ArrayList<String> data) {
        this.data = data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void setFunctionCode(int functionCode) {
        this.functionCode = functionCode;
    }

    public int getResult() {
        return result;
    }
     
    public char getResultChar() {
        return resultChar;
    }

    @Override
    public void run() {
       switch(functionCode) {
           case 0:
                result = DataUtilSingleThread.averageLength(data);
                break;
           case 1:
                result = DataUtilSingleThread.maxLength(data);
                break;
           case 2:
                result = DataUtilSingleThread.minLength(data);
                break;
           case 3:
                resultChar = DataUtilSingleThread.mostFrequentChar(data);
                break;
       }
    }
}
