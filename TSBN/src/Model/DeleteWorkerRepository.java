package Model;

import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;

public class DeleteWorkerRepository {
    Workers worker_list=Workers.getMySingelton();
    private static DeleteWorkerRepository Instance;
    private DeleteWorkerRepository() { }

    public static DeleteWorkerRepository getMySingelton(){ // create singelton
        if(Instance==null)
            Instance=new DeleteWorkerRepository();
        return Instance;
    }

    public String deleteWorker(String ID) throws IOException {
        Worker worker1=worker_list.searchingWorkerById(ID); // check if there is a worker with the required id
        Ex_Workers ex_worker_list=Ex_Workers.getMySingelton();
        if (worker1==null) // return null if there is not worker with the required id
            return null;
        Ex_Worker ex_worker1=new Ex_Worker(worker1.getLast_name(),worker1.getFirst_name(),worker1.getIDperson(),worker1.getMail(),worker1.getNum_Worker(),worker1.getDepartment_ID(),worker1.getExperience(),worker1.getJob_ID());// create a new object of ex worker
        ex_worker_list.addWorker(ex_worker1); // add ex worker to the list
        File_Ex.fileWrite(); // write to the file
        worker_list.removeWorker(worker1);
        File.fileWrite(); // write to the file

        return UUID.randomUUID().toString();
    }

}