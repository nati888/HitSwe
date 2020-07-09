package Model;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

    public class Workers {
    private static Workers Instance=new Workers();
    private static ArrayList<Worker> worker_List=new ArrayList<Worker>(); // create a list of workers
    private Workers() {
    }

    public static Workers getMySingelton(){ // create singelton
        return Instance;
    }


    public void addWorker(Worker new_worker){ // add a new worker to the list
        worker_List.add(new_worker);
    }

  public  void removeWorker(Worker remove_worker) throws IOException { // remove worker from the list
        worker_List.remove(remove_worker);
        }

    public Worker searchingWorkerById(String ID){ // get worker's data based on required id
        for (int i=0;i<this.worker_List.size();i++)
            if(worker_List.get(i).getIDperson()==Integer.parseInt(ID))
                return worker_List.get(i);
        return null;
    }
    public Worker searchingWorker(String user_name){ // get worker's data based on required user name
            for (int i=0;i<this.worker_List.size();i++)
                if(worker_List.get(i).getUser_name()==user_name)
                    return worker_List.get(i);
            return null;
        }
    public Boolean SearchingWorkerBool(int ID){ // search if there is exist worker based on required id
        Workers worker_list=Workers.getMySingelton();
        for (int i=0;i<worker_list.getSize();i++)
            if(worker_list.getWorker_i(i).getIDperson()==ID)
                return true;
        return false;
    }
    public Boolean SearchingWorkerUserIdBool(String user_name, int id){ // search if there is exist worker with the required user name, expect from the current worker
        Workers worker_list=Workers.getMySingelton();
        for (int i = 0; i < worker_list.getSize(); i++)
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name) &&(worker_list.getWorker_i(i).getIDperson()!=id) )
                return true;
        return false;
    }
        public Boolean SearchingWorkerBool(String user_name){ // search if there is exist worker with the required user name
            Workers worker_list=Workers.getMySingelton();
            for (int i = 0; i < worker_list.getSize(); i++)
                if (worker_list.getWorker_i(i).getUser_name().equals(user_name) )
                    return true;
            return false;
        }
    public int getSize(){
        return worker_List.size();
    }
    public  Worker getWorker_i(int i){
        return worker_List.get(i);
    }
    public void setWorker_List_i(int i,Worker new_worker){
        worker_List.set(i,new_worker);}
    public double calculateSalaryById(String ID){
        Worker worker=searchingWorker(ID);
        return worker.calculateSalary();
    }
  }
