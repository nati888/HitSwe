package Model;

import java.util.UUID;
import java.util.ArrayList;

public class SearchingWorkerRepository {

    private static SearchingWorkerRepository Instance;
    private SearchingWorkerRepository() { }
    public static SearchingWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new SearchingWorkerRepository();
        return Instance;
    }
    public Worker searchingWorker(String ID){
        Workers worker_list=Workers.getMySingelton();
        Worker worker=worker_list.searchingWorker(ID);
        if (worker==null)
            return null;
        return worker;
    }
}
