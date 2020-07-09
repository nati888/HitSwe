package Model;

public class CalculateSalaryRepository {

    private static CalculateSalaryRepository Instance = null;
    private Workers worker_list = Workers.getMySingelton();

    private CalculateSalaryRepository() {
    }

    public static CalculateSalaryRepository getMySingelton() { // create singelton
        if (Instance == null)
            Instance = new CalculateSalaryRepository();
        return Instance;
    }

    public boolean checkValidId(String ID) { // check if there is worker with the required id
        if (worker_list.searchingWorkerById(ID) == null)
            return false;
        return true;
    }


    public String CalculateSalary(String ID) {
        Workers worker_list = Workers.getMySingelton();
        Worker worker = worker_list.searchingWorkerById(ID);
        return String.valueOf(worker.calculateSalary());
    }

    public boolean CheckCalculateBool(String ID) { // check if the result of calculate salary is not lower than 0
        Workers worker_list = Workers.getMySingelton();
        Worker worker = worker_list.searchingWorkerById(ID);
        double sum = worker.calculateSalary();
        if(sum<0)
            return false;
        return true;
    }
}




