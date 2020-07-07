package Controller;
import Controller.Exception1.AlreadyExistException;
import Model.*;


public class CalculateSalaryController {
    Workers worker_list=Workers.getMySingelton();
    private static CalculateSalaryController Instance;
    private CalculateSalaryRepository CalculateSalary=CalculateSalaryRepository.getMySingelton();
    public CalculateSalaryController() {
    }
    public static CalculateSalaryController getMySingelton(){
        if(Instance==null)
            Instance=new CalculateSalaryController();
        return Instance;
    }

    public boolean checkID(String ID) throws AlreadyExistException {
        if (ID.equals("")) //check if its empty
            return false;
        if(worker_list.searchingWorkerById(ID)==null)//check if exist worker whit the user name that entered in the worker list
            throw new AlreadyExistException("ID" +ID +"is not exist" );
        return true;
    }
    public Object[] CalculateSalary(String ID)  {

        String salary = String.valueOf(CalculateSalary.CalculateSalary(ID));
        return new Object[] {salary};
    }
}

