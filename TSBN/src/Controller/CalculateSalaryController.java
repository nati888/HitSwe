package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class CalculateSalaryController {
    Workers worker_list=Workers.getMySingelton(); // create singelton
    private static CalculateSalaryController Instance;
    private CalculateSalaryRepository CalculateSalary=CalculateSalaryRepository.getMySingelton(); // initialize calculte salary repository object
    public CalculateSalaryController() {
    }
    public static CalculateSalaryController getMySingelton(){ // create singelton
        if(Instance==null)
            Instance=new CalculateSalaryController();
        return Instance;
    }

    public boolean checkID(String ID) throws AlreadyExistException {
        if (ID.trim().equals("") || ID ==null) //check if the required id is empty
            return false;
        if(worker_list.searchingWorkerById(ID)==null)//check if there is exist worker with the user name that entered
            throw new AlreadyExistException("ID" +ID +"is not exist" );
        return true;
    }
    public Object[] CalculateSalary(String ID)  {
        String salary = String.valueOf(CalculateSalary.CalculateSalary(ID)); // call to the repository object
        return new Object[] {salary};
    }
}

