package Model;
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
        Worker worker= new WorkerBuilder().Last_name(last_name).First_name(first_name).ID(Integer.parseInt(ID)).Mail(mail).Department_id(Integer.parseInt(department_id)).Job_ID(Integer.parseInt(Job_ID)).Experience(Integer.parseInt(experience)).Base_salary(Integer.parseInt(base_salary)).User_name(user_name).Password(password).createWorker();
        worker_list.addWorker(worker);
        return UUID.randomUUID().toString();
    }

}
