package Model;

public class CalculateSalaryRepository   {

    private static CalculateSalaryRepository Instance=null;
    private Workers worker_list=Workers.getMySingelton();
    private CalculateSalaryRepository() { }

    public static CalculateSalaryRepository getMySingelton(){
        if(Instance==null)
            Instance=new CalculateSalaryRepository();
        return Instance;
    }

    public boolean checkValidId(String ID)
    {
        if(worker_list.searchingWorkerById(ID)==null)
            return false;
        return true;
    }


    public String CalculateSalary(String ID)
    {
        Workers worker_list=Workers.getMySingelton();
        Worker worker=worker_list.searchingWorkerById(ID);
        return String.valueOf(worker.calculateSalary());
    }
}




