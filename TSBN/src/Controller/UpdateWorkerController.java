package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class UpdateWorkerController {
    Workers worker_list=Workers.getMySingelton();
    private static UpdateWorkerController Instance;
    private UpdateWorkerRepository UpdateWorker=UpdateWorkerRepository.getMySingelton();
    public UpdateWorkerController() {
    }
    public static UpdateWorkerController getMySingelton(){
        if(Instance==null)
            Instance=new UpdateWorkerController();
        return Instance;
    }

    public boolean checkID(String ID) throws AlreadyExistException {
        if (ID.equals("")) //check if its empty
            return false;
        if(worker_list.searchingWorkerById(ID)==null)//check if exist worker whit the user name that entered in the worker list
            throw new AlreadyExistException("ID" +ID +"is not exist" );
        return true;
    }
    public boolean UpdateWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password)  {

        if(UpdateWorker.updateWorker(last_name,first_name,ID, mail,department_id, Job_ID, experience, base_salary , user_name, password)==null)
            return false;
        return true;

    }
}

