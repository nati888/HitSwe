package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class UpdateSearchWorkerController {
    Workers worker_list=Workers.getMySingelton();
    private static UpdateSearchWorkerController Instance;
    private UpdateSearchWorkerRepository UpdateWorker= UpdateSearchWorkerRepository.getMySingelton(); //// initialize update+search repository object
    public UpdateSearchWorkerController() {
    }
    public static UpdateSearchWorkerController getMySingelton(){ // create singelton
        if(Instance==null)
            Instance=new UpdateSearchWorkerController();
        return Instance;
    }

    public boolean checkID(String ID) throws AlreadyExistException {
        if (ID.trim().equals("")) //check if the required id is empty
            return false;
        if(worker_list.searchingWorkerById(ID)==null)//check if exist worker with the user name that entered
            throw new AlreadyExistException("ID" +ID +"is not exist" );
        return true;
    }

    public Object[] getWorker(String ID)  {
        return UpdateWorker.getworker(ID);
    } // call to repository in order to get the worker's details

    public boolean UpdateWorker(String last_name,String first_name,String ID, String mail,String department_id, String Job_ID, String experience, String base_salary , String user_name, String password) throws AlreadyExistException {

        if(UpdateWorker.updateWorker(last_name,first_name,ID, mail,department_id, Job_ID, experience, base_salary , user_name, password)==null) // call to repository in order to check if it is able to update
            return false;
        return true;
    }
}

