/*package Model;

import java.io.IOException;
        import java.util.UUID;
        import java.util.ArrayList;

public class DeleteWorkerRepository {

    private static DeleteWorkerRepository Instance;
    private DeleteWorkerRepository() { }

    public static DeleteWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new DeleteWorkerRepository();
        return Instance;
    }

    public String deleteWorker(String ID) throws IOException {
        Workers worker_list=Workers.getMySingelton();
        Worker worker=worker_list.searchingWorker(Integer.parseInt(ID));
        if (worker==null)
            return null;
        worker_list.removeWorker(worker);
        return UUID.randomUUID().toString();
    }

}
*/