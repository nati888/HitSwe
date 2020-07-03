package Model;
import java.util.ArrayList;


public class LoginRepository {

    private static LoginRepository Instance;
    private LoginRepository() { }

    public static LoginRepository getMySingelton(){
        if(Instance==null)
            Instance=new LoginRepository();
        return Instance;
    }

    public boolean validateUser(String user_name,String password){
        Workers worker_list=Workers.getMySingelton();
        Worker worker=new Worker("irani","sapir",315424283,"sapir@gmail.com",5,2,105,52,"sapir","irani");
        worker_list.addWorker(worker);
        for (int i = 0; i < worker_list.getSize(); i++)
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name) && worker_list.getWorker_i(i).getPassword().equals(password))
                return true;
        return false;
    }
}
