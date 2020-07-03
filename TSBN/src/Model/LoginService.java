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
}
