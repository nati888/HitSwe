package Model;
import Controller.Exception1.AlreadyExistException;

import java.util.UUID;

public class AddWorkerRepository {

    private static AddWorkerRepository Instance;
    private AddWorkerRepository() { }

    public static AddWorkerRepository getMySingelton(){ // create singelton
        if(Instance==null)
            Instance=new AddWorkerRepository();
        return Instance;
    }

    public String addWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password) throws AlreadyExistException {
        Departments departments_list= Departments.getMySingelton(); // get the exists departments
        Jobs jobs_list=Jobs.getMySingelton(); // get the exists jobs
        Workers worker_list=Workers.getMySingelton(); // get the exist workers
        Worker worker= new WorkerBuilder().Last_name(last_name).First_name(first_name).ID(Integer.parseInt(ID)).Mail(mail).Department_id(Integer.parseInt(department_id)).Job_ID(Integer.parseInt(Job_ID)).Experience(Integer.parseInt(experience)).Base_salary(Integer.parseInt(base_salary)).User_name(user_name).Password(password).createWorker();
        if (worker_list.SearchingWorkerBool(Integer.parseInt(ID)))//check if the required ID is already exist
            throw new AlreadyExistException(" ID " + ID + "is already exist");
        if(worker_list.SearchingWorkerUserIdBool(user_name,worker.getIDperson())) //check if the required user name is already exist
            throw new AlreadyExistException("user" + user_name +"is already exist" );
        if(Double.parseDouble(experience)<0) //check if the experience is lower than 0
            throw new AlreadyExistException("Experience can bot be lower than 0" );
        if(Double.parseDouble(base_salary)<30) //check if the base salary is lower than 30
            throw new AlreadyExistException("Base salary can bot be lower than 30" );
        if(!departments_list.SearchingDepartmentBool(Integer.parseInt(department_id)))//check if the required depatment is already exist
            throw new AlreadyExistException("Department:" + department_id +  "not exist");
        if(!(jobs_list.SearchingJobBool(Integer.parseInt(Job_ID)))) //check if the required job is already exist
            throw new AlreadyExistException("Job:" + Job_ID +  "not exist");
        if(!(worker.CheckEmail(mail))) //check if the required mail is valid
            throw new AlreadyExistException("mail:" + mail +  "invalid");
        if (!(worker.checkID(ID))) //check if the required ID is already valid
            throw new AlreadyExistException("The ID must be 9 letters");
        worker_list.addWorker(worker);
        File.fileWrite();
        return UUID.randomUUID().toString();
    }

}
