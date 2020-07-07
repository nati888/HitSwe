package Model;

import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;

public class DeleteWorkerRepository {
    Workers worker_list=Workers.getMySingelton();
    private static DeleteWorkerRepository Instance;
    private DeleteWorkerRepository() { }

    public static DeleteWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new DeleteWorkerRepository();
        return Instance;
    }

    public String deleteWorker(String ID) throws IOException {
       // Worker worker=new Worker("irani","sapir",315424283,"sapir@gmail.com",5,2,105,52,"ben","irani");
       // Worker worker2=new Worker("irani","sapir",208956052,"sapir@gmail.com",5,2,105,52,"ben","irani");
    //    worker_list.addWorker(worker);
    //    worker_list.addWorker(worker2);
       // System.out.println(worker_list.getWorker_i(0).getUser_name());
        Worker worker1=worker_list.searchingWorkerById(ID);
        if (worker1==null)
            return null;
        worker_list.removeWorker(worker1);
        return UUID.randomUUID().toString();
    }

}