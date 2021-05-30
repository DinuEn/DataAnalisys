import java.util.List;

public class DataUtilThread implements Runnable {
    private List<String> data;
    // functionCode = 0 => averageLength()
    // functionCode = 1 => maxLength()
    // functionCode = 2 => minLength()
    // functionCode = 3 => mostFrequentChar()
    private int functionCode;
    private int result;
    private char resultChar;

    DataUtilThread() {}

    public DataUtilThread(List<String> data, int functionCode) {
        this.data = data;
        this.functionCode = functionCode;
    }

    DataUtilThread(List<String> data) {
        this.data = data;
    }

    public void setData(List<String> data) {
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
        //long start = System.currentTimeMillis();
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
                DataUtilSingleThread.frequency(data);
                break;
        }
        //long stop = System.currentTimeMillis();
        //System.out.println("Threadul a durat " + (stop - start) + " ms");
    }
}
