package Model;
import java.util.ArrayList;
import java.util.UUID;

public class LoginService {
    static private LoginService Instance;
    private LoginRepository loginRepo=LoginRepository.getMySingelton();
    private LoginService(){
    }
    public static LoginService getMySingelton(){
        if(Instance==null)
            Instance=new LoginService();
        return Instance;
    }
    public String login(String user_name,String password){
        if(this.loginRepo.validateUser(user_name, password))
            return UUID.randomUUID().toString();
        return null;
    }
    public boolean CheckMatch(String user_name, String password)
    {
        Workers worker_list=Workers.getMySingelton();
        Worker temp_worker =worker_list.searchingWorker(user_name);
        if(temp_worker.getPassword() == password)
            return true;
        return false;
    }
}
