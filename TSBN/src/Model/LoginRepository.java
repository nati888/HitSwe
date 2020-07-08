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
        File.fileRead();
        Workers worker_list=Workers.getMySingelton();
        for (int i = 0; i < worker_list.getSize(); i++)
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name) && worker_list.getWorker_i(i).getPassword().equals(password))
                return true;
        return false;
    }
}
