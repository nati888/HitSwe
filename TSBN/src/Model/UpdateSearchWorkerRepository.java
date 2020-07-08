package Model;

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
        Departments departments_list=Departments.getMySingelton();
        Jobs jobs_list=Jobs.getMySingelton();
        Workers worker_list=Workers.getMySingelton();
        Worker worker=worker_list.searchingWorkerById(ID);
        return new Object[] {worker.getLast_name(), worker.getFirst_name(),worker.getIDperson(),worker.getMail(),departments_list.searchingDepartmentById(worker.getDepartment_ID()).getName(),jobs_list.searchingJobById(worker.getJob_ID()).getJob_Name(),worker.getExperience(),worker.getBase_Salary(),worker.getUser_name(),worker.getPassword()};
    }

    public String updateWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password){
        Workers worker_list=Workers.getMySingelton();
        Worker worker1=worker_list.searchingWorkerById(ID);
        worker1.setMail(mail);
        worker1.changeDepartmentID(Integer.parseInt(department_id));
        worker1.changeJobID(Integer.parseInt(Job_ID));
        worker1.changeSalary(Float.parseFloat(base_salary));
        worker1.changePassword(password);
        worker1.changeUserName(user_name);
        worker1.changeExperience((Float.parseFloat(experience)));
        return UUID.randomUUID().toString();
    }
}
