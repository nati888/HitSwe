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


    public void addWorker(Worker new_worker){
        worker_List.add(new_worker);
    }

  public  void removeWorker(Worker remove_worker) throws IOException {
        worker_List.remove(remove_worker);
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
    public Boolean SearchingWorkerUserIdBool(String user_name, int id){
        Workers worker_list=Workers.getMySingelton();
//        Worker worker= new WorkerBuilder().Last_name("irani").First_name("sapir").ID(315424283).Mail("sapir@gmail.com").Department_id(5).Job_ID(2).Experience(105).Base_salary(52).User_name("sapir").Password("irani").createWorker();
//        worker_list.addWorker(worker);
//        worker.setHours(5);
      //  System.out.println(worker_list.getWorker_i(0).getJob_ID());
        for (int i = 0; i < worker_list.getSize(); i++)
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name) &&(worker_list.getWorker_i(i).getIDperson()!=id) )
                return true;
        return false;
    }

        public Boolean SearchingWorkerBool(String user_name){
            Workers worker_list=Workers.getMySingelton();
            Worker worker= new WorkerBuilder().Last_name("irani").First_name("sapir").ID(315424283).Mail("sapir@gmail.com").Department_id(5).Job_ID(2).Experience(105).Base_salary(52).User_name("sapir").Password("irani").createWorker();
            worker_list.addWorker(worker);
            worker.setHours(5);
            System.out.println(worker_list.getWorker_i(0).getJob_ID());
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
