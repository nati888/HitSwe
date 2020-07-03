package Model;


import java.io.IOException;
import java.util.ArrayList;

    public class Workers {
    private static Workers Instance=new Workers();
    private static ArrayList<Worker> worker_List=new ArrayList<Worker>();
    private Workers() { }

    public static Workers getMySingelton(){
        return Instance;
    }

    void addWorker(Worker new_worker){
        worker_List.add(new_worker);
//            Excel.add_Worker_To_Excel(new_worker);
    }
    void removeWorker(Worker remove_worker) throws IOException {
        worker_List.remove(remove_worker);
//            Excel.fired_Workers_Excel(remove_worker);
//           Excel.clear_Excel();
        for(int i=0;i<worker_List.size();i++){
            Worker worker=this.worker_List.get(i);
//               Excel.add_Worker_To_Excel(worker);

        }
}
    public Worker searchingWorkerById(String ID){
        for (int i=0;i<this.worker_List.size();i++)
            if(worker_List.get(i).getIDperson()==Integer.parseInt(ID))
                return worker_List.get(i);
        return null;
    }
    public Worker searchingWorker(String user_name){
            for (int i=0;i<this.worker_List.size();i++)
                if(worker_List.get(i).getUser_name()==user_name)
                    return worker_List.get(i);
            return null;
        }
    public Boolean SearchingWorkerBool(int ID){
        Workers worker_list=Workers.getMySingelton();
        for (int i=0;i<worker_list.getSize();i++)
            if(worker_list.getWorker_i(i).getIDperson()==ID)
                return true;
        return false;
    }
    public Boolean SearchingWorkerBool(String user_name){
        Workers worker_list=Workers.getMySingelton();
        Worker worker=new Worker("irani","sapir",315424283,"sapir@gmail.com",5,2,105,52,"sapir","irani");
        worker_list.addWorker(worker);
        for (int i = 0; i < worker_list.getSize(); i++)
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name))
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
