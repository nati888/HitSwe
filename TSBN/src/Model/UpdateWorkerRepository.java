package Model;

import java.util.UUID;

public class UpdateWorkerRepository {
    private static UpdateWorkerRepository Instance;
    private UpdateWorkerRepository() { }

    public static UpdateWorkerRepository getMySingelton(){
        if(Instance==null)
            Instance=new UpdateWorkerRepository();
        return Instance;
    }

    public String updateWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password){
        Workers worker_list=Workers.getMySingelton();
        Worker worker1=worker_list.searchingWorkerById(ID);
        worker1.changeDepartmentID(Integer.parseInt(department_id));
        worker1.changePassword(password);
        worker1.changeUserName(user_name);
        worker1.changeExperience((Float.parseFloat(experience)));
        return UUID.randomUUID().toString();
    }
}
