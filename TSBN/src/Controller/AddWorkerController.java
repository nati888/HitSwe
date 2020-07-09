package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;

public class AddWorkerController {

    Workers worker_list=Workers.getMySingelton();

    private static AddWorkerController Instance;
    private AddWorkerRepository add_worker_repository = AddWorkerRepository.getMySingelton(); // initialize add worker repository object
    public static AddWorkerController getMySingelton() { // create singelton
        if (Instance == null)
            Instance = new AddWorkerController();
        return Instance;
    }
    public boolean add(String last_name, String first_name, String ID, String mail, String department_id, String Job_ID, String experience, String base_salary, String user_name, String password)
        throws AlreadyExistException {

        if (last_name.trim().equals("") || first_name.trim().equals("") || ID.trim().equals("") || mail.trim().equals("") || department_id.trim().equals("") || Job_ID.trim().equals("") || experience.trim().equals("") || base_salary.trim().equals("") || user_name.trim().equals("") || password.trim().equals(""))//check if one of the details entered is empty

            return false;

        String session = add_worker_repository.addWorker(last_name, first_name, ID, mail, department_id, Job_ID, experience, base_salary, user_name, password);// call to the repository object
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}