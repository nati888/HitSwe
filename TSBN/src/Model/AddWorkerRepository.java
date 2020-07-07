package Model;
import Controller.Exception1.AlreadyExistException;

import java.util.UUID;

public class AddWorkerRepository {

    private static AddWorkerRepository Instance;
    private AddWorkerRepository() { }

    public static AddWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new AddWorkerRepository();
        return Instance;
    }

    public String addWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password) throws AlreadyExistException {
        Workers worker_list=Workers.getMySingelton();
        Worker worker= new WorkerBuilder().Last_name(last_name).First_name(first_name).ID(Integer.parseInt(ID)).Mail(mail).Department_id(Integer.parseInt(department_id)).Job_ID(Integer.parseInt(Job_ID)).Experience(Integer.parseInt(experience)).Base_salary(Integer.parseInt(base_salary)).User_name(user_name).Password(password).createWorker();
        if (worker_list.SearchingWorkerBool(ID))//check if the ID that wants to enter is already exist
            throw new AlreadyExistException(" ID " + ID + "is already exist");
        if(worker_list.SearchingWorkerBool(user_name)) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("user" + user_name +"is already exist" );
        if(Double.parseDouble(experience)<0) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Experience can bot be lower than 0" );
        if(Double.parseDouble(base_salary)<30) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Base salary can bot be lower than 30" );
        worker_list.addWorker(worker);
        return UUID.randomUUID().toString();
    }

}
