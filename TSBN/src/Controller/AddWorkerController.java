package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;

public class AddWorkerController {

    Workers worker_list=Workers.getMySingelton();

    private static AddWorkerController Instance;
    private AddWorkerRepository add_worker_repository = AddWorkerRepository.getMySingelton();
    public static AddWorkerController getMySingelton() {
        if (Instance == null)
            Instance = new AddWorkerController();
        return Instance;
    }
    public boolean add(String last_name, String first_name, String ID, String mail, String department_id, String Job_ID, String experience, String base_salary, String user_name, String password)
        throws AlreadyExistException {

        if (last_name.trim().equals("") || first_name.trim().equals("") || ID.trim().equals("") || mail.trim().equals("") || department_id.trim().equals("") || Job_ID.trim().equals("") || experience.trim().equals("") || base_salary.trim().equals("") || user_name.trim().equals("") || password.trim().equals(""))//check if one of the details is empty
            return false;
        if (worker_list.SearchingWorkerBool(ID))//check if the ID that wants to enter is already exist
            throw new AlreadyExistException(" ID " + ID + "is already exist");
        if(worker_list.SearchingWorkerBool(user_name)) //check if the user name that wants to enter is already exist
            throw new AlreadyExistException("user" + user_name +"is aleady exist" );
        String session = add_worker_repository.addWorker(last_name, first_name, ID, mail, department_id, Job_ID, experience, base_salary, user_name, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}