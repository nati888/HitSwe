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

    public Object[] checkValidId(String ID)
    {
        boolean isValidId = true;
        if(worker_list.searchingWorkerById(ID)==null)
            isValidId=false;
        return new Object[] {isValidId};
    }


    public String CalculateSalary(String ID)
    {
        Workers worker_list=Workers.getMySingelton();
        Worker worker=worker_list.searchingWorkerById(ID);
        return String.valueOf(worker.calculateSalary());
    }
}




