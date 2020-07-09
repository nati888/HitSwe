package Model;


        import java.io.IOException;
        import java.util.ArrayList;

public class Ex_Workers {
    private static Ex_Workers Instance=new Ex_Workers();
    private static ArrayList<Ex_Worker> ex_worker_List=new ArrayList<Ex_Worker>();
    private Ex_Workers() { // create singelton
    }

    public static Ex_Workers getMySingelton(){
        return Instance;
    }

    public void addWorker(Ex_Worker new_worker){
        ex_worker_List.add(new_worker);
    }

    public  void removeWorker(Ex_Worker remove_worker) throws IOException {
        ex_worker_List.remove(remove_worker);
    }

    public Ex_Worker searchingWorkerById(String ID){ // search ex worker in the list based on id
        Ex_Workers ex_worker_List=Ex_Workers.getMySingelton();
        for (int i=0;i<this.ex_worker_List.size();i++)
            if(ex_worker_List.getWorker_i(i).getIDperson()==Integer.parseInt(ID))
                return ex_worker_List.getWorker_i(i);
        return null;
    }
    public  Ex_Worker getWorker_i(int i){ return ex_worker_List.get(i); // get ex worker in index i
    }

    public Boolean SearchingWorkerBool(int ID){ // check if there is exist ex worker with the required id , return boolean
        Ex_Workers ex_worker_List=Ex_Workers.getMySingelton();
        for (int i=0;i<ex_worker_List.getSize();i++)
            if(ex_worker_List.getWorker_i(i).getIDperson()==ID)
                return true;
        return false;
    }

    public int getSize(){
        return ex_worker_List.size();
    } // get the size of the list
    public void setWorker_List_i(int i, Ex_Worker new_worker){ // set ex worker in index i
        ex_worker_List.set(i,new_worker);}

}
