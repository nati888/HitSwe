package Model;

import Controller.Exception1.AlreadyExistException;

import java.util.UUID;

public class UpdateSearchWorkerRepository {
    private static UpdateSearchWorkerRepository Instance;
    private UpdateSearchWorkerRepository() { }

    public static UpdateSearchWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new UpdateSearchWorkerRepository();
        return Instance;
    }

    public Object[] getworker(String ID)
    {
        Workers worker_list=Workers.getMySingelton();
        Worker worker=worker_list.searchingWorkerById(ID);
        return new Object[] {worker.getLast_name(), worker.getFirst_name(),worker.getIDperson(),worker.getMail(),worker.getDepartment_ID(),worker.getJob_ID(),worker.getExperience(),worker.getBase_Salary(),worker.getUser_name(),worker.getPassword()};
    }

    public String updateWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password) throws AlreadyExistException {
        Workers worker_list = Workers.getMySingelton();
        Worker worker1 = worker_list.searchingWorkerById(ID);

        Departments departments_list= Departments.getMySingelton();
        Jobs jobs_list=Jobs.getMySingelton();
       // Worker worker= new WorkerBuilder().Last_name(last_name).First_name(first_name).ID(Integer.parseInt(ID)).Mail(mail).Department_id(Integer.parseInt(department_id)).Job_ID(Integer.parseInt(Job_ID)).Experience(Integer.parseInt(experience)).Base_salary(Integer.parseInt(base_salary)).User_name(user_name).Password(password).createWorker();
        if(worker_list.SearchingWorkerUserIdBool(user_name,worker1.getIDperson())) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("user" + user_name +"is already exist" );
        if(Double.parseDouble(experience)<0) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Experience can bot be lower than 0" );
        if(Double.parseDouble(base_salary)<30) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("Base salary can bot be lower than 30" );
        if(!(departments_list.SearchingDepartmentBool(Integer.parseInt(department_id)))) //check if the department that wants to enter exists
            throw new AlreadyExistException("Department:" + department_id +  "not exist");
        if(!(jobs_list.SearchingJobBool(Integer.parseInt(Job_ID)))) //check if the job that wants to enter exists
            throw new AlreadyExistException("Job:" + Job_ID +  "not exist");
        if(!(worker1.CheckEmail(mail))) //check if the mail that wants to enter valid
            throw new AlreadyExistException("mail:" + mail +  "invalid");

        worker1.changeExperience((Float.parseFloat(experience)));
        worker1.setMail(mail);
        worker1.changeDepartmentID(Integer.parseInt(department_id));
        worker1.changeJobID(Integer.parseInt(Job_ID));
        worker1.changeSalary(Float.parseFloat(base_salary));
        worker1.changePassword(password);
        worker1.changeUserName(user_name);
        return UUID.randomUUID().toString();


    }
}
