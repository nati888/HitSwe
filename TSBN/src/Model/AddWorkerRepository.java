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
        Departments departments_list= Departments.getMySingelton();
        Jobs jobs_list=Jobs.getMySingelton();
        Workers worker_list=Workers.getMySingelton();
        Worker worker= new WorkerBuilder().Last_name(last_name).First_name(first_name).ID(Integer.parseInt(ID)).Mail(mail).Department_id(Integer.parseInt(department_id)).Job_ID(Integer.parseInt(Job_ID)).Experience(Integer.parseInt(experience)).Base_salary(Integer.parseInt(base_salary)).User_name(user_name).Password(password).createWorker();
        if (worker_list.SearchingWorkerBool(Integer.parseInt(ID)))//check if the ID that wants to enter is already exist
            throw new AlreadyExistException(" ID " + ID + "is already exist");
        if(worker_list.SearchingWorkerUserIdBool(user_name,worker.getIDperson())) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("user" + user_name +"is already exist" );
        if(Double.parseDouble(experience)<0) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Experience can bot be lower than 0" );
        if(Double.parseDouble(base_salary)<30) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Base salary can bot be lower than 30" );
        if(departments_list.SearchingDepartmentBool(Integer.parseInt(department_id))) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Department:" + department_id +  "not exist");
        if(jobs_list.SearchingJobBool(Integer.parseInt(Job_ID))) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Job:" + Job_ID +  "not exist");
        if(worker.CheckEmail(mail)) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("mail:" + mail +  "invalid");
        if (worker.checkID(ID)) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("The ID must be 9 letters");
        worker_list.addWorker(worker);
        return UUID.randomUUID().toString();
    }

}
