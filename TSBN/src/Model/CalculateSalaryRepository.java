//package Model;
//
//import java.io.IOException;
//        import java.util.ArrayList;
//        import java.util.UUID;
//
//public class CalculateSalaryRepository {
//
//    private static CalculateSalaryRepository Instance;
//    private CalculateSalaryRepository() { }
//
//    public static CalculateSalaryRepository getMySingelton(){
//        if(Instance==null)
//            Instance=new CalculateSalaryRepository();
//        return Instance;
//    }
//
//    public String calculateSalary(String ID) throws IOException {
//        Workers worker_list=Workers.getMySingelton();
//        Worker worker=worker_list.searchingWorker(Integer.parseInt(ID));
//        if (worker==null)
//            return null;
//        worker_list.removeWorker(worker);
//        return UUID.randomUUID().toString();
//    }
//
//}
