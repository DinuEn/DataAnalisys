import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    private ArrayList<Thread> threadArrayList = null;
    private int nOfThreads = 0;
    private ArrayList<String> dataList= null;
    private int functionCode = 0;
    private ArrayList<DataUtilThread> runnableList;


    public ThreadManager(int nOfThreads, ArrayList<String> dataList, int functionCode) {
        this.nOfThreads = nOfThreads;
        this.dataList = dataList;
        this.functionCode = functionCode;
        runnableList = new ArrayList<>();
    }

    public void setThreadArrayList(ArrayList<Thread> threadArrayList) {
            int subListLen = (int) dataList.size() / nOfThreads;
            for(int i = 0; i < nOfThreads; i++){
                List<String> subList = dataList.subList(subListLen * i, subListLen * (i + 1));
                runnableList.add(new DataUtilThread(subList, functionCode));
            }

        this.threadArrayList = ThreadGenerator.generateThreads(nOfThreads, runnableList);
    }

    public void runThreads() {
        setThreadArrayList(threadArrayList);
        // starting threads
        for(int i = 0; i < nOfThreads; i++){
            Thread currentThread = threadArrayList.get(i);
            currentThread.start();
        }
        // waiting for threads to finish
        for(int i = 0; i < nOfThreads; i++){
            try {
                threadArrayList.get(i).join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        char resultChar = DataUtilSingleThread.mostFrequentChar(); 
        System.out.println("Cel mai intalnit caracter este " + resultChar);
    }
}
