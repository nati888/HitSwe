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

        if (last_name.equals("") || first_name.equals("") || ID.equals("") || mail.equals("") || department_id.equals("") || Job_ID.equals("") || experience.equals("") || base_salary.equals("") || user_name.equals("") || password.equals(""))
            return false;
        if (!worker_list.SearchingWorkerBool(Integer.parseInt(ID)))
            throw new AlreadyExistException("the ID is already exist");
        String session = add_worker_repository.addWorker(last_name, first_name, ID, mail, department_id, Job_ID, experience, base_salary, user_name, password);
        if (session != null) {
            System.out.println("Session token: " + session);
            return true;
        }
        return false;
    }
}