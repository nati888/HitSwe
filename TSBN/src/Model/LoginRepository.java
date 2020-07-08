package Model;
import java.util.ArrayList;
import java.util.UUID;


public class LoginRepository {

    private static LoginRepository Instance;
    private LoginRepository() { }

    public static LoginRepository getMySingelton(){
        if(Instance==null)
            Instance=new LoginRepository();
        return Instance;
    }

    public String validateUser(String user_name,String password){
        File.fileRead();
        Workers worker_list=Workers.getMySingelton();
        for (int i = 0; i < worker_list.getSize(); i++)
            if (worker_list.getWorker_i(i).getUser_name().equals(user_name) && worker_list.getWorker_i(i).getPassword().equals(password))
                return UUID.randomUUID().toString();;
        return null;
    }
}
