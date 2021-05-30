import java.util.ArrayList;

public class ThreadManager {
    private ArrayList<Thread> threadArrayList = null;
    private int nOfThreads = 0;
    private ArrayList<String> dataList= null;
    private int opCode = 0;


    public ThreadManager(int nOfThreads, ArrayList<String> dataList, int opCode, int functionCode) {
        this.nOfThreads = nOfThreads;
        this.dataList = dataList;
        this.opCode = opCode;
    }


    public void setThreadArrayList(ArrayList<Thread> threadArrayList) {
            ArrayList<DataUtilThread> runnableList= new ArrayList<>();

            for(int i = 0; i < nOfThreads; i++){
                ArrayList<String> subList = (ArrayList<String>) dataList.subList(dataList.size()*i,dataList.size()*(i+1)) ;
                runnableList.add(new DataUtilThread(subList, opCode ));
            }

        this.threadArrayList = ThreadGenerator.generateThreads(nOfThreads, runnableList);
    }

    public void runThreads(){

        for(int i = 0; i < nOfThreads; i++){
            Thread currentThread = threadArrayList.get(i);
            currentThread.start();
        }
    }
}
