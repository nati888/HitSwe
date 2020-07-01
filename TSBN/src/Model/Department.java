package Model;

import Model.Worker;

import java.util.ArrayList;

public class Departments {
    private int ID;
    private  String Name;
    private ArrayList<Worker> Workers;

    public Departments(int id, String name, ArrayList<Worker> Workres) {
        this.ID = id;
        this.Name = name;
        this.Workers = new ArrayList<Worker>();
    }

    int getID(){ return ID;}
    String getName(){return Name;}
    ArrayList<Worker> getWorkers(){return Workers;}
    void changeDepartmentName(String new_name){Name=new_name;}
    void addWorker(Worker new_worker){
        Workers.add(new_worker);
    }
    void removeWorker(Worker remove_worker) {
        Workers.remove(remove_worker);
    }
//    void create_report(){
//
//    }

}
