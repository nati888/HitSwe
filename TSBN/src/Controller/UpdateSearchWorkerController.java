package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class UpdateSearchWorkerController {
    Workers worker_list=Workers.getMySingelton();
    private static UpdateSearchWorkerController Instance;
    private UpdateSearchWorkerRepository UpdateWorker= UpdateSearchWorkerRepository.getMySingelton();
    public UpdateSearchWorkerController() {
    }
    public static UpdateSearchWorkerController getMySingelton(){
        if(Instance==null)
            Instance=new UpdateSearchWorkerController();
        return Instance;
    }

    public boolean checkID(String ID) throws AlreadyExistException {
        if (ID.trim().equals("")) //check if its empty
            return false;
        if(worker_list.searchingWorkerById(ID)==null)//check if exist worker whit the user name that entered in the worker list
            throw new AlreadyExistException("ID" +ID +"is not exist" );
        return true;
    }

    public Object[] getWorker(String ID)  {
        return UpdateWorker.getworker(ID);
    }

    public boolean UpdateWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password)  {

        if(UpdateWorker.updateWorker(last_name,first_name,ID, mail,department_id, Job_ID, experience, base_salary , user_name, password)==null)
            return false;
        return true;

    }
}

