import java.util.ArrayList;

public interface ThreadGenerator {

    static ArrayList<Thread> generateThreads(int nOfThreads, ArrayList<DataUtilThread> myRunnableList){
        ArrayList<Thread> threadArrayList = new ArrayList<>();

        for(int i = 0; i < nOfThreads; i++){
            threadArrayList.add(new Thread(myRunnableList.get(i)));
        }

        return threadArrayList;
    }
}
