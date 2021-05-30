import java.util.ArrayList;

public interface ThreadGenerator {

    static ArrayList<Thread> generateThreads(int nOfThreads){
        Runnable myRunnable = new DataUtilThread();
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for(int i = 0; i < nOfThreads; i++){
            threadArrayList.add(new Thread(myRunnable));
        }

        return threadArrayList;
    }
}
