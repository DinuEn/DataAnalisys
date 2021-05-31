import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    private ArrayList<Thread> threadArrayList = null;
    private int nOfThreads = 0;
    private ArrayList<String> dataList = null;
    private int functionCode;
    private ArrayList<DataUtilThread> runnableList;

    //constructor
    public ThreadManager(int nOfThreads, ArrayList<String> dataList, int functionCode) {
        this.nOfThreads = nOfThreads;
        this.dataList = dataList;
        this.functionCode = functionCode;
        runnableList = new ArrayList<>();
    }

    //initializarea Threadurilor
    public void setThreadArrayList(ArrayList<Thread> threadArrayList) {
        int subListLen = (int) dataList.size() / nOfThreads;
        for (int i = 0; i < nOfThreads; i++) {
            List<String> subList = dataList.subList(subListLen * i, subListLen * (i + 1));
            runnableList.add(new DataUtilThread(subList, functionCode));
        }

        this.threadArrayList = ThreadGenerator.generateThreads(nOfThreads, runnableList);
    }

    //rularea Threadurilor
    public void runThreads() {
        setThreadArrayList(threadArrayList);
        // starting threads
        for (int i = 0; i < nOfThreads; i++) {
            Thread currentThread = threadArrayList.get(i);
            currentThread.start();
        }
        // waiting for threads to finish
        for (int i = 0; i < nOfThreads; i++) {
            try {
                threadArrayList.get(i).join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        int result;
        switch (functionCode) {
            case 0:
                result = avgOfThreads();
                System.out.println("[" + nOfThreads + " Threaduri" + "] Lungimea medie este " + result);
                break;
            case 1:
                result = maxOfThreads();
                System.out.println("[" + nOfThreads + " Threaduri" + "] Lungimea maxima este " + result);
                break;
            case 2:
                result = minOfThreads();
                System.out.println("[" + nOfThreads + " Threaduri" + "] Lungimea minima este " + result);
                break;
            case 3:
                char resultChar = DataUtilSingleThread.mostFrequentChar();
                System.out.println("[" + nOfThreads + " Threaduri" + "] Cel mai intalnit caracter " + resultChar);
                break;
        }
    }

    //functii ce combina rezultatele Threadurilor pentru a obtine rezultatul final
    public int avgOfThreads() {
        int avg = 0;
        for (int i = 0; i < nOfThreads; i++) {
            avg += runnableList.get(i).getResult();
        }
        return (int) avg / nOfThreads;
    }

    public int maxOfThreads() {
        int max = 0;
        for (int i = 0; i < nOfThreads; i++) {
            if (max < runnableList.get(i).getResult()) {
                max = runnableList.get(i).getResult();
            }

        }
        return max;
    }

    public int minOfThreads() {
        int min = runnableList.get(0).getResult();
        for (int i = 0; i < nOfThreads; i++) {
            if (min > runnableList.get(i).getResult()) {
                min = runnableList.get(i).getResult();
            }
        }
        return min;
    }
}
