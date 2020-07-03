package Model;
import java.util.ArrayList;
import java.util.UUID;

public class AddWorkerRepository {

    private static AddWorkerRepository Instance;
    private AddWorkerRepository() { }

    public static AddWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new AddWorkerRepository();
        return Instance;
    }

    public String addWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password){
        Workers worker_list=Workers.getMySingelton();
        Worker worker=new Worker( last_name, first_name, Integer.parseInt(ID),  mail, Integer.parseInt(department_id),  Integer.parseInt(Job_ID),Integer.parseInt(experience), Integer.parseInt(base_salary), user_name,  password);
        worker_list.addWorker(worker);
        return UUID.randomUUID().toString();
    }

}
